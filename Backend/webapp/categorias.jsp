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
        <%@ include file="/templates/head.jsp" %>
        <title>Categorias</title>
        <link rel="stylesheet" href="./styles/sheet.css">
        <link rel="stylesheet" href="./styles/category.css">

    </head>
    <body>
        <%@ include file="/templates/nav.jsp" %>
        <main-element>
            <section class="main">
                <h1>Listado de Categorias</h1>
                <section class="category">
                <%
                    for (CategoriaDTO categoria : categorias) {
                %>
                    <category-element href="./categoryProducts?category=<%=categoria.getCodigo()%>">
                        <link-element name="<%= categoria.getNombre()%>"  href="./categoryProducts?category=<%=categoria.getCodigo()%>" ></link-element>
                    </category-element>
                <%
                    }
                %>
                </section>
            </section>
        </main-element>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>
