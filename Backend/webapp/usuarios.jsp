<%-- 
    Document   : direcciones
    Created on : 29 abr. 2023, 20:22:10
    Author     : isaac
--%>

<%@page import="DTO.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTO.DireccionDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    List<UsuarioDTO> usuarios;

    if (request.getAttribute("usuarios") == null) {
        usuarios = new ArrayList<>();
    } else {
        usuarios = (ArrayList<UsuarioDTO>) request.getAttribute("usuarios");
    }

%>
<!DOCTYPE html>
    <html lang="es">
        <head>
            <%@ include file="/templates/head.jsp" %>
            <link rel="stylesheet" href="./styles/sheet.css">
            <link rel="stylesheet" href="./styles/about.css">
            <title>Contacta</title>

        </head>
    <body>
        <table>
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Email</td>
                    <td>Nombre postal</td>
                    <td>Apellido</td>
                    <td>Contraseña</td>
                    <td>Ultima conexion</td>
                    <td>Telefono</td>
                    <td>Fecha Nacimiento</td>
                    <td>Foto</td>
                    <td>Direccion</td>
                    <td>Tipo</td>
                </tr>
            </thead>
            <tbody>
                <%                    
                    for (UsuarioDTO usuario : usuarios) {
                %>
                <tr>
                    <td><%= usuario.getCodigo()%></td>
                    <td><%= usuario.getEmail()%></td>
                    <td><%= usuario.getNombre()%></td>
                    <td><%= usuario.getApellido()%></td>
                    <td><%= usuario.getContrasenya()%></td>
                    <td><%= usuario.getUltimaConexion()%></td>
                    <td><%= usuario.getTelefono()%></td>
                    <td><%= usuario.getFechaNacimiento()%></td>
                    <td><%= usuario.getFoto()%></td>
                    <td><%= usuario.getDireccion()%></td>
                    <td><%= usuario.getTipo() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
