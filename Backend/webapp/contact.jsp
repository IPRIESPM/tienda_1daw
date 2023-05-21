<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="/templates/head.jsp" %>
        <link rel="stylesheet" href="./styles/sheet.css">
        <link rel="stylesheet" href="./styles/contact.css">
        <title>Contacta</title>

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
                <h2>Contacta con nosotros</h2>


                <section>
                    <i class="bi bi-telegram"></i> <a href="tel:+34123456789">123456789</a>
                </section>

                <section>
                    <i class="bi bi-envelope-at"></i> <a href="mailto:victor@rancher.com">victor@rancher.com</a>
                </section>

                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d50607.00021989444!2d-122.31563005!3d37.55653595!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808f9e60efa95545%3A0xfd8efcf42dcc1ba7!2sSan%20Mateo%2C%20California%2C%20EE.%20UU.!5e0!3m2!1ses!2ses!4v1684434494270!5m2!1ses!2ses" width="800" height="600" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </section>
        </main-element>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>
