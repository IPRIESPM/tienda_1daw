-- Insert para TIENDA_DIRECCION
INSERT INTO TIENDA_DIRECCION (codigo, direccion, codigo_postal, ciudad, provincia)
VALUES (1, 'Calle de los plorts 123', '1000', 'Rancho Slimy', 'Estados Unidos');

INSERT INTO TIENDA_DIRECCION (codigo, direccion, codigo_postal, ciudad, provincia)
VALUES (2, 'Avenida de los plorts 456', '2000', 'Rancho Pegajoso', 'Estados Unidos');

INSERT INTO TIENDA_DIRECCION (codigo, direccion, codigo_postal, ciudad, provincia)
VALUES (3, 'Calle Falsa 123', '1234', 'Ciudad Falsa', 'Falsia');



-- Insert para TIENDA_USUARIO
INSERT INTO TIENDA_USUARIO (codigo, email, nombre, apellido, contrasenya, ultima_conexion, telefono, fecha_nacimiento, foto, direccion, tipo)
VALUES (1, 'beatrix@rancher.com', 'Beatrix', 'LeBeau', 'plortslife', SYSDATE, '123456789', TO_DATE('01-01-1990', 'DD-MM-YYYY'), NULL, 1, 'CLIENTE');

INSERT INTO TIENDA_USUARIO (codigo, email, nombre, apellido, contrasenya, ultima_conexion, telefono, fecha_nacimiento, foto, direccion, tipo)
VALUES (2, 'gordo@rancher.com', 'Gordo', 'Ogordo', 'slimey', SYSDATE, '987654321', TO_DATE('01-01-1995', 'DD-MM-YYYY'), NULL, 2, 'CLIENTE');

INSERT INTO TIENDA_USUARIO (codigo, email, nombre, apellido, contrasenya, ultima_conexion, telefono, fecha_nacimiento, foto, direccion, tipo)
VALUES (3, 'victor@rancher.com', 'Victor', 'Humphries', 'plortzrule', SYSDATE, '123456789', TO_DATE('01-01-1990', 'DD-MM-YYYY'), NULL, 1, 'ADMIN');

-- Insert para TIENDA_CATEGORIA
INSERT INTO TIENDA_CATEGORIA (codigo, nombre)
VALUES (1, 'Plorts');

INSERT INTO TIENDA_CATEGORIA (codigo, nombre)
VALUES (2, 'Comida para slimes');

INSERT INTO TIENDA_CATEGORIA (codigo, nombre)
VALUES (3, 'Herramientas para rancheros');



-- Insert para TIENDA_PRODUCTO
INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (1, 1, 'Plort de rosa cristal', 'Un plort brillante y valioso producido por los slimes de rosa cristal', 50.99, 100, 'plort_rosa_cristal.jpg');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (2, 1, 'Plort de lima', 'Un plort verde y pegajoso producido por los slimes de lima', 20.99, 200, 'plort_lima.jpg');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (3, 2, 'Croquetas de pollo', 'Deliciosas croquetas de pollo para alimentar a tus slimes', 10.50, 50, 'croquetas_pollo.jpg');

-- Insert para TIENDA_PEDIDO
INSERT INTO TIENDA_PEDIDO (codigo, codigo_usuario, fecha, estado)
VALUES (1, 1, SYSDATE, 'EN PROCESO');

INSERT INTO TIENDA_PEDIDO (codigo, codigo_usuario, fecha, estado)
VALUES (2, 2, SYSDATE, 'EN PROCESO');

INSERT INTO TIENDA_PEDIDO (codigo, codigo_usuario, fecha, estado)
VALUES (3, 3, SYSDATE, 'ENVIADO');



-- Insert para PEDIDO_PRODUCTO
INSERT INTO PEDIDO_PRODUCTO (codigo_pedido, codigo_producto, cantidad)
VALUES (1, 1, 5);

INSERT INTO PEDIDO_PRODUCTO (codigo_pedido, codigo_producto, cantidad)
VALUES (2, 2, 10);

INSERT INTO PEDIDO_PRODUCTO (codigo_pedido, codigo_producto, cantidad)
VALUES (3, 1, 2);

-- Insert para TIENDA_FACTURA
INSERT INTO TIENDA_FACTURA (codigo, codigo_pedido, fecha)
VALUES (1, 1, SYSDATE);

INSERT INTO TIENDA_FACTURA (codigo, codigo_pedido, fecha)
VALUES (3, 1, TO_DATE('2023-04-16', 'YYYY-MM-DD'));

INSERT INTO TIENDA_FACTURA (codigo, codigo_pedido, fecha)
VALUES (4, 2, TO_DATE('2023-04-15', 'YYYY-MM-DD'));