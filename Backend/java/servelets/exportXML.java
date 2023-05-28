/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelets;

import DAO.FacturaDAO;
import DTO.DireccionDTO;
import DTO.FacturaDTO;
import DTO.PedidoDTO;
import DTO.ProductoDTO;
import DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.utils;

/**
 *
 * @author isaac
 */
public class exportXML extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        boolean errorFactura = false;
        // Recogemos al ususuario que está en la sesión
        HttpSession session = request.getSession(false);
        UsuarioDTO usuarioSesion = (session != null && session.getAttribute("usuario") != null) ? (UsuarioDTO) session.getAttribute("usuario") : null;
        try (PrintWriter out = response.getWriter()) {
            try {
                // Recogemos el codigo de factura que se solicita exportar
                if (request.getParameter("id") != null && request.getParameter("id").chars().allMatch(Character::isDigit)) {
                    int codigo = Integer.parseInt(request.getParameter("id"));
                    FacturaDTO factura = new FacturaDAO().getByCodigo(codigo);
                    // Si la factura existe en la BD y además está asociada al mismo usuario que hay en la sesión entonces exportamos (excepto si es admin)
                    if (usuarioSesion != null && factura != null && (usuarioSesion.isAdmin() || factura.getPedido().getUsuario().equals(usuarioSesion))) {
                        PedidoDTO pedido = factura.getPedido();
                        UsuarioDTO usuario = pedido.getUsuario();
                        DireccionDTO direccion = usuario.getDireccion();

                        response.setContentType("text/plain;charset=UTF-8");
                        out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
                        out.println("<factura codigo_factura=\"" + factura.getCodigo() + "\">");

                        out.println("\t<fecha>");
                        out.println("\t\t<dia>" + factura.getFecha().getDayOfMonth() + "</dia>");
                        out.println("\t\t<mes>" + factura.getFecha().getMonthValue() + "</mes>");
                        out.println("\t\t<anyo>" + factura.getFecha().getYear() + "</anyo>");
                        out.println("\t\t<hora>" + factura.getFecha().getHour() + "</hora>");
                        out.println("\t\t<minuto>" + factura.getFecha().getMinute() + "</minuto>");
                        out.println("\t\t<segundo>" + factura.getFecha().getSecond() + "</segundo>");
                        out.println("\t</fecha>");

                        out.println("\t<direccion_facturacion>");
                        out.println("\t\t<direccion>" + direccion.getDireccion() + "</direccion>");
                        out.println("\t\t<poblacion>" + direccion.getCiudad() + "</poblacion>");
                        out.println("\t\t<provincia>" + direccion.getProvincia() + "</provincia>");
                        out.println("\t</direccion_facturacion>");

                        out.println("\t<pedido_asociado codigo_pedido=\"" + pedido.getCodigo() + "\">");
                        out.println("\t\t<cliente>" + usuario.getFullName() + "</cliente>");
                        out.println("\t\t<direccion_envio>");
                        out.println("\t\t\t<direccion>" + direccion.getDireccion() + "</direccion>");
                        out.println("\t\t\t<poblacion>" + direccion.getCiudad() + "</poblacion>");
                        out.println("\t\t\t<provincia>" + direccion.getProvincia() + "</provincia>");
                        out.println("\t\t</direccion_envio>");
                        out.println("\t\t<lineas>");

                        HashMap<ProductoDTO, Integer> lineas = pedido.getProductos();
                        for (Map.Entry<ProductoDTO, Integer> linea : lineas.entrySet()) {
                            out.println("\t\t\t<producto codigo_producto=\"" + linea.getKey().getCodigo() + "\">");
                            out.println("\t\t\t\t<nombre>" + linea.getKey().getNombre() + "</nombre>");
                            out.println("\t\t\t\t<precio_unitario>" + (linea.getKey().getPrecio()) + "</precio_unitario>");
                            out.println("\t\t\t\t<iva> 15% </iva>");
                            out.println("\t\t\t\t<cantidad_productos>" + linea.getValue() + "</cantidad_productos>");
                            out.println("\t\t\t\t<total_linea>" + round(linea.getValue() * linea.getKey().getPrecio()) + "</total_linea>");
                            out.println("\t\t\t\t<total_linea_con_iva>" + round(linea.getValue() * linea.getKey().getPrecio() * 1.15) + "</total_linea_con_iva>");
                            out.println("\t\t\t</producto>");
                        }

                        out.println("\t\t</lineas>");
                        out.println("\t</pedido_asociado>");

                        out.println("\t<base_imponible>" + utils.round(pedido.getPrecioTotal()) + "</base_imponible>");
                        out.println("\t<total>" + round(pedido.getTotalPriceTax()) + "</total>");
                        out.println("</factura>");
                        response.setHeader("Content-Disposition", "attachment; filename=\"Factura" + factura.getCodigo() + ".xml\"");

                    } else {
                        errorFactura = true;
                    }

                } else {
                    errorFactura = true;
                }

                if (errorFactura) {
                    request.getSession().setAttribute("error", "Tu programa ha fallado con exito, al cargar el XML.");
                    response.sendRedirect("/verFacturas");
                }
            } catch (SQLException e) {
                request.getSession().setAttribute("error", "Tu programa ha fallado con exito, con la BBDD.");
                response.sendRedirect("/verFacturas");
            }
        }

    }

    double round(double value) {
        return Math.round(value * 100.0) / 100.0;
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
