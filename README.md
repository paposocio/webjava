# javaWeb

Este repositorio contiene ejercicios de práctica en Java orientados a la web.

## Instalación

1. Clona este repositorio en tu máquina local.
2. Navega hasta la carpeta del proyecto.
3. Ejecuta el script de MySQL para configurar la base de datos.
4. Realiza las pruebas correspondientes.

## Configuración de la Base de Datos

El siguiente script crea la base de datos y la tabla necesaria para el proyecto:

```sql
create database MyApp;
use MyApp;
create table users_tbl
(
user_id int primary key auto_increment,
user_firstname varchar (40) not null,
user_lastname varchar (40) not null,
user_email varchar (60) not null,
user_password varbinary (256) not null
);

CREATE USER 'myappuser'@'%' IDENTIFIED BY 'mypassword';
GRANT SELECT, INSERT, UPDATE, DELETE ON MyApp.users_tbl TO 'myappuser'@'%';

INSERT INTO MyApp.users_tbl (user_firstname, user_lastname, user_email, user_password) 
VALUES (UPPER('JuAN'), UPPER('GaRZOn'), 'messi321@example.com',
AES_ENCRYPT('clavecuenta', '$2a$12$h.dl7n64P0qaGYnQfKgCSuzVKrh3q3p9xkZ/VxR6NtnN7Lud6of.u')
);

SELECT *, 
CAST(AES_DECRYPT(user_password, '$2a$12$h.dl7n64P0qaGYnQfKgCSuzVKrh3q3p9xkZ/VxR6NtnN7Lud6of.u') 
AS CHAR(50)) decrypted_pass FROM users_tbl WHERE user_id = 1;
```
## Autor

- Nombre: Sebastian Peña

 Soy Sebastian, el autor de este proyecto. Empleando Java he creado este repositorio de ejercicios de práctica orientados a la web.

Puede encontrarme en:

- [LinkedIn](https://www.linkedin.com)
- [Twitter](https://twitter.com)


