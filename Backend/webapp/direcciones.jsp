<%-- 
    Document   : direcciones
    Created on : 29 abr. 2023, 20:22:10
    Author     : isaac
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTO.DireccionDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // List<DireccionDTO> direcciones = request.getAttribute("direcciones") == null ? (ArrayList<DireccionDTO>) request.getAttribute("direcciones") : new ArrayList<DireccionDTO>();

    //List<DireccionDTO> direcciones = request.getAttribute("direcciones") == null ? new ArrayList<>() : (ArrayList<DireccionDTO>) request.getAttribute("direcciones");
    List<DireccionDTO> direcciones;

    if (request.getAttribute("direcciones") == null) {
        direcciones = new ArrayList<>();
    } else {
        direcciones = (ArrayList<DireccionDTO>) request.getAttribute("direcciones");
    }


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de direcciones</title>
    </head>
    <body>
        <h1>Listado de Direccion</h1>
        <table>
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Direccion</td>
                    <td>Codigo postal</td>
                    <td>Ciudad</td>
                    <td>Provincia</td>
                </tr>
            </thead>
            <tbody>
                <%
                    for (DireccionDTO direccion : direcciones) {
                %>
                <tr>
                    <td><%= direccion.getCodigo()%></td>
                    <td><%= direccion.getDireccion()%></td>
                    <td><%= direccion.getCodigoPostal()%></td>
                    <td><%= direccion.getCiudad()%></td>
                    <td><%= direccion.getProvincia()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
