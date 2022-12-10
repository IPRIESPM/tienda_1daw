# 🏪🛒Tienda

Proyecto inter-modular de final de curso

El proyecto consta en una tienda web con un carrito de compra.

## Partes

1. El front-end constará de css y JavaScript.
2. El back-end estará construido en Java.
3. La base de datos estará en Oracle.

## 🔩Funcionalidad

### 🌈Font-end

El proyecto constará de una vista para "guest" general, que se podrán consultar los productos.
Un apartado de registro y login para poder ver el carrito del usuario.
Un apartado de admin, para poder registrar nuevas categorías y productos.

Secciones

1. 🏠 Home
2. 🏷️ Categorías
    * 🛍️ Productos
        * 🆔 Ficha del producto
3. 🏪 Nuestra tienda
4. 📧 Contacto

#### Ejecutar el proyecto

hacemos la instalación de los módulos de node.

```bash
npm i
```

Ejecutarlo en entorno de desarrollo.

```bash
npm run dev
```

Preparar el proyecto para producción.

```bash
npm run build
```

### 🤖Backend

1. 🛣Rutas

    * La ruta "/" como general.
    * La ruta "/login" para inicio de sesión.
    * La ruta "/admin" para la administración del sitio.

2. Tendremos las opciones:

    1. 🙍‍♂️🙍‍♀️Usuario:
        * Actualizar datos.
        * Eliminar usuario.
        * Set Carrito del usuario (LocalStorage)
        * Delete Carrito.
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

Base de datos basada en oracle [Documentación base de datos](https://github.com/IPRIESPM/tienda_1daw/blob/main/Base%20de%20datos/ModeloRelacional.md).
