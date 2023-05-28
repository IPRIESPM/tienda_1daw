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
        <%@ include file="/templates/head.jsp" %>
        <link rel="stylesheet" href="./styles/sheet.css">
        <link rel="stylesheet" href="./styles/article.css">
    </head>
    <body>
        <%@ include file="/templates/nav.jsp" %>
        <main-element>
            <section class="product">
                <%
                    for (FacturaDTO factura : facturas) {
                %>
                    <product-element
                        id="<%= factura.getCodigo()%>"
                        type="invoice"
                        date="<%= factura.getFecha()%>"
                    ></product-element>
                <%
                    }
                %>
            </section>
        </main-element>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>
