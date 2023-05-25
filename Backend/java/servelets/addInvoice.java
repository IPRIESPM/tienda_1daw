/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelets;

import DAO.FacturaDAO;
import DAO.PedidoDAO;
import DTO.FacturaDTO;
import DTO.PedidoDTO;
import DTO.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
public class addInvoice extends HttpServlet {

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

            UsuarioDTO usuario = shopSession.checkUsuario(request.getSession().getAttribute("usuario"));

            if (!usuario.isGuest()) {
                int idInvoice = Integer.parseInt(request.getParameter("invoice"));
                if (request.getParameter("invoice") != null && new PedidoDAO().existe(idInvoice) && !new PedidoDAO().checkInvoiced(idInvoice)) {

                    PedidoDTO pedido = new PedidoDAO().getByCodigo(Integer.parseInt(request.getParameter("invoice")));
                    new PedidoDAO().chageStatus(pedido);
                    FacturaDTO factura = new FacturaDTO(0, pedido, LocalDateTime.now());
                    new FacturaDAO().anyadir(factura);
                    response.sendRedirect("./verFacturas");

                } else {
                    request.setAttribute("error", "Tu programa ha fallado con exito, al facturar tu pedido.");
                    request.getRequestDispatcher("/verPedidos").forward(request, response);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(addInvoice.class.getName()).log(Level.SEVERE, null, ex);
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
