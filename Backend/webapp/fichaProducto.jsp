<%-- 
    Document   : fichaProducto
    Created on : 2 may. 2023, 23:02:00
    Author     : isaac
--%>

<%@page import="DTO.UsuarioDTO"%>
<%@page import="DTO.ProductoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    UsuarioDTO usuario = session.getAttribute("usuario") == null ? new UsuarioDTO() : (UsuarioDTO) session.getAttribute("usuario");
    ProductoDTO producto = request.getAttribute("product") == null ? new ProductoDTO() : (ProductoDTO) request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver producto</title>
        <%@ include file="/styles/style.jsp" %>
    </head>
    <body>
        <h1>Ficha del producto <%= producto.getNombre()%> </h1>
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
                <tr>
                    <td><%= producto.getCodigo()%></td>
                    <td><%= producto.getCategoria()%></td>
                    <td><%= producto.getNombre()%></td>
                    <td><%= producto.getDescripccion()%></td>
                    <td><%= producto.getPrecio()%></td>
                    <td><%= producto.getStock()%></td>
                    <td><%= producto.getImagen()%></td>
                    <%
                        if (usuario.isCliente()) {
                    %>
                    <td><a href="./addCarrito?carrito=add&product=<%= producto.getCodigo()%>">Añadir a carrito</a></td>
                    <%
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
