<%@page import="DTO.ProductoDTO"%>
<%@page import="DTO.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTO.DireccionDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ProductoDTO producto = request.getAttribute("product") == null ? new ProductoDTO() : (ProductoDTO) request.getAttribute("product");
%>


<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="/templates/head.jsp" %>

        <link rel="stylesheet" href="./styles/sheet.css">
        <title>
            <%= producto.getNombre() %>
        </title>
    </head>
    <body>
        <%@ include file="/templates/nav.jsp" %>
        <main-element sheet>

            <card-element>
                <section slot="card-head">
                    <img src="/tiendaDaw/assets/img/plorts/<%=producto.getImagen()%>" alt="<%= producto.getNombre()%>" height="127" width="127">
                    <h2><%= producto.getNombre()%> </h2>

                    <section class="price-details">
                        <p><%= producto.getStock()%>u.</p>
                        <p><%= producto.getPrecio()%>€/u.</p>
                    </section>
                </section>

                <section slot="card-body">
                    <article>
                       <%= producto.getDescripccion()%>
                    </article>
                    <%
                        if (usuario.isCliente()) {
                    %>
                    <button-element
                        data="Añadir"
                        href="./addCarrito?carrito=add&product=<%=producto.getCodigo()%>"
                    ></button-element>
                    <%
                        }
                    %>
                </section>
            </card-element>

        </main-element>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>


