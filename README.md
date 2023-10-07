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

create table categories
(
category_id int auto_increment primary key,
category_name varchar(255)
);

create table products
(
product_id int auto_increment primary key,
product_name varchar(255),
product_value int,
categoryid int,
foreign key (categoryid) references categories(category_id)
);


INSERT INTO MyApp.users_tbl (user_firstname, user_lastname, user_email, user_password) 
VALUES (UPPER('nombres'), UPPER('apellidos'), 'buzon@correo.com',
AES_ENCRYPT('password', '$2a$12$h.dl7n64P0qaGYnQfKgCSuzVKrh3q3p9xkZ/VxR6NtnN7Lud6of.u
')
);

insert into myapp.categories (category_name)
values (('categoria3'));

CREATE USER 'myappuser'@'localhost' IDENTIFIED BY 'mypassword';
GRANT SELECT, INSERT, UPDATE, DELETE ON myapp.users_tbl TO 'myappuser'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON myapp.products TO 'myappuser'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON myapp.categories TO 'myappuser'@'localhost';
```
## Autor

- Nombre: Sebastian Peña

 Soy Sebastian, el autor de este proyecto. Empleando Java he creado este repositorio de ejercicios de práctica orientados a la web.

Puede encontrarme en:

- [LinkedIn](https://www.linkedin.com)


