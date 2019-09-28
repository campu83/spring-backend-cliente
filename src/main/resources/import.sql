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
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(3, 'Fran', 'Campuzano Guillén', 'antonmpuzano@hotmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(1, 'Esteban', 'Campuzano Guillén', 'aoecampuzano@hmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(5, 'Marcos', 'Campuzano Guillén', 'anoecampno@hotmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(4, 'Luis', 'Campuzano Guillén', 'antonano@hotmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(6, 'Alfonso', 'Campuzano Guillén', 'antampuzano@hoail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(7, 'Sebastian', 'Campuzano Guillén', 'antonioecamano@hotmail.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(8, 'Annita', 'Campuzano Guillén', 'antonioecampuzano@hoil.com', '2019-01-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(6, 'Tristan', 'Morente Trajero', 'tristan@hoil.com', '2019-05-01');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(5, 'Trilero', 'Jareno Trajero', 'chilapa@hoil.com', '2017-02-04');
INSERT INTO clientes(region_id, nombre, apellido, email, create_at) VALUES(4, 'Pepito', 'Conejo', 'yaca@hoil.com', '2017-05-05');

/* Creamos usuarios con sus roles */

INSERT INTO usuarios(username, password, enabled, nombre, apellidos, email) VALUES ('campu', '$2a$10$UoCe6p45hWtFgAq/WD.ifu8EsK6/F8B6uibOfFltWv25J6aG4exLa', true, 'Antonio', 'Campuzano', 'antonioecampuzano@hotmail.com');
INSERT INTO usuarios(username, password, enabled, nombre, apellidos, email) VALUES ('admin', '$2a$10$Sj5dl2ewEDGByLOcuQWUQ.47OuugTtwWjC.C7wsFNKrfGU.oFVIMO', true, 'Pepe', 'Conejo', 'tirori@yopmail.com');

INSERT INTO roles(nombre) VALUES ('ROLE_USER');
INSERT INTO roles(nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles(usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES (2, 1);
INSERT INTO usuarios_roles(usuario_id, role_id) VALUES (2, 2);

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES ('Procesador AMD Ryzen 5 2600 3.4 Ghz',123.99,NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Altavoz Woxter Dynamic Line',44.99,NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Samsung QE55Q60RATXXC 55" QLED UltraHD 4K',879,NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Razer Kraken X Lite Auriculares Gaming 7.1 Multiplataforma',49.99,NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Sapphire Pulse Radeon RX 580 8GB GDDR5',179.90,NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Bicicleta molona',199,NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Huawei Mate 20 Lite 4/64GB Azul Libre',189,NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Xiaomi Mi Mix 2S 128Gb Negro Libre',329,NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('OnePlus 6T 8GB/256Gb Midnight Black Libre',499,NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Apple iPhone 8 Plus 64Gb Plata Libre',659,NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Apple iPhone XR 64Gb Blanco Libre',709,NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Samsung Galaxy S10+ 128GB Negro Libre VersiÃ³n Importada EU',759,NOW());

/* Populate table facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES (3, 2, 6);