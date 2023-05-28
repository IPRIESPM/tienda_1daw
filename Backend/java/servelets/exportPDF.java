package servelets;

import DAO.FacturaDAO;
import DTO.DireccionDTO;
import DTO.FacturaDTO;
import DTO.ProductoDTO;
import DTO.UsuarioDTO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.System.out;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.shopSession;

/**
 *
 * @author isaac
 */
public class exportPDF extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static final Font totalBold = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        out.println("generando factura");
        response.setHeader("Content-disposition", "filename=factura.pdf");

        Object sesionUsuario = request.getSession().getAttribute("usuario");

        UsuarioDTO usuarioSesion = shopSession.checkUsuario(sesionUsuario);

        try (ServletOutputStream out = response.getOutputStream()) {
            // Recogemos el codigo de factura que se solicita exportar
            if (request.getParameter("id") != null && request.getParameter("id").chars().allMatch(Character::isDigit)) {
                int codigo = Integer.parseInt(request.getParameter("id"));
                FacturaDTO factura = new FacturaDAO().getByCodigo(codigo);
                // Si la factura existe en la BD y además está asociada al mismo usuario que hay en la sesión entonces exportamos (excepto si es admin)
                if (usuarioSesion != null && factura != null && (usuarioSesion.isAdmin() || factura.getPedido().getUsuario().equals(usuarioSesion))) {
                    response.setHeader("Content-disposition", "filename=factura" + factura.getCodigo() + ".pdf");
                    createPDF(out, factura);
                } else {
                    request.getSession().setAttribute("error", "Tu programa ha fallado con exito, al cargar la factura.");
                    response.sendRedirect("/verFacturas");
                }
            } else {
                request.getSession().setAttribute("error", "Tu programa ha fallado con exito, al cargar la factura.");
                response.sendRedirect("/verFacturas");
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }

    }

    public static String moneda(double valor) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.ITALY);
        return currency.format(valor) + " ";
    }

    public void createPDF(OutputStream os, FacturaDTO factura) {
        try {

            Document document = new Document();
            PdfWriter.getInstance(document, os);
            document.open();
            document.addTitle("Factura " + factura.getCodigo());
            document.addAuthor("Beatrix LeBeau");

            // Primera página
            Chunk chunk = new Chunk("Factura nº " + factura.getCodigo(), chapterFont);
            chunk.setBackground(BaseColor.LIGHT_GRAY);
            // Let's create de first Chapter (Creemos el primer capítulo)
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);

            UsuarioDTO cliente = factura.getPedido().getUsuario();
            DireccionDTO direccion = cliente.getDireccion();
            chapter.add(new Paragraph(" ", subcategoryFont));
            chapter.add(new Paragraph("Datos del cliente:", subcategoryFont));
            chapter.add(new Paragraph("Nº cliente: " + cliente.getCodigo(), paragraphFont));
            chapter.add(new Paragraph("Nombre: " + cliente.getFullName(), paragraphFont));
            chapter.add(new Paragraph("E-mail: " + cliente.getEmail(), paragraphFont));
            chapter.add(new Paragraph("Teléfono: " + cliente.getTelefono(), paragraphFont));
            chapter.add(new Paragraph("Datos de la factura:", subcategoryFont));
            chapter.add(new Paragraph("Fecha: " + factura.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), paragraphFont));
            chapter.add(new Paragraph("Dirección de facturación: " + cliente.getFullName() + " - " + cliente.getDireccion().getDireccion() + " (" + direccion.getProvincia() + ") ", paragraphFont));
            chapter.add(new Paragraph("Dirección de envío: " + direccion.getDireccion() + " - " + direccion.getCiudad() + " (" + direccion.getProvincia() + ") ", paragraphFont));

            chapter.add(new Paragraph("Líneas del pedido:", subcategoryFont));
            chapter.add(new Paragraph(" ", subcategoryFont));

            Integer numColumns = 6;
            // Creamos la tabla.
            PdfPTable table = new PdfPTable(numColumns);
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            // rellenamos las filas de la tabla

            columnHeader = new PdfPCell(new Phrase("CÓDIGO", smallBold));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase(" NOMBRE ", smallBold));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase(" PRECIO ", smallBold));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("I.V.A.", smallBold));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase("CANTIDAD", smallBold));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            columnHeader = new PdfPCell(new Phrase(" IMPORTE ", smallBold));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);

            table.setHeaderRows(1);

            // rellenamos las filas de la tabla.
            for (Map.Entry<ProductoDTO, Integer> linea : factura.getPedido().getProductos().entrySet()) {
                PdfPCell cell = new PdfPCell(Paragraph.getInstance(linea.getKey().getCodigo() + " "));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(Paragraph.getInstance(linea.getKey().getNombre()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(Paragraph.getInstance(moneda(linea.getKey().getPrecio())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);
                cell = new PdfPCell(Paragraph.getInstance("15% "));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);
                cell = new PdfPCell(Paragraph.getInstance(linea.getValue() + " "));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);
                cell = new PdfPCell(Paragraph.getInstance(moneda((linea.getKey().getTotalPriceTax() * linea.getValue()))));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

            }

            table.setWidthPercentage(100);

            chapter.add(table);
            chapter.add(new Paragraph(" ", chapterFont));
            Paragraph paragraf = new Paragraph("BASE IMPONIBLE: " + moneda((factura.getPedido().getPrecioTotal())), paragraphFont);
            paragraf.setAlignment(Element.ALIGN_RIGHT);
            chapter.add(paragraf);
            paragraf = new Paragraph("TOTAL FACTURA: " + moneda(factura.getPedido().getTotalPriceTax()), totalBold);
            paragraf.setAlignment(Element.ALIGN_RIGHT);
            chapter.add(paragraf);

            document.add(chapter);
            document.close();
            System.out.println("Your PDF file has been generated!");
            out.println("Your PDF file has been generated!");
        } catch (DocumentException ex) {
            Logger.getLogger(exportPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
