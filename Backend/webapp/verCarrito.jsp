<%@page import="DTO.UsuarioDTO"%>
<%@page import="DTO.PedidoDTO"%>
<%@page import="java.lang.Integer"%>
<%@page import="java.util.Map"%>
<%@page import="DTO.ProductoDTO"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    PedidoDTO carrito = new PedidoDTO();
   if (session.getAttribute("carrito") != null) {
        carrito = (PedidoDTO) session.getAttribute("carrito");
    }

    LinkedHashMap<ProductoDTO, Integer> productos = carrito.getProductos();
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
                <%
            if (request.getAttribute("error") != null) {
                out.println("<div class='error'> " + request.getAttribute("error") + "</div>");
            }
        %>
        <main-element>
            <section class="product">
                <%
                    if (productos.size() > 0) {
                        %>
                        <button-element data="Crear pedido" href="./makeOrder"></button-element>
                        <%
                    }
                    for (Map.Entry<ProductoDTO, Integer> producto : productos.entrySet()) {
                        ProductoDTO key = producto.getKey();
                        int value = producto.getValue();
                %>
                        <product-element
                            img="<%= key.getImagen()%>"
                            type="cart"
                            name="<%= key.getNombre()%>"
                            price="<%= key.getPrecio()%>"
                            cant="<%= value%>"
                            id="<%= key.getCodigo()%>"
                            addCart="remove"
                            cat="<%= key.getCategoria().getNombre()%>"
                        ></product-element>
                <%
                    }
                %>

            </section>
        </main-element>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>
