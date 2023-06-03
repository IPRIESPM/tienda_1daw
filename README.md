# 🏪🛒Tienda

Proyecto inter-modular de final de curso

El proyecto consta en una tienda web con un carrito de compra.

**Índice**

1. [CONSULTAS SIMPLES](#font-end)
Texto del segundo apartado

## Partes

1. El front-end constará de css y JavaScript.
2. El back-end estará construido en Java.
3. La base de datos estará en Oracle.

## Funcionalidad

### Font-end

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

#### Mockup

Puedes ver el mockup del proyecto aquí [Figma](https://www.figma.com/file/zSowJrLmcIe1M7s3rM4a8E/TIendaDaw?type=design&node-id=2%3A112&t=NcXDF7y281Zpuc8C-1)

#### Previsualización

Puedes ver el proyecto aquí [versión Live](https://www.figma.com/proto/zSowJrLmcIe1M7s3rM4a8E/TIendaDaw?node-id=1-2&starting-point-node-id=1%3A2)

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

### Backend

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

### Base de datos

Base de datos basada en oracle [Documentación base de datos](https://github.com/IPRIESPM/tienda_1daw/blob/main/Base%20de%20datos/ModeloRelacional.md).

## Requisitos

### OBLIGATORIAS

-------------------------------

* Iniciar sesión -
* Cerrar sesión -
* Distintas vistas dependiendo del tipo de usuario -
* Vista de artículos dinámica -
* Vista de artículo individual -
* Vista de pedidos -
* Vista de factura -
* Filtros de categorías -
* Carrito -
* Un usuario normal puede ver sólo sus facturas (GetByUsuario) -
* Hacer pedido
* Facturar Pedido
* Cuando se facture descontar del stock esa cantidad
* Si no hay stock mostrar mensaje de error

### OPCIONALES

-------------------------------

* Añadir usuario
* Añadir comentario
* Añadir artículo
* Eliminar artículo

### ANOTACIONES

-------------------------------

* En filtros para categorias (En artículo tendrá un GetByCategorias) -
* NO HACE FALTA HACER 'VER DATOS SESIÓN' -
* HttpSession session = request.getSession(false); (si existe una sesión la importa, sino no la crea y se queda en null) -
* producto.jsp se necesita enviar el codigo del articulo en AnyadirAlCarrito 'hidden' para el servlet -
* Hacer método isAdmin o isCliente -
* Cuando el usuario inicie sesión cambiar la fecha de ultima conexion de la base de datos -
* En carrito antes de confirmar pedido poner un select con todas las direcciones del usuario
