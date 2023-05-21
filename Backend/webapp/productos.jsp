<%@page import="DTO.ProductoDTO"%>
<%@page import="DTO.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTO.DireccionDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<ProductoDTO> productos = request.getAttribute("productos") == null ? new ArrayList<ProductoDTO>() : (ArrayList<ProductoDTO>) request.getAttribute("productos");
%>
<!DOCTYPE html>

<html>
    <head>
        <%@ include file="/templates/head.jsp" %>
        <title>Productos</title>
        <link rel="stylesheet" href="./styles/sheet.css">
        <link rel="stylesheet" href="./styles/article.css">

    </head>
    <body>
        <%@ include file="/templates/nav.jsp" %>
        <main-element>
            <section class="product">
                <%
                    for (ProductoDTO producto : productos) {
                %>
                    <product-element
                        img="<%= producto.getImagen()%>"
                        name="<%= producto.getNombre()%>"
                        price="<%= producto.getPrecio()%>"
                        cant="<%= producto.getStock()%>"
                        id="<%= producto.getCodigo()%>"
                        href="<%= producto.getCodigo()%>"
                        <%
                            if(usuario.isCliente()){out.println("addCart");}
                        %>
                    ></product-element>
                <%
                    }
                %>
            </section>
        </main-element>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>
