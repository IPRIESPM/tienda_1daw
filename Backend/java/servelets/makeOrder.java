package servelets;

import DAO.PedidoDAO;
import DTO.PedidoDTO;
import DTO.ProductoDTO;
import DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;
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
public class makeOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            UsuarioDTO user = shopSession.checkUsuario(request.getSession().getAttribute("usuario"));
            PedidoDTO shoppingCart = shopSession.checkCarrito(request.getSession().getAttribute("carrito"));

            if (!user.isGuest()) {

                shoppingCart.setUsuario(user);
                shoppingCart.setFecha(LocalDateTime.now());

                if (shoppingCart.revisarStock()) {

                    for (Map.Entry<ProductoDTO, Integer> linea : shoppingCart.getProductos().entrySet()) {
                        new PedidoDAO().discountStock(linea.getKey(), linea.getValue());
                    }

                } else {
                    request.setAttribute("error", "No hay stock suficiente para procesar el carrito");
                    request.getRequestDispatcher("/verCarrito.jsp").forward(request, response);
                }

                shoppingCart.setEstado("EN PROCESO");
                new PedidoDAO().anyadir(shoppingCart);
                System.out.println("Pedido creado correctamente");
                request.getSession().setAttribute("carrito", new PedidoDTO());
                response.sendRedirect("./verPedidos");

            } else {
                request.getSession().setAttribute("error", "No tienes poder aquí.");
                response.sendRedirect("./index");
            }
        } catch (SQLException ex) {
            Logger.getLogger(makeOrder.class.getName()).log(Level.SEVERE, null, ex);
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
