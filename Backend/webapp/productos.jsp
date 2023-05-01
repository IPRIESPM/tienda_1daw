<%-- 
    Document   : productos
    Created on : 29 abr. 2023, 23:57:15
    Author     : isaac
--%>

<%@page import="DTO.ProductoDTO"%>
<%@page import="DTO.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTO.DireccionDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<ProductoDTO> productos;

    if (request.getAttribute("productos") == null) {
        productos = new ArrayList<>();
    } else {
        productos = (ArrayList<ProductoDTO>) request.getAttribute("productos");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de usuarios</title>
        <style>
            body{
                background-color: #626262;
            }
            a:link,
            a:active,
            a:visited{
                color: white;
            }
        </style>
    </head>
    <body>
        <h1>Listado de productos</h1>
        <table>
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Categoria</td>
                    <td>Nombre</td>
                    <td>Descripccion</td>
                    <td>Precio</td>
                    <td>Stock</td>
                    <td>imagen</td>
                </tr>
            </thead>
            <tbody>
                <%                    
                    for (ProductoDTO producto : productos) {
                %>
                <tr>
                    <td><%= producto.getCodigo()%></td>
                    <td><%= producto.getCategoria()%></td>
                    <td><%= producto.getNombre()%></td>
                    <td><%= producto.getDescripccion()%></td>
                    <td><%= producto.getPrecio()%></td>
                    <td><%= producto.getStock()%></td>
                    <td><%= producto.getImagen()%></td>
                    <td><a href="./addCarrito?carrito=add&product=<%= producto.getCodigo()%>">Añadir a carrito</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
