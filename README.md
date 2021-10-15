# API REST MANAGEMENT TELCONET

### Logica:
Este servicio permitira la administracion de: Usuarios, Aplicaciones, Roles  **ACME SA**
------------------------------------------------------------------------------------------------------------

## Desplegar Servicio
Antes de desplegar el servicio se debe considerar la instalaccion de las siguientes herramientas:
* [JDK11](https://adoptopenjdk.net/)
* [Maven](https://maven.apache.org/download.cgi)
* [Docker](https://docs.docker.com/desktop/windows/install/)
* [Angular](https://angular.io/cli)
* [Node Js](https://nodejs.org/es/download/)

Una vez instaladas las herramientas se procede a:

**BACKEND**
1. Crear una carpeta vacia
2. Descargar del repositorio *GitHub* en la carpeta creada
3. Una vez descargado abrir una terminal en la direccion de la carpeta
4. Ingresar a la carpeta docker:
    * Debe ejecutar el siguiente comando: **docker-compose -f db.yml up -d**, esto levantara el contenedor de la base de datos
5. Ponerse en la carpeta raiz del proyecto
6. Para generar el .jar de nuestro servicio debe ejecutar el siguiente comando:
    * *mvn clean install*
7. Para levantar el servicio en un contenedor:
    1. Acceder a la carpeta docker
    2. Debe ejecutar el siguiente comando: **docker-compose -f micro.yml up -d**, esto levantara el contenedor servicio
    3. Mientras levanta se guardaran registros en la base de datos
8. Para comprobar que el servicio se levanto, ejecutar el siguiente comando:
    * docker ps, el cual le mostrara dos contenedores:
        1. Base de datos
        2. Servicio de Spring Boot
9. Para poder visualizar la documentacion de Swagger, se debe dirigir a la siguente [ruta](http://localhost:8090/api/v1/swagger-ui.html)
10. Podra ejecutar los servicios.

**FRONTEND**
1. Ir a la carpeta app-manager y abrir un terminal 
2. Ejecutar las siguiente comandos
    * Para descargar los librerias *npm install*
    * Para levantar el frontend *npm serve*
3. Una vez levantado el frontend dirigirse a la siguiente ruta [ruta](http://localhost:4200/)
