/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelets;

import DTO.PedidoDTO;
import DTO.ProductoDTO;
import DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.tiendaSesion;

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Object usuario = request.getSession().getAttribute("usuario");
            Object carrito = request.getSession().getAttribute("carrito");
            UsuarioDTO tiendaUsuario = tiendaSesion.checkUsuario(usuario);
            PedidoDTO tiendaCarrito = tiendaSesion.checkCarrito(carrito);
            if (tiendaUsuario.isAdmin()) {
                response.sendRedirect("index.jsp");
            } else {

                String options = request.getParameter("carrito");
                int line = request.getParameter("line") != null ? Integer.parseInt(request.getParameter("line")) : 0;

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
                    out.println((String) request.getParameter("line"));
                    out.println((String) request.getParameter("value"));

                    int value = Integer.parseInt(request.getParameter("value"));

                    LinkedHashMap viejoCarrito = tiendaCarrito.getProductos();

                    ProductoDTO key = new ProductoDTO(line);

                    viejoCarrito.replace(key, value);
                    tiendaCarrito.setProductos(viejoCarrito);
                    request.getSession().setAttribute("carrito", tiendaCarrito);
                    response.sendRedirect("verCarrito.jsp");
                    return;
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
