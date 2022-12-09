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

Direcciones (codigo, direccion, codigo_postal, ciudad, provincia)

* PK: codigo
* NN (direccion, codigo_postal, ciudad, provincia)

Direccion_de_cliente(cod_cliente,cod_direccion)

* PK: (cod_cliente,cod_direccion)
* FK: cod_cliente -> CLIENTE.codigo
* FK: cod_direccion -> CLIENTE.direccion

Pedidos_facturados(cod_pedido, codigo_factura, fecha, facturado, dir_envio, fecha_facturacion, cod_cliente, cod_direccion, cod_facturacion)

* PK: cod_pedido
* UK: cod_factura
* FK: cod_cliente -> CLIENTE.codigo
* FK: cod_direccion -> DIRECCION.codigo
* FK: cod_facturacion -> DIRECCION.codigo
* NN (cod_cliente, fecha, facturado, dir_envio, fecha_facturacion, cod_direccion, cod_facturacion )

Productos (codigo, nombre, descripccion, unidad, IVA, cantidad_disponible, stock_min, foto_path)

* PK: codigo
* NN (nombre, descripccion, unidad, IVA, cantidad_disponible, stock_min, foto_path)

Pedidos_Tienen_productos (cod_productos, cod_pedidos, , linea, cantidad, precio)

* PK: cod_productos, cod_pedidos
* FK: cod_productos -> PRODUCTOS.codigo
* FK: cod_pedidos -> PRODUCTOS.codigo
* NN (linea, cantidad, precio)

Creacion_producto(cod_administrador, cod_productos, fecha_creacion)

* PK: (cod_administrador, cod_productos)
* FK: cod_administrador -> ADMINISTRADOR.codigo
* FK: cod_producto -> PRODUCTO.codigo
* NN(fecha_creacion)

Modificacion_producto(Cod_administrador, cod_productos, fecha_modificacion)

* PK: (cod_administrador, cod_productos)
* FK: cod_administrador -> ADMINISTRADOR.codigo
* FK: cod_producto -> PRODUCTO.codigo
* NN(fecha_modificacion)

Categorias (codigo, nombre)

* PK: codigo
* NN (nombre)

Categorias_de_productos (codigo_producto, codigo_categoria)

* PK: (codigo_producto, codigo_categoria)
* FK: codigo_producto -> PRODUCTO.codigo
* FK: codigo_categoria -> CATEGORIA.codigo

Subcategorias (cod_categoria, cod_subcategoria)

* PK: cod_categoria, cod_subcategoria
* FK: cod_categoria -> CATEGORIA.codigo
* FK: cod_subcategoria -> CATEGORIA.codigo

## Perdida semánticas

1. Pierdo la exclusividad y totalidad de la generalización.
2. Se pierden el **"1"** de categoria y pedidos.
3. Se pierden los **"1"** de administrador y productos.
4. Se pierden los **"1"** de cliente y direccion.
