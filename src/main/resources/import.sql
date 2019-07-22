/* Populate tabla region */
INSERT INTO regiones(id, nombre) VALUES (1, 'Sudamerica');
INSERT INTO regiones(id, nombre) VALUES (2, 'Centroamérica');
INSERT INTO regiones(id, nombre) VALUES (3, 'Norteamérica');
INSERT INTO regiones(id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones(id, nombre) VALUES (5, 'Asia');
INSERT INTO regiones(id, nombre) VALUES (6, 'Africa');
INSERT INTO regiones(id, nombre) VALUES (7, 'Oceanía');
INSERT INTO regiones(id, nombre) VALUES (8, 'Antártida');

/* Populate tabla clientes */
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(1, 'Puto Amo', 'Campuzano Guillén', 'anton@hotmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(2, 'Antonio ', 'Campuzano Guillén', 'antoni@hotmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(3, 'Esteban', 'Campuzano Guillén', 'antonmpuzano@hotmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(1, 'Antoteban', 'Campuzano Guillén', 'aoecampuzano@hmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(5, 'Antan', 'Campuzano Guillén', 'anoecampno@hotmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(4, 'Aasn', 'Campuzano Guillén', 'antonano@hotmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(6, 'Antonieban', 'Campuzano Guillén', 'antampuzano@hoail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(7, 'Anbafn', 'Campuzano Guillén', 'antonioecamano@hotmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(8, 'Annita', 'Campuzano Guillén', 'antonioecampuzano@hoil.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(6, 'Tristan', 'Morente Trajero', 'tristan@hoil.com', '2019-05-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(5, 'Trilero', 'Jareno Trajero', 'chilapa@hoil.com', '2017-02-04');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(4, 'Pepito', 'Conejo', 'ñaca@hoil.com', '2017-05-05');

/* Creamos usuarios con sus roles */

INSERT INTO usuarios(username, password, enabled) VALUES ('campu', '$2a$10$UoCe6p45hWtFgAq/WD.ifu8EsK6/F8B6uibOfFltWv25J6aG4exLa', true);
INSERT INTO usuarios(username, password, enabled) VALUES ('admin', '$2a$10$Sj5dl2ewEDGByLOcuQWUQ.47OuugTtwWjC.C7wsFNKrfGU.oFVIMO', true);

INSERT INTO roles(nombre) VALUES ('ROLE_USER');
INSERT INTO roles(nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles(usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES (2, 1);
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES (2, 2);