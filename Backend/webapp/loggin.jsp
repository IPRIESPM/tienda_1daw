<%-- 
    Document   : loggin
    Created on : 30 abr. 2023, 18:08:21
    Author     : isaac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Iniciar Sesión</title>

        <%@ include file="/styles/style.jsp" %>
    </head>
    <body>
        <%            
            if (request.getAttribute("error") != null) {
                out.println("<div class='error'> " + request.getAttribute("error") + "</div>");
            }
        %>
        <form method="post" action="iniciarSesion">
            <fieldset>
                <label for="email">Email</label></br>
                <input type="email" name="email" id="email" placeholder="example@example.com" required/>
            </fieldset>
            <fieldset>
                <label for="password">Contraseña</label> </br>
                <input type="password" name="password" id="password" placeholder="Tu contraseña super segura" required/>
            </fieldset>
            <input type="submit" value="iniciar sesión">
        </form>
    </body>
</html>
