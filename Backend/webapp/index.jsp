<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Tienda</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./styles/style.css">
        <link rel="stylesheet" href="./styles/index.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    </head>
    <body>
   <!-- 
        <form name="buscarProductos" action="verProductos">
            <label for="search">Buscar Producto</label>
            <input type="search" id="search" name="buscar" placeholder="Ej: Plort rosa" required>
            <input type="submit" value="buscar">
        </form> 
    -->
        <%@ include file="/templates/nav.jsp" %>
        <main-element>
            <button-element data="Productos" href="./verProductos"></button-element>
        </main-element>
        <%@ include file="/templates/footer.jsp" %>

        <script type="module" src="./components/main.js"></script>
    </body>
</html>
