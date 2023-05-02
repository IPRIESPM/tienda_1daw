<%-- 
    Document   : carrito
    Created on : 30 abr. 2023, 22:24:38
    Author     : isaac
--%>

<%@page import="DTO.PedidoDTO"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Map"%>
<%@page import="DTO.ProductoDTO"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    PedidoDTO carrito = new PedidoDTO();
        
    
    if(session.getAttribute("carrito") != null){
        System.out.println(session.getAttribute("carrito"));
        carrito = (PedidoDTO) session.getAttribute("carrito");
    }
            
    
    LinkedHashMap<ProductoDTO,Integer > productos = carrito.getProductos();
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
                    <td>Linea</td>
                    <td>Producto</td>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Map.Entry<ProductoDTO,Integer > producto : productos.entrySet()) {
                        ProductoDTO key = producto.getKey();
                        int value = producto.getValue();
                %> 
                <tr>
                    <td><%= key %></td> <td><%= value %></td>
                </tr>
                
                <%
                    }
                %>
                </body>
                </html>
