-- 3 consultas de la sintaxis select básica (práctica 5.1)
SELECT *
FROM tienda_usuario;

SELECT nombre, precio
FROM tienda_producto
WHERE precio > 50;

SELECT *
FROM TIENDA_FACTURA F
LEFT JOIN TIENDA_PEDIDO P ON P.CODIGO = F.CODIGO_PEDIDO 
LEFT JOIN TIENDA_USUARIO U ON U.CODIGO = P.CODIGO_USUARIO
WHERE U.CODIGO = 1;

-- 3 consultas usando funciones SQL (práctica 5.2)

SELECT SYSDATE FROM dual;

SELECT AVG(precio) FROM tienda_producto;

SELECT SUM(cantidad) FROM Pedido_Producto;


-- 3 consultas usando Agrupaciones, combinaciones u operaciones de conjuntos (práctica 5.3).

SELECT c.nombre, SUM(pp.cantidad) as cantidad_total
FROM tienda_categoria c
INNER JOIN tienda_producto p ON c.codigo = p.codigo_categoria
INNER JOIN Pedido_Producto pp ON p.codigo = pp.codigo_producto
GROUP BY c.nombre;

SELECT u.nombre, d.direccion, d.ciudad, d.provincia, d.codigo_postal
FROM tienda_usuario u
INNER JOIN tienda_pedido p ON u.codigo = p.codigo_usuario
INNER JOIN tienda_direccion d ON u.direccion = d.codigo;

SELECT p.nombre
FROM tienda_producto p
LEFT JOIN Pedido_Producto pp ON p.codigo = pp.codigo_producto
WHERE pp.cantidad IS NULL;

-- 1 vista, un insert y un borrado o actualización desde select, en total, serán tres sentencias. (práctica 5.4).
CREATE VIEW vista_usuarios_adultos AS
SELECT nombre, email, fecha_nacimiento
FROM tienda_usuario
WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, fecha_nacimiento) / 12) >= 18;

INSERT INTO tienda_producto (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (123, 1, 'Nuevo producto', 'Descripción del nuevo producto', 29.99, 50, null);

DELETE FROM Producto
WHERE codigo IN (
    SELECT p.codigo
    FROM Producto p
    LEFT JOIN Pedido_Producto pp ON p.codigo = pp.codigo_producto
    WHERE pp.cantidad IS NULL
);
