<%-- 
    Document   : direcciones
    Created on : 29 abr. 2023, 20:22:10
    Author     : isaac
--%>

<%@page import="DTO.CategoriaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTO.DireccionDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // List<DireccionDTO> direcciones = request.getAttribute("direcciones") == null ? (ArrayList<DireccionDTO>) request.getAttribute("direcciones") : new ArrayList<DireccionDTO>();

    //List<DireccionDTO> direcciones = request.getAttribute("direcciones") == null ? new ArrayList<>() : (ArrayList<DireccionDTO>) request.getAttribute("direcciones");
    List<CategoriaDTO> categorias;

    if (request.getAttribute("categorias") == null) {
        categorias = new ArrayList<>();
    } else {
        categorias = (ArrayList<CategoriaDTO>) request.getAttribute("categorias");
    }


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de categorias</title>
    </head>
    <body>
        <h1>Listado de Categorias</h1>
        <table>
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Nombre</td>
                </tr>
            </thead>
            <tbody>
                <%
                    for (CategoriaDTO categoria : categorias) {
                %>
                <tr>
                    <td><%= categoria.getCodigo()%></td>
                    <td><%= categoria.getNombre()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
