-- 3 consultas de la sintaxis select básica (práctica 5.1)
SELECT *
FROM Usuario;

SELECT nombre, precio
FROM Producto
WHERE precio > 50;

SELECT direccion, ciudad, provincia, codigo_postal
FROM Usuario
WHERE ultima_conexion > '2022-01-01';

-- 3 consultas usando funciones SQL (práctica 5.2)

SELECT SYSDATE FROM dual;

SELECT AVG(precio) FROM Producto;

SELECT SUM(cantidad) FROM Pedido_Producto;


-- 3 consultas usando Agrupaciones, combinaciones u operaciones de conjuntos (práctica 5.3).

SELECT c.nombre, SUM(pp.cantidad) as cantidad_total
FROM Categoria c
INNER JOIN Producto p ON c.codigo = p.codigo_categoria
INNER JOIN Pedido_Producto pp ON p.codigo = pp.codigo_producto
GROUP BY c.nombre;

SELECT u.nombre, d.direccion, d.ciudad, d.provincia, d.codigo_postal
FROM Usuario u
INNER JOIN Pedido p ON u.codigo = p.codigo_usuario
INNER JOIN Direccion d ON u.direccion = d.codigo;

SELECT p.nombre
FROM Producto p
LEFT JOIN Pedido_Producto pp ON p.codigo = pp.codigo_producto
WHERE pp.cantidad IS NULL;

-- 1 vista, un insert y un borrado o actualización desde select, en total, serán tres sentencias. (práctica 5.4).
CREATE VIEW vista_usuarios_adultos AS
SELECT nombre, email, fecha_nacimiento
FROM Usuario
WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, fecha_nacimiento) / 12) >= 18;

INSERT INTO Producto (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (123, 1, 'Nuevo producto', 'Descripción del nuevo producto', 29.99, 50, 'imagen_producto.jpg');

DELETE FROM Producto
WHERE codigo IN (
    SELECT p.codigo
    FROM Producto p
    LEFT JOIN Pedido_Producto pp ON p.codigo = pp.codigo_producto
    WHERE pp.cantidad IS NULL
);
