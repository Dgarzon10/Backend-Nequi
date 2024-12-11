# Franquicias API
Este proyecto es una API de gestión de franquicias desarrollada con **Spring Boot** y **Docker**. El objetivo es proporcionar una solución escalable y sencilla para gestionar franquicias, productos y sucursales.

## Requisitos previos

Antes de ejecutar este proyecto, asegúrate de tener instalados los siguientes programas en tu máquina:
- Java JDK 17 instalado en tu máquina
- Docker
- Maven 3.7 o posterior instalado

## Instalación

### Paso 1: Clonar el repositorio

Primero, clona el repositorio del proyecto en tu máquina local:

```bash
git clone https://github.com/Dgarzon10/Backend-Nequi
cd franquicias-api/franquicias-api
```
### Paso 2: Construir la aplicación
Se requiere tener instalado maven.
```bash
mvn clean package
```

### Paso 3: Construir imagen y levantar contenedor
Este proyecto incluye un archivo docker-compose.yml que levanta los contenedores necesarios para la base de datos MySQL y la aplicación Spring Boot.
Se requiere de Docker.
```bash
docker-compose up --build
```
Este comando construye la imagen de Docker para la aplicación y la inicia junto con la base de datos MySQL.

### Paso 4: Acceder a la aplicación
Una vez que los contenedores estén en funcionamiento, podrás acceder a la API de la aplicación en:

*http://localhost:8080*

#### Rutas
Todas las rutas comparten: */api/v1/*

##### Franquicia
- Ruta Principal :  *http://localhost:8080/api/v1/franquicias*
Esta posee los metodos GET, DELETE, POST

- Ruta modificación nombre: *http://localhost:8080/api/v1/franquicias/nombre/{id}*

- Ruta Stock por sucursal: *http://localhost:8080/api/v1/franquicias/maxStock/{id}*

##### Sucursal
- Ruta Principal :  *http://localhost:8080/api/v1/sucursal*
Esta posee los metodos GET, DELETE, POST

- Ruta modificación nombre: *http://localhost:8080/api/v1/sucursal/nombre/{id}*


##### Producto
- Ruta Principal :  *http://localhost:8080/api/v1/producto*
Esta posee los metodos GET, DELETE, POST

- Ruta modificación nombre: *http://localhost:8080/api/v1/producto/nombre/{id}*

- Ruta modificación stock: *http://localhost:8080/api/v1/producto/stock/{id}*
