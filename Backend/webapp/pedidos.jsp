
<%@page import="DTO.PedidoDTO"%>
<%@page import="DTO.FacturaDTO"%>
<%@page import="DTO.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTO.DireccionDTO"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<PedidoDTO> pedidos = (ArrayList<PedidoDTO>) request.getAttribute("pedidos");
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
                    for (PedidoDTO pedido : pedidos) {
                %>
                    <product-element
                        type="order"
                        state="<%=pedido.getEstado()%>"
                        date="<%= pedido.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))%>"
                        price="<%= pedido.getPrecioTotal()%>"
                        cant="<%= pedido.getProductos().size()%>"
                        id="<%= pedido.getCodigo()%>"
                        addCart
                    ></product-element>
                <%
                    }
                %>
            </section>
        </main-element>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>
