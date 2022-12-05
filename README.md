# 🏪🛒Tienda

Proyecto inter-modular de final de curso

El proyecto consta en una tienda web con un carrito de compra.

## Partes

1. El front-end constará exclusivamente de css y JavaScript.
2. El back-end estará construido en Java.
3. La base de datos estará en Oracle.

## 🔩Funcionalidad

### 🌈Font-end

El proyecto constará de una vista para "guest" general, que se podrán consultar los productos.
Un apartado de registro y login para poder ver el carrito del usuario.
Un apartado de admin, para poder registrar nuevas categorías y productos.

Secciones

1. 🏠 Home
2. 🏷️ Categorias
    * 🛍️ Productos
        * 🆔 Ficha del producto
3. 🏪 Nuestra tienda
4. 📧 Contacto
5. 🙍 Login

### 🤖Backend

1. 🛣Rutas

    * La ruta "/" como general.
    * La ruta "/login" para inicio de sesión.
    * La ruta "/admin" para la administración del sitio.

2. Tendremos las opciones:

    1. 🙍‍♂️🙍‍♀️Usuario:
        * Actualizar datos.
        * Eliminar usuario.
        * Set Carrito del usuario.
        * Delete Carrito.
        * Update carrito.
        * Generar factura.

    2. 👩‍💻👩‍💻Admin:
        * Modificar usuarios usuario.
        * Añadir categorías.
        * Añadir productos.
        * Ver facturas.
        * Dar de alta usuario.

    3. 🤸‍♂️🤸‍♀️Invitado:
        * Carrito temporal (LocalStorage).
        * Dar de alta usuario.
        * Ver categorías.
        * Ver productos.

### 🛢📊Base de datos

    En un principio voy a guardar los datos en JSON
    a la espera de Oracle.
