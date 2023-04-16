# Proyecto

## modelo entidad relación

[Enlace Lucid Chart](https://lucid.app/lucidchart/5e8169ed-ab5c-4a9f-8b9b-d2a57faf3205/edit?viewport_loc=-176%2C-23%2C3072%2C1056%2C0_0&invitationId=inv_6d824699-3066-4642-9e31-ac7d37cecbfe)

## Modelo relacional

<<<<<<< HEAD
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

Direcciones (codigo, direccion, codigo_postal, ciudad, provincia, cliente)
=======
Direccion (codigo, direccion, codigo_postal, ciudad, provincia)
>>>>>>> dev

* PK: codigo
* FK: cliente -> CLIENTE.codigo
* NN (direccion, codigo_postal, ciudad, provincia)

<<<<<<< HEAD
Pedidos_facturados(cod_pedido, codigo_factura, fecha, facturado, dir_envio, fecha_facturacion, cod_cliente, cod_direccion, cod_facturacion)

* PK: cod_pedido
* UK: cod_factura
* FK: cod_cliente -> CLIENTE.codigo
* FK: cod_direccion -> DIRECCION.codigo
* FK: cod_facturacion -> DIRECCION.codigo
* NN (cod_cliente, fecha, facturado, dir_envio, fecha_facturacion, cod_direccion, cod_facturacion )

Productos (codigo, nombre, descripccion, unidad, IVA, cantidad_disponible, stock_min, foto_path, creador, modificador, fecha_creacion, fecha_modificacion)

* PK: codigo
* FK: creador -> ADMINISTRADOR.codigo
* FK: modificador -> ADMINISTRADOR.codigo
* NN (nombre, descripccion, unidad, IVA, cantidad_disponible, stock_min, foto_path, fecha_creacion)
=======
Usuario (codigo, email, nombre, apellido, contraseña, ultima_conexion, tel, fecha_nacimiento, foto, direccion, tipo )

* PK: codigo
* UK: Email
* FK: direccion -> DIRECCIONES.codigo
* NN (nombre, apellidos, contra, ultima-con, direccion, tipo)
>>>>>>> dev

Pedido (codigo, codigo_usuario, fecha, estado)

* PK: codigo
* FK: codigo_usuario -> USUARIOS.codigo
* NN (codigo_usuario, fecha, estado)

<<<<<<< HEAD
Categorias (codigo, nombre)
=======
Producto (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)

* PK: codigo
* FK: codigo_categoria -> CATEGORIAS.codigo
* NN (nombre, descripcion, precio, stock)

Categoria (codigo, nombre)
>>>>>>> dev

* PK: codigo
* NN (nombre)

Pedido_Producto (codigo_pedido, codigo_producto, cantidad)

* PK: codigo_pedido, codigo_producto
* FK: codigo_pedido -> PEDIDOS.codigo
* FK: codigo_producto -> PRODUCTOS.codigo
* NN (codigo_pedido, codigo_producto, cantidad)

<<<<<<< HEAD
## Perdida semánticas

1. Pierdo la exclusividad y totalidad de la generalización.
2. Se pierden el **"1"** de categoria y pedidos.
3. Se pierden los **"1"** de administrador y productos.
4. Los atributos de la fecha de modificación y creacion son de la relación
   y por lo tanto al pasarlo al relacional perdemos ese origen.
=======
factura (codigo, codigo_pedido, fecha)

* PK: codigo
* FK: codigo_pedido -> PEDIDOS.codigo
* NN (codigo_pedido, fecha)

## Perdida semánticas

1. Se pierden el **"1"** de categoria y pedidos.
2. Se pierden los **"1"** de administrador y productos.
3. Se pierden los **"1"** de cliente y direccion.
>>>>>>> dev
