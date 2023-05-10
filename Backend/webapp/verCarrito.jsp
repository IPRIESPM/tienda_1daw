<%-- 
    Document   : carrito
    Created on : 30 abr. 2023, 22:24:38
    Author     : isaac
--%>

<%@page import="DTO.UsuarioDTO"%>
<%@page import="DTO.PedidoDTO"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Map"%>
<%@page import="DTO.ProductoDTO"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    PedidoDTO carrito = new PedidoDTO();

    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
    if (session.getAttribute("carrito") != null) {
        System.out.println(session.getAttribute("carrito"));
        carrito = (PedidoDTO) session.getAttribute("carrito");
    }

    LinkedHashMap<ProductoDTO, Integer> productos = carrito.getProductos();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Carrito</title>
        <%@ include file="/styles/style.jsp" %>
    </head>
    <body>
        <h1>Carrito</h1>
        <table>
            <thead>
                <tr>
                    <td>Producto</td>
                    <td>Cantidad</td>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Map.Entry<ProductoDTO, Integer> producto : productos.entrySet()) {
                        ProductoDTO key = producto.getKey();
                        int value = producto.getValue();
                %> 
                <tr>
                    <td><%= key%></td> 
                    <td> <%= value%>
                        <form action="./carrito" method="get">
                            <input type="hidden" name="carrito" value="mod">
                            <input type="hidden" name="line"  value="<%= key.getCodigo()%>">
                            <input type="number" name="value" value="<%= value%>">  
                            <input type="submit" value="Guardar"> 
                        </form>
                    </td> 
                    <td> <a href="./carrito?carrito=del&line=<%= key.getCodigo()%>">Eliminar<a></td>
                                </tr>

                                <%
                                    }
                                %>
                                <%
                                    if (productos.size() > 0) {
                                %> 
                                <a href='./makeOrder'>Crear pedido</a>
                                <%
                                    }
                                %>

                                </body>
                                </html>
