<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="/templates/head.jsp" %>
        <link rel="stylesheet" href="./styles/sheet.css">
        <link rel="stylesheet" href="./styles/about.css">
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
               <article>

                <h2>¡Bienvenido(a) a PlortShop!</h2>

               <p>En PlortShop, sumérgete en el vibrante y fascinante mundo de los Slimes y descubre una experiencia de compra única. Somos una tienda online especializada en la venta exclusiva de Plorts, esos coloridos y valiosos cristales producidos por los Slimes.</p>

               <p>Nuestro equipo de expertos en Slime Ranching se ha dedicado apasionadamente a recolectar y seleccionar los Plorts más excepcionales de los diferentes tipos de Slimes que existen en el vasto universo de Slime Rancher. Nos aseguramos de que cada Plort que vendemos sea de la más alta calidad y esté listo para ser utilizado en una variedad de aplicaciones emocionantes.</p>

                <p>En PlortShop, encontrarás una amplia gama de Plorts para elegir. Desde los Plorts clásicos y populares hasta los raros y exóticos, ofrecemos una variedad que se adapta a todos los gustos y necesidades. Ya sea que los necesites para investigaciones científicas, experimentos extravagantes, mejoras tecnológicas o simplemente para coleccionar, ¡tenemos el Plort perfecto para ti!</p>

                <p>Nos enorgullece brindar un servicio excepcional a nuestros clientes. Nuestro equipo de atención al cliente está siempre dispuesto a ayudarte con cualquier pregunta o inquietud que puedas tener. Además, garantizamos un envío rápido y seguro para que tus Plorts lleguen a ti en perfectas condiciones.</p>

                <p>En PlortShop, estamos comprometidos con la sostenibilidad y el bienestar de los Slimes. Trabajamos en estrecha colaboración con los Slime Ranchers para garantizar prácticas éticas y responsables en la recolección de Plorts, preservando el equilibrio natural de los ecosistemas slime.</p>

                <p>Así que, ¿qué esperas? Explora nuestro catálogo y sumérgete en el fascinante mundo de los Plorts. ¡PlortShop está aquí para satisfacer todas tus necesidades de Plorts de manera segura, confiable y emocionante!</p>

                <p>¡Gracias por elegir PlortShop, tu destino número uno para los Plorts de Slime Rancher!</p>
               </article>
            </section>
        </main-element>
        <%@ include file="/templates/footer.jsp" %>
    </body>
</html>
