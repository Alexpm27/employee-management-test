# Employee CRUD


## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.3.4**
- **JPA**
- **Maven**
- **MySQL**


## Instalación

#### 1. Clonar el repositorio


`git clone https://github.com/Alexpm27/task-management-technical-test`

#### 2. Configurar la base de datos
Asegúrate de tener una base de datos MySQL y configurar las credenciales en el archivo `application.properties`:

``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_la_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

También debes crear la base de datos en MySQL:


``` sql
CREATE DATABASE nombre_de_la_db;
```
#### 3. Instalar dependencias
Usa Maven para descargar las dependencias del proyecto.


``` bash
mvn clean install
```
#### 4. Ejecutar la aplicación
Puedes ejecutar la aplicación con el siguiente comando:

``` bash
mvn spring-boot:run
```
La aplicación estará disponible en http://localhost:8080.

## Uso en POSTMAN
Link de la documentación: https://documenter.getpostman.com/view/37780983/2sAXxS8XTL
#### POST

[![Screenshot-2024-10-12-at-6-09-50-p-m.png](https://i.postimg.cc/C1SG37R9/Screenshot-2024-10-12-at-6-09-50-p-m.png)](https://postimg.cc/JyYHJbcQ)

Se valida los atributos name, salary y hiringDate que estén correctos.
[![Screenshot-2024-10-12-at-6-10-29-p-m.png](https://i.postimg.cc/1zp0723p/Screenshot-2024-10-12-at-6-10-29-p-m.png)](https://postimg.cc/06yJbtmQ)

#### GET
[![Screenshot-2024-10-12-at-6-10-55-p-m.png](https://i.postimg.cc/W4R6nTTN/Screenshot-2024-10-12-at-6-10-55-p-m.png)](https://postimg.cc/qNL3BfNS)

Cuando el id no existe:
[![Screenshot-2024-10-12-at-6-11-14-p-m.png](https://i.postimg.cc/bNJTYmmh/Screenshot-2024-10-12-at-6-11-14-p-m.png)](https://postimg.cc/3WspnFMS)
#### GET ALL
[![Screenshot-2024-10-12-at-6-13-48-p-m.png](https://i.postimg.cc/8zfmMj8X/Screenshot-2024-10-12-at-6-13-48-p-m.png)](https://postimg.cc/21mWfjSn)

#### UPDATE
[![Screenshot-2024-10-12-at-6-14-45-p-m.png](https://i.postimg.cc/dtx9hGfT/Screenshot-2024-10-12-at-6-14-45-p-m.png)](https://postimg.cc/JGjXgHM1)

#### DELETE
[![Screenshot-2024-10-12-at-6-15-15-p-m.png](https://i.postimg.cc/66zcNkLc/Screenshot-2024-10-12-at-6-15-15-p-m.png)](https://postimg.cc/fktmcgPS)
