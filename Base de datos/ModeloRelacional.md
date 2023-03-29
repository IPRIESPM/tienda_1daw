# Proyecto

## modelo entidad relación

[Enlace Lucid Chart](https://lucid.app/lucidchart/5e8169ed-ab5c-4a9f-8b9b-d2a57faf3205/edit?viewport_loc=-176%2C-23%2C3072%2C1056%2C0_0&invitationId=inv_6d824699-3066-4642-9e31-ac7d37cecbfe)

## Modelo relacional

Usuarios (codigo, email, nombre, apellido, contraseña, ultima_conexion, tel, fecha_nacimiento, foto )

* PK: codigo
* UK: Email
* NN (nombre, apellidos, contra, ultima-con)

Cliente (codigo)

* PK: codigo
* FK: codigo -> USUARIO.codigo

Administrador (código)

* PK: codigo
* FK: codigo -> USUARIO.codigo

Direcciones (codigo, direccion, codigo_postal, ciudad, provincia, usuario_codigo)

* PK: codigo
* FK: usuario_codigo -> USUARIO.codigo
* NN (direccion, codigo_postal, ciudad, provincia)

Direccines_de_Clientes (codigo_direccion, codigo_cliente)

* PK: (codigo_direccion, codigo_cliente)
* FK: codigo_direccion -> DIRECCIONES.codigo
* FK: codigo_cliente -> CLIENTE.codigo
* NN (codigo_direccion, codigo_cliente)

Factura(codigo, fecha)

* PK: codigo
* NN(fecha)

Pedido(cod_pedido, cod_factura, fecha_Pedido, cod_cliente, cod_direccion, cod_facturacion)

* PK: cod_pedido
* UK: cod_factura
* FK: cod_cliente -> CLIENTE.codigo
* FK: cod_direccion -> DIRECCION.codigo
* NN (cod_cliente, fecha, fecha_pedido, cod_direccion, cod_facturacion )

Productos (codigo, nombre, descripccion, unidad, iva, cantidad_disponible, stock_min, foto_path)

* PK: codigo
* NN (nombre, descripccion, unidad, iva, cantidad_disponible, stock_min, foto_path)

Pedidos_Tienen_productos (cod_productos, cod_pedidos, cantidad, precio)

* PK: cod_productos, cod_pedidos
* FK: cod_productos -> PRODUCTOS.codigo
* FK: cod_pedidos -> PRODUCTOS.codigo
* NN (cantidad, precio)

Administracion_producto(Cod_administrador, cod_productos, fecha_modificacion)

* PK: (cod_administrador, cod_productos)
* FK: cod_administrador -> ADMINISTRADOR.codigo
* FK: cod_producto -> PRODUCTO.codigo
* NN(fecha_modificacion)

Categorias (codigo, nombre)

* PK: codigo
* NN (nombre)

productos_Con_Categoria (codigo_producto, codigo_categoria)

* PK: (codigo_producto, codigo_categoria)
* FK: codigo_producto -> PRODUCTO.codigo
* FK: codigo_categoria -> CATEGORIA.codigo

## Perdida semánticas

1. Pierdo la exclusividad y totalidad de la generalización.
2. Se pierden el **"1"** de categoria y pedidos.
3. Se pierden los **"1"** de administrador y productos.
4. Se pierden los **"1"** de cliente y direccion.
