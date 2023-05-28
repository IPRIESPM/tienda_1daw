<%@page import="DTO.UsuarioDTO"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    UsuarioDTO usuario = session.getAttribute("usuario") != null ? (UsuarioDTO) session.getAttribute("usuario") : new UsuarioDTO();
    
    if (session.getAttribute("error") != null){
        String error = session.getAttribute("error").toString();
%>
    <section class="error" onlick="this.style.dipslay='none'"> <%= error %></section>
<%
        session.setAttribute("error", null); 
    }
%>

<nav-element>
    <link-element name="principal" href="./index.jsp" ></link-element>
    <link-element name="productos" href="./verProductos" ></link-element>
    <link-element name="categorias" href="./verCategorias" ></link-element>
    <%
        if (!usuario.isGuest()) {
           // out.println(usuario.getTipo() + " última conexión: " + usuario.getUltimaConexion());
    %>
            <drop-element name="Mis compras">
                <link-element slot="1" name="Pedidos" href="./verPedidos" ></link-element>
                <link-element slot="2" name="Facturas" href="./verFacturas" ></link-element>
            </drop-element>
        <%
            if (!usuario.isAdmin()) {
        %>
            <link-element name="Carrito" href="./carrito?carrito=ver" ></link-element>
            <!-- comment  <link-element name="Perfil" href="./usuarios.jsp" ></link-element> -->

        <%
            }
        %>
        <button-element data="Salir" href="./cerrarSesion"></button-element>
    <%
        } else {
    %>
        <button-element data="Iniciar" href="./loggin.jsp"></button-element>
    <%
        }
    %>
</nav-element>