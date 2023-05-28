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


-- Insert para TIENDA_PRODUCTO
INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (1, 1, 'Plort rosa', 'Un Plort de color rosa brillante generado por los Slimes Rosas. Es común y tiene un valor moderado en el mercado.', 7, 200, 'PlortPINK.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (2, 1, 'Plort Roca', 'Un Plort de color azul generado por los Slimes Roca. Es muy valioso y se utiliza en la construcción y fabricación de materiales', 16, 200, 'PlortROCK.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (3, 1, 'Plort Atigrado', 'Un Plort de color grisáceo generado por los Slimes Atigrados. Tiene un patrón de rayas distintivo .', 24, 200, 'PlortTABBY.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (4, 1, 'Plort Fósforo', 'Tiene un brillo suave y una tonalidad azulada. El Plort Fósforo es conocido por emitir una suave luz en la oscuridad, lo que lo hace ideal para iluminación y energía.', 17, 200, 'PlortPHOSPHOR.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (5, 1, 'Plort Miel', 'Un Plort de color amarillo dorado generado por los Slimes Miel. Tiene una consistencia pegajosa y un aroma dulce. Es muy solicitado en el mercado debido a su valor culinario y se utiliza en la producción de diversos productos.', 28, 200, 'PlortHONEY.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (6, 1, 'Plort Boom', ' Un Plort de color marrón generado por los Slimes Cazador. Tienen un pelaje marrón oscuro y una apariencia sigilosa. Son conocidos por su naturaleza cazadora y por su capacidad para emboscar a sus presas. Los Plorts Cazador tienen un alto valor en el mercado y se utilizan en diversas aplicaciones', 26, 200, 'PlortBOOM.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (7, 1, 'Plort Cazador', 'Un Plort de color rojo generado por los Slimes Boom. Tiene una apariencia explosiva y un alto valor en el mercado. Los Plorts Boom son conocidos por su tendencia a explotar cuando se agitan o se les somete a presión, lo que los hace peligrosos de manejar sin precaución.', 35, 200, 'PlortHUNTER.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (8, 1, 'Plort Charco', 'Un Plort de color azul generado por los Slimes Charco. Son criaturas acuosas y suaves que viven en cuerpos de agua. Los Plorts Charco son muy solicitados en el mercado y se utilizan en diversas aplicaciones relacionadas con el agua.', 20, 200, 'PlortPUDDLE.webp');


INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (9, 1, 'Plort Cristal', 'Un Plort de aspecto translúcido y brillo característico generado por los Slimes Cristal. Tienen una apariencia cristalina y reflejan la luz de manera única. Los Plorts Cristal son muy valorados en el mercado debido a su belleza y a su utilidad en la fabricación de tecnología avanzada.', 37, 200, 'PlortCRYSTAL.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (10, 1, 'Plort Cuántico', 'Un Plort de aspecto brillante y pulsante generado por los Slimes Cuántico. Tienen propiedades cuánticas únicas que les permiten desaparecer y reaparecer en diferentes ubicaciones. Los Plorts Cuántico son altamente valorados en el mercado debido a su rareza y a las aplicaciones científicas y tecnológicas que ofrecen. Tienen un color amarillo brillante y emiten destellos luminosos. ', 53, 200, 'PlortQUANTUM.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (11, 1, 'Plort Derviche', 'Los Plorts Derviche tienen una apariencia turbulenta y enérgica, con colores vibrantes y tonos caóticos. Son altamente valorados en el mercado debido a su rareza y a su conexión con la energía giratoria de los Slimes Derviche. Los Plorts Derviche reflejan la naturaleza dinámica y frenética de estos Slimes.', 50, 200, 'PlortDERVISH.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (13, 1, 'Plort Fuego', ' Los Plorts Fuego tienen un intenso color rojo y un brillo ardiente. Son altamente valorados en el mercado debido a su rareza y a las propiedades inflamables asociadas con los Slimes Fuego. Estos Plorts representan el elemento fuego y pueden ser utilizados en diversas aplicaciones tecnológicas y alquímicas. ', 40, 200, 'PlortFIRE.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (14, 1, 'Plort Mosaico', 'Los Plorts Mosaico exhiben un patrón multicolor y fragmentado que recuerda a un mosaico artístico. Tienen una apariencia brillante y vibrante, con una combinación de colores llamativos. Los Plorts Mosaico son altamente valorados en el mercado debido a su rareza y a las propiedades visuales únicas que poseen.', 60, 200, 'PlortMOSAIC.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (15, 1, 'Plort Sable', 'Los Plorts Sable tienen una apariencia oscura y brillante, similar al brillo de una hoja de acero afilada. Presentan un tono negro intenso con destellos plateados. Los Plorts Sable son altamente valorados en el mercado debido a su rareza y a las propiedades afiladas y resistentes que poseen.', 48, 200, 'PlortSABER.webp');

-- vegetales

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (16, 2, 'Zanahoria', 'Jugosas y crujientes zanahorias frescas, perfectas para alimentar a tus slimes hambrientos.', 10, 500, 'Zanahoria.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (17, 2, 'Remolacha Corazón', 'Las remolachas en forma de corazón, tiernas y llenas de amor. Son un manjar especial para los slimes más exigentes.', 15, 300, 'RemolachaCorazon.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (18, 2, 'Oca Oca', 'Pequeñas ocas de colores vibrantes que crecen en tu granja. Estas delicias vegetales son apreciadas por los slimes y les proporcionan una buena dosis de energía.', 18, 350, 'OcaOca.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (19, 2, 'Cebolla Extraña', 'Una cebolla peculiar con un sabor único. Los slimes se sienten atraídos por su aroma distintivo y su jugo picante.', 20, 250, 'CebollaExtrana.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (20, 2, 'Nabo Plateado', 'Un raro nabo plateado que brilla bajo la luz de la luna. Los slimes lo encuentran irresistible y produce plorts de alta calidad.', 25, 200, 'NaboPlateado.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (21, 2, 'Genjibre Dorado', 'Una raíz de genjibre dorada y reluciente que emana un aroma cálido y picante. Los slimes encuentran su sabor exquisito y energizante.', 15, 300, 'JengibreDorado.webp');

-- fruta

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (22, 3, 'Pogofruta', 'Una fruta de apariencia similar a la granada, con una piel roja y una forma redonda. Al abrirla, revela múltiples jugosos y dulces compartimentos que encantan a los slimes.', 8, 500, 'Pogofruta.webp');
INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (23, 3, 'Cubaya', 'Una exótica fruta amarilla con una cáscara rugosa. Los slimes adoran su sabor tropical y refrescante.', 10, 400, 'Cubaya.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (24, 3, 'Mango Menta', 'Un mango de tono verde intenso con un toque refrescante a menta. Los slimes encuentran su combinación de sabores deliciosa.', 12, 350, 'MangoMenta.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (25, 3, 'Limón de Fase', 'Un limón especial que parece tener destellos interdimensionales. Los slimes se sienten revitalizados al saborearlo.', 15, 300, 'LimonFase.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (26, 3, 'Pera Espinosa', 'Una jugosa pera con espinas suaves en su piel. Los slimes adoran el equilibrio entre lo dulce y lo picante de su sabor.', 18, 250, 'PeraEspinosa.webp');

INSERT INTO TIENDA_PRODUCTO (codigo, codigo_categoria, nombre, descripcion, precio, stock, imagen)
VALUES (27, 3, 'Kokadoba', 'Una fruta extraña y misteriosa con un aroma embriagador. Los slimes se sienten atraídos por su sabor único y exótico.', 20, 200, 'Kokadoba.webp');

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