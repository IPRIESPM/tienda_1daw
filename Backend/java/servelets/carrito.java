package servelets;

import DAO.PedidoDAO;
import DAO.ProductoDAO;
import DTO.PedidoDTO;
import DTO.ProductoDTO;
import DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.shopSession;

/**
 *
 * @author isaac
 */
public class carrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            UsuarioDTO tiendaUsuario = shopSession.checkUsuario(request.getSession().getAttribute("usuario"));
            PedidoDTO tiendaCarrito = shopSession.checkCarrito(request.getSession().getAttribute("carrito"));

            if (tiendaUsuario.isAdmin() || tiendaUsuario.isGuest()) {
                request.getSession().setAttribute("error", "No tienes permiso para acceder aquí.");
                response.sendRedirect("index.jsp");

            } else {

                String options = utils.utils.checkParam(request.getParameter("carrito"));
                int line = utils.utils.checkParamInt(request.getParameter("line"));

                if (options.equals("ver")) {
                    response.sendRedirect("verCarrito.jsp");
                    return;
                }

                if (options.equals("del")) {

                    LinkedHashMap viejoCarrito = tiendaCarrito.getProductos();

                    ProductoDTO productoEliminar = new ProductoDTO(line);

                    viejoCarrito.remove(productoEliminar);

                    tiendaCarrito.setProductos(viejoCarrito);
                    request.getSession().setAttribute("carrito", tiendaCarrito);

                    response.sendRedirect("verCarrito.jsp");
                    return;

                }

                if (options.equals("mod")) {

                    int value = Integer.parseInt(request.getParameter("value"));

                    LinkedHashMap viejoCarrito = tiendaCarrito.getProductos();

                    ProductoDTO key = new ProductoDTO(line);

                    viejoCarrito.replace(key, value);
                    tiendaCarrito.setProductos(viejoCarrito);
                    request.getSession().setAttribute("carrito", tiendaCarrito);
                    response.sendRedirect("verCarrito.jsp");
                    return;
                }
                if (options.equals("add") && request.getParameter("product") != null) {

                    int codigo = utils.utils.checkParamInt(request.getParameter("product"));

                    ProductoDTO producto = new ProductoDAO().getByCodigo(codigo);
                    producto.setStock(1);

                    tiendaCarrito.addLines(producto);

                    request.getSession().setAttribute("carrito", tiendaCarrito);

                    response.sendRedirect("./verProductos");
                    return;
                }

                if (options.equals("makeOrder")) {
                    PedidoDTO newOrder = (PedidoDTO) request.getSession().getAttribute("carrito");
                    new PedidoDAO().anyadir(newOrder);

                }
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(carrito.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(carrito.class.getName()).log(Level.SEVERE, null, ex);
        }
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
