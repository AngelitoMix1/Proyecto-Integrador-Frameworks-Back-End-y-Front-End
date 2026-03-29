Descripción del Proyecto

Este sistema es una solución Full Stack integral para la administración de expedientes de alumnos. La característica principal de este proyecto es su arquitectura de backend intercambiable: el Frontend desarrollado en Angular es capaz de consumir servicios de un servidor robusto en Java (Spring Boot) o de un servidor ligero en Node.js (Express), manteniendo la integridad de los datos en una base de datos centralizada en MySQL.

Arquitectura del Sistema

El proyecto sigue el patrón Modelo-Vista-Controlador (MVC) y está dividido en capas desacopladas:

Frontend (Capa de Presentación):
Desarrollado con Angular 16 y estilizado con Tailwind CSS. Implementa una interfaz reactiva que consume APIs REST de forma dinámica.
Backend A (Java):
Desarrollado con Spring Boot, utilizando JPA/Hibernate para la persistencia de datos (Puerto 8081).
Backend B (Node.js):
Desarrollado con Express.js, optimizado para una respuesta rápida mediante el driver mysql2 (Puerto 3000).
Base de Datos:
MySQL, donde reside la tabla tbl_student compartida por ambos backends.

Guía de Ejecución 
1. Configuración de la Base de Datos 

Antes de ejecutar los servidores, es necesario montar la estructura de datos:

Abre MySQL Workbench.
Ejecuta el script incluido en este repositorio: crud.ql.
El script creará la base de datos crud_db y la tabla tbl_student con datos de prueba iniciales.
2. Backend con Node.js (Puerto 3000) 
Abre una terminal en la carpeta /backend-node.
Instala las dependencias:
npm install
Inicia el servidor:
node index.js

El servidor confirmará la conexión a MySQL en la consola.

3. Backend con Spring Boot (Puerto 8081) 
Abre la carpeta /CrudDemo en IntelliJ IDEA.
Verifica que las credenciales de MySQL en
src/main/resources/application.properties sean correctas.
Ejecuta la clase principal:
CrudDemoApplication.java

El servidor levantará en el puerto 8081.

4. Frontend con Angular (Puerto 4200) 
Abre una terminal en la carpeta /frontend.
Instala las dependencias:
npm install
Inicia la aplicación:
ng serve
Abre tu navegador en:
http://localhost:4200
Tecnologías Utilizadas
Frontend: Angular 16, TypeScript, Tailwind CSS
Backend Java: Spring Boot 3, Spring Data JPA, Hibernate, Maven
Backend Node: Express.js, MySQL2, CORS
Base de Datos: MySQL 8.0
Herramientas: Postman, MySQL Workbench, Git/GitHub
📁 Estructura del Repositorio
/
├── frontend/             # Aplicación cliente Angular
├── CrudDemo/             # Backend Java/Spring Boot
├── backend-node/         # Backend Node.js/Express
├── crud.ql               # Script SQL de la Base de Datos
└── README.md             # Documentación oficial
Notas Finales
Puedes alternar entre backend Java y Node sin modificar el frontend (solo cambiando la URL del API).
Asegúrate de que MySQL esté corriendo antes de iniciar los servidores.
Verifica los puertos para evitar conflictos.
