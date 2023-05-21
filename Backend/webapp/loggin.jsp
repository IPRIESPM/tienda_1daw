<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="/templates/head.jsp" %>
        <link rel="stylesheet" href="./styles/loggin.css">
        <link rel="stylesheet" href="./components/button/button.css">
        <link rel="stylesheet" href="./components/input/input.css">


        <title>Iniciar Sesión</title>
    </head>
    <body>
        <%
            if (request.getAttribute("error") != null) {
                out.println("<div class='error'> " + request.getAttribute("error") + "</div>");
            }
        %>
        <%@ include file="/templates/nav.jsp" %>
        <main-element sheet>
            <section class="sheet">
                <h2>Entrar a tu cuenta</h2>
                <form method="post" action="iniciarSesion">
                    <fieldset class="loggin">
                        <label for="email">Email</label>

                        <fieldset class="inputComponent">
                            <input class="inputComponent" type="email" name="email" placeholder="example@example.com">
                            <img class="inputComponent" src="/tiendaDaw/assets/img/pink.png" />
                        </fieldset>
                    </fieldset>
                    <fieldset class="loggin">
                        <label for="password">Contraseña</label>
                        <fieldset class="inputComponent">
                            <input class="inputComponent" type="password" name="password">
                            <img class="inputComponent" src="/tiendaDaw/assets/img/pink.png" />
                        </fieldset>
                    </fieldset>
                    <input type="submit" value="Iniciar Sesión" class="button">
                </form>
            </section>
        </main-element>
        <%@ include file="/templates/footer.jsp" %>
        <script type="module" src="./components/main.js"></script>
    </body>
</html>
