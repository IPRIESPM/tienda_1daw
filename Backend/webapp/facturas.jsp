<%-- 
    Document   : facturas
    Created on : 30 abr. 2023, 1:31:49
    Author     : isaac
--%>

<%@page import="DTO.FacturaDTO"%>
<%@page import="DTO.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTO.DireccionDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    List<FacturaDTO> facturas;

    if (request.getAttribute("facturas") == null) {
        facturas = new ArrayList<>();
    } else {
        facturas = (ArrayList<FacturaDTO>) request.getAttribute("facturas");
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de facturas</title>
        <%@ include file="/styles/style.jsp" %>
    </head>
    <body>
        <h1>Listado de facturas</h1>
        <table>
            <thead>
                <tr>
                    <td>Codigo</td>
                    <td>Email</td>
                    <td>Nombre postal</td>

                </tr>
            </thead>
            <tbody>
                <%                    for (FacturaDTO factura : facturas) {
                %>
                <tr>
                    <td><%= factura.getCodigo()%></td>
                    <td><%= factura.getFecha()%></td>
                    <td><%= factura.getPedido()%></td>

                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
