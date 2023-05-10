<%-- 
    Document   : facturas
    Created on : 30 abr. 2023, 1:31:49
    Author     : isaac
--%>

<%@page import="DTO.PedidoDTO"%>
<%@page import="DTO.FacturaDTO"%>
<%@page import="DTO.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTO.DireccionDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
    List<PedidoDTO> pedidos = (ArrayList<PedidoDTO>) request.getAttribute("pedidos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de pedidos</title>
        <%@ include file="/styles/style.jsp" %>
    </head>
    <body>
        <h1>Listado de Pedidos</h1>
        <table>
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Usuario</td>
                    <td>Fecha</td>
                    <td>Estado</td>
                </tr>
            </thead>
            <tbody>
                <% 
                   
                    for (PedidoDTO pedido : pedidos) {
                %>
                <tr>
                    <td><%= pedido.getCodigo()%></td>
                    <td><%= pedido.getUsuario()%></td>
                    <td><%= pedido.getFecha()%></td>
                    <td><%= pedido.getEstado()%></td>
                   <%
                       if(usuario.isCliente()){
                   %>
                   <td><a href="./addInvoice?invoice=<%= pedido.getCodigo()%>">Facturar</a></td>
                   <% 
                       }
                   %>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
