# Memoria del proyecto

- [Memoria del proyecto](#memoria-del-proyecto)
  - [Presentacion](#presentacion)
  - [Para la base de datos](#para-la-base-de-datos)
  - [Para el backend](#para-el-backend)
  - [Para el frontend](#para-el-frontend)
  - [BASES DE DATOS](#bases-de-datos)
    - [Modelo entidad relación](#modelo-entidad-relación)
    - [DDL](#ddl)
    - [DML](#dml)
  - [Programación](#programación)
    - [Clases DAO](#clases-dao)
    - [Clases DTO](#clases-dto)
    - [Carrito](#carrito)
    - [Facturación](#facturación)
    - [Sesiones](#sesiones)
    - [Atributos y otros datos en servlets](#atributos-y-otros-datos-en-servlets)
  - [Frontend](#frontend)
  - [Mockup](#mockup)
    - [Primer desarrollo](#primer-desarrollo)
    - [Segundo desarrollo](#segundo-desarrollo)
  - [Estructuración del proyecto](#estructuración-del-proyecto)

## Presentacion

El proyecto consta de una tienda web, basada en el juego slimerancher, para ello se han utilizado las siguientes tecnologías:

## Para la base de datos

Para la base de datos hemos utilizado Oracle DB dentro de un contenedor de Docker, ahorrándonos la implementación de un servidor dedicado.

## Para el backend

El proyecto consta de server side rendering constituido en Java EE, utilizando servlets y las plantillas JSP.

## Para el frontend

Junto a las plantillas JSP hemos utilizado Webcomponents, para poder crear componentes aislados y reutilizables a lo largo del proyecto.

## BASES DE DATOS

Para la constitución de la base de datos hemos usado los siguientes pasos
Modelo Entidad relación
Modelo Relacional
DDL (Data Definition Language)
DML (Data Manipulation Language)

### Modelo entidad relación

Para el modelo entidad relación hemos utilizado la aplicación web LucidChart y dejamos un esquema estático de la base de datos junto al enlace al proyecto.

### DDL

Para el DDL hemos tenido en cuenta  algunas restricciones como la del tipo de usuario o los valores DEFAULT como los de las fotos, en el caso de que no se introduzca nada

### DML

Hemos introducido por defecto todos los Plorts del juego, así como su propia categoría, siendo este nuestro producto estrella, también todo tipo de alimentos.

## Programación

Para el apartado de backend del proyecto hemos intentado controlar toda las peticiones y tratamientos de datos a través de los servlets, para así usar solo las templates de JSP para mostrar datos o reutilizar vistas y archivos estáticos del FrontEnd.

### Clases DAO

Para controlar las llamadas a la base de datos hemos utilizado, clases con ese mismo fin llamadas DAO, esos datos obtenidos van a las clases dedicadas llamadas DAO, donde almacenamos la información para su posterior tratamiento.
DIAGRAMA DE CLASES DAO

### Clases DTO

Siendo las más importantes del proyecto, las clases de UsuarioDTO usado a lo largo del proyecto a través de sesiones, para validar y controlar los accesos a la web, así como las diferentes compras o acciones en la base de datos derivadas, La clase PedidoDTO, que hemos utilizado tanto para el pedido como para el carrito.

### Carrito

El carrito del proyecto tiene una mención especial ya que hemos obviado el almacenamiento de este en la base de datos, nuestro carrito de compras solo es válido durante la sesión del usuario, siendo convirtiéndose en un pedido en firme a la hora de confirmación del mismo, para la confirmación del carrito se siguen una serie de pasos:
Se comprueba de que hay stock suficiente para poder crear el pedido
Si hay stock suficiente pasamos a la creación del pedido, descontando las unidades pedidas de la base de datos.
En el caso de lo contrario se devuelve un mensaje de error al usuario en la vista del carrito de la compra.

### Facturación

Una vez realizado el pedido este se podrá facturar, y generar los pdf y xml pertinentes.

### Sesiones

Para los datos de la sesión, siempre seguimos el mismo procedimiento, comprobamos que el dato de la sesión no sea nulo, y en el caso de ser cierto creamos una clase DTO, correspondiente vacía, usando una forma adaptada del concepto Java Beans.

### Atributos y otros datos en servlets

Para el tratamiento de los atributos y datos que se manejan en la aplicación por parte del usuario, comprobamos la existencia de estos atributos si no existen creemos vacíos o devolvemos la navegación en caso de ser oportuno, para el envío de estos correctamente, y por último validamos si el tipo de dato correspondiente es el que se necesita, en caso contrario, devolvemos la navegación con un mensaje de error en el frontend.

## Frontend

El frontend ha sido desarrollado en dos versiones principales, a partir del mismo mockup.

## Mockup

para ello se ha utilizado la herramienta de Figma para el diseño intentando emular el principio de diseño atómico, que a grandes rasgos consta de crear elementos independientes para poder crear conjuntos compuestos de estos más simples, dando autonomía y escalabilidad al proyecto, simulando los principios de clases y funciones usando en el backend.

Dentro del mockup podemos ver cada elemento del diseño separado en componentes que luego usaremos para montar el programa final.

Enlace al mockup
Enlace al live Preview del mockup

### Primer desarrollo

Para el primer desarrollo se consideró el montaje del proyecto usando el framework de JavaScript Astro js, ya que permite la generación de proyectos SSR, es decir Server Side Rendering, contenidos estáticos, generados en el servidor, pudiendo simular el entorno de JSP y java, antes de que este mismo finalice.

Más información acerca de Astro.js

Versión de Astro

### Segundo desarrollo

Para el segundo desarrollo fue necesario la fusión de los apartados del mockup junto con los jsp usando lo aprendido en la versión de astro, ya que pudimos distribuir y re-utilizar tanto las vistas y los elementos de una manera más homogénea. para ello intentamos convertir los componentes usados en Figma
en WebComponents

## Estructuración del proyecto

Hemos dividido el proyecto en cuatro partes, dos para los DAO y DTO mencionados anteriormente,
una parte dedicada a los SERVLETS y por último una clase dedicada a la verificación de sesiones y datos.

Para el apartado de frontend tenemos:

- el Directorio assets, donde se encuentran las imágenes y los audios del proyecto.
- El directorio components, donde se encuentran los componentes simples y compuestos de WebComponents
- El directorio styles con los css generales
- El directorio templates con las plantillas del header, head y footer
