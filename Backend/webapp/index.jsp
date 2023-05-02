<%-- 
    Document   : index
    Created on : 30 abr. 2023, 18:42:00
    Author     : isaac
--%>

<%@page import="DTO.UsuarioDTO"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // ((UsuarioDTO) request.getAttribute("usuario")).getEmail() != null
    UsuarioDTO usuario = session.getAttribute("usuario") != null ? (UsuarioDTO) session.getAttribute("usuario") : new UsuarioDTO();
%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Tienda</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@ include file="/styles/style.jsp" %>
    </head>
    <body>

        <%
            if (usuario.getEmail() != null) {
                out.println(usuario.getTipo());
                if (usuario.isAdmin()) {
        %>
        <div>
            <a href="./verDirecciones">Ver Direcciones</a>
        </div>

        <div>
            <a href="./verUsuarios">Ver usuarios</a>
        </div>
            <div>
            <a href="./verFacturas">Ver Facturas</a>
        </div>
        <%
            }
        %>

        <div>
            <a href="./carrito?carrito=ver">Ver carrito</a>
        </div>

        <div>
            <a href="./cerrarSesion">Cerrar Sesión</a>
        </div>

        <%
        } else {
        %>

        <div>
            <a href="./loggin.jsp">Iniciar sesión</a>
        </div>

        <%
            }
        %>
        <div>
            <a href="./verCategorias">Ver categorias</a>
        </div>

        <div>
            <a href="./verProductos">Ver Productos</a>
        </div>
    </body>
</html>
