# Proyecto

## modelo entidad relación

[Enlace Lucid Chart](https://lucid.app/lucidchart/5e8169ed-ab5c-4a9f-8b9b-d2a57faf3205/edit?viewport_loc=-176%2C-23%2C3072%2C1056%2C0_0&invitationId=inv_6d824699-3066-4642-9e31-ac7d37cecbfe)

## Modelo relacional

Usuario (codigo, email, nombre, apellido, contraseña, ultima_conexion, tel, fecha_nacimiento, foto, direccion, tipo )

* PK: codigo
* UK: Email
* FK: direccion -> DIRECCIONES.codigo
* NN (nombre, apellidos, contra, ultima-con, direccion, tipo)

Direccion (codigo, direccion, codigo_postal, ciudad, provincia)

* PK: codigo
* NN (direccion, codigo_postal, ciudad, provincia)

Pedido (codigo, codigo_usuario, fecha, estado)

* PK: codigo
* FK: codigo_usuario -> USUARIOS.codigo
* NN (codigo_usuario, fecha, estado)

Producto (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)

* PK: codigo
* FK: codigo_categoria -> CATEGORIAS.codigo
* NN (nombre, descripcion, precio, stock)

Categoria (codigo, nombre)

* PK: codigo
* NN (nombre)

Pedido_Producto (codigo_pedido, codigo_producto, cantidad)

* PK: codigo_pedido, codigo_producto
* FK: codigo_pedido -> PEDIDOS.codigo
* FK: codigo_producto -> PRODUCTOS.codigo
* NN (codigo_pedido, codigo_producto, cantidad)

factura (codigo, codigo_pedido, fecha)

* PK: codigo
* FK: codigo_pedido -> PEDIDOS.codigo
* NN (codigo_pedido, fecha)

## Perdida semánticas

1. Se pierden el **"1"** de categoria y pedidos.
2. Se pierden los **"1"** de administrador y productos.
3. Se pierden los **"1"** de cliente y direccion.
