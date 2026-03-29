#  Sistema de Administración (Full Stack)

Este sistema es una solución **Full Stack** integral diseñada para la administración eficiente de expedientes de alumnos. La característica distintiva de este proyecto es su **arquitectura de backend intercambiable**.

El Frontend, desarrollado en **Angular**, tiene la flexibilidad de consumir servicios de un servidor robusto en **Java (Spring Boot)** o de un servidor ligero en **Node.js (Express)**, manteniendo siempre la integridad de los datos en una base de datos centralizada en **MySQL**.

---

##  Arquitectura del Sistema

El proyecto implementa el patrón **Modelo-Vista-Controlador (MVC)** y se divide en capas totalmente desacopladas:

* **Frontend (Capa de Presentación):** Desarrollado con **Angular 16** y estilizado con **Tailwind CSS**. Implementa una interfaz reactiva que consume APIs REST de forma dinámica.
* **Backend A (Java):** Desarrollado con **Spring Boot**, utilizando **JPA/Hibernate** para la persistencia de datos (Puerto `8081`).
* **Backend B (Node.js):** Desarrollado con **Express.js**, optimizado para respuestas rápidas mediante el driver `mysql2` (Puerto `3000`).
* **Base de Datos:** **MySQL**, donde reside la tabla `tbl_student` compartida por ambos backends.

---

## Guía de Ejecución

### 1. Configuración de la Base de Datos
Antes de iniciar los servidores, es necesario montar la estructura de datos:
1. Abre **MySQL Workbench**.
2. Ejecuta el script incluido en este repositorio: `crud.sql`.
3. El script creará la base de datos `crud_db` y la tabla `tbl_student` con datos de prueba iniciales.

### 2. Backend con Node.js (Puerto 3000)
1. Abre una terminal en la carpeta `/backend-node`.
2. Instala las dependencias:
   
   npm install

 3. Inicia el servidor:
   node index.js

El servidor confirmará la conexión a MySQL en la consola.

### 3. Backend con Spring Boot (Puerto 8081)
1. Abre la carpeta /backend-spring en IntelliJ IDEA (o tu IDE preferido).

2. Verifica que las credenciales de MySQL en src/main/resources/application.properties sean correctas.

3. Ejecuta la clase principal: CrudDemoApplication.java.
El servidor levantará automáticamente en el puerto 8081.

### 4. Frontend con Angular (Puerto 4200)
1. Abre una terminal en la carpeta /frontend.

2. Instala las dependencias:

npm install

3. Inicia la aplicación:

ng serve

4. Abre tu navegador en: http://localhost:4200

### 5. Tecnologías Utilizadas
FrontendAngular 16, TypeScript, Tailwind CSSBackend JavaSpring Boot 3, Spring Data JPA, Hibernate, MavenBackend NodeExpress.js, MySQL, CORSBase de DatosMySQL. 0HerramientasPostman, MySQL Workbench, 

### 6. Notas: 
1. Intercambiabilidad: Puedes alternar entre el backend de Java y Node sin necesidad de modificar el código del frontend (solo ajustando la URL del API).

2. Pre-requisitos: Asegúrate de que el servicio de MySQL esté activo antes de iniciar cualquiera de los servidores.

3. Puertos: Verifica que los puertos 3000, 8081 y 4200 estén libres para evitar conflictos de red.

### 7. Estructura del Repositorio 📂

```text
/
├── frontend/        # Aplicación cliente Angular
├── CrudDemo/        # Backend Java/Spring Boot
├── backend-node/    # Backend Node.js/Express
├── crud.sql         # Script SQL de la Base de Datos
└── README.md        # Documentación oficial
