<%@page import="DTO.UsuarioDTO"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    UsuarioDTO usuario = session.getAttribute("usuario") != null ? (UsuarioDTO) session.getAttribute("usuario") : new UsuarioDTO();
%>

<nav-element>
    <link-element name="principal" href="./index.jsp" ></link-element>
    <link-element name="productos" href="./verProductos" ></link-element>
    <link-element name="categorias" href="./verCategorias" ></link-element>
    <link-element name="Contacta" href="./contact.jsp" ></link-element>
    <%
        if (!usuario.isGuest()) {
           // out.println(usuario.getTipo() + " última conexión: " + usuario.getUltimaConexion());
    %>
        <link-element name="Pedidos" href="./verPedidos" ></link-element>
        <link-element name="Facturas" href="./verFacturas" ></link-element>
 
        <%
            if (!usuario.isAdmin()) {
         
        %>
            <link-element name="Carrito" href="./carrito?carrito=ver" ></link-element>
        <% 
            } 
        %>
        <button-element data="Salir" href="./cerrarSesion"></button-element>
    <%
        } else {
    %>
        <button-element data="Inciar" href="./loggin.jsp"></button-element>
    <%
        } 
    %>
    
</nav-element>