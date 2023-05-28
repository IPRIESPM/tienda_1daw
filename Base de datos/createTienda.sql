CREATE TABLE TIENDA_DIRECCION(
  codigo NUMBER(10) PRIMARY KEY,
  direccion VARCHAR2(100) NOT NULL,
  codigo_postal NUMBER(10) NOT NULL,
  ciudad VARCHAR2(50) NOT NULL,
  provincia VARCHAR2(50) NOT NULL
);

CREATE TABLE TIENDA_USUARIO (
  codigo NUMBER(10) PRIMARY KEY,
  email VARCHAR2(100) UNIQUE NOT NULL,
  nombre VARCHAR2(50) NOT NULL,
  apellido VARCHAR2(50) NOT NULL,
  contrasenya VARCHAR2(100) NOT NULL,
  ultima_conexion DATE,
  telefono VARCHAR2(20),
  fecha_nacimiento DATE,
  foto VARCHAR2(100),
  direccion NUMBER(10) NOT NULL,
  tipo VARCHAR2(10) NOT NULL CHECK (TIPO IN ('ADMIN', 'CLIENTE')),
  CONSTRAINT fk_usuarios_direcciones FOREIGN KEY (direccion) REFERENCES TIENDA_DIRECCION(codigo)
);


CREATE TABLE TIENDA_PEDIDO (
  codigo NUMBER(10) PRIMARY KEY,
  codigo_usuario NUMBER(10) NOT NULL,
  fecha DATE NOT NULL,
  estado VARCHAR2(20) NOT NULL,
  CONSTRAINT fk_pedidos_usuarios FOREIGN KEY (codigo_usuario) REFERENCES TIENDA_USUARIO(codigo)
);

CREATE TABLE TIENDA_CATEGORIA (
  codigo NUMBER(10) PRIMARY KEY,
  nombre VARCHAR2(100) NOT NULL
);

CREATE TABLE TIENDA_PRODUCTO (
  codigo NUMBER(10) PRIMARY KEY,
  codigo_categoria NUMBER(10) NOT NULL,
  nombre VARCHAR2(100) NOT NULL,
  descripcion VARCHAR2(500),
  precio NUMBER(10,2) NOT NULL,
  stock NUMBER(10) DEFAULT 200 NOT NULL,
  imagen VARCHAR2(100) DEFAULT 'GlitchSlime.webp' NOT NULL ,
  CONSTRAINT fk_productos_categorias FOREIGN KEY (codigo_categoria) REFERENCES TIENDA_CATEGORIA(codigo)
);

CREATE TABLE PEDIDO_PRODUCTO (
  codigo_pedido NUMBER(10),
  codigo_producto NUMBER(10),
  cantidad NUMBER(10) NOT NULL,
  CONSTRAINT pk_pedido_producto PRIMARY KEY (codigo_pedido, codigo_producto),
  CONSTRAINT fk_pedido_producto_pedido FOREIGN KEY (codigo_pedido) REFERENCES TIENDA_PEDIDO(codigo),
  CONSTRAINT fk_pedido_producto_producto FOREIGN KEY (codigo_producto) REFERENCES TIENDA_PRODUCTO(codigo)
);

CREATE TABLE TIENDA_FACTURA (
  codigo NUMBER(10) PRIMARY KEY,
  codigo_pedido NUMBER(10) NOT NULL,
  fecha DATE DEFAULT SYSDATE NOT NULL,
  CONSTRAINT fk_factura_pedido FOREIGN KEY (codigo_pedido) REFERENCES TIENDA_PEDIDO(codigo)
);


drop table tienda_Factura;
drop table pedido_producto;
drop table tienda_producto;
drop table tienda_Categoria;
drop table tienda_pedido;
drop table tienda_usuario;
drop table tienda_direccion;

-- CREATE SEQUENCE dept_seq START WITH 1;
-- ID  NUMBER(10) DEFAULT dept_seq.nextval NOT NULL