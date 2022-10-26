/* Creamos algunos productos */
INSERT INTO producto (nombre, descripcion, existencias, precio_unit) VALUES ('Zapatillas', 'Zapatillas negras', 100, 20.2);
INSERT INTO producto (nombre, descripcion, existencias, precio_unit) VALUES ('Reloj', 'Reloj Rolex', 5, 350);
INSERT INTO producto (nombre, descripcion, existencias, precio_unit) VALUES ('Portatil', 'HP Elitebook 840', 40, 800);

/* Creamos algunos clientes */
INSERT INTO cliente (nombre, apellidos, sexo, telefono) VALUES ('Pepe', 'Vile Mes', 'hombre', '666666660');
INSERT INTO cliente (nombre, apellidos, sexo, telefono) VALUES ('Carlos', 'Raez Escobar', 'hombre', '666666661');
INSERT INTO cliente (nombre, apellidos, sexo, telefono) VALUES ('Luisa', 'Perez Galdo', 'mujer', '666666662');

/* Creamos algunas ventas */
INSERT INTO venta (cliente_no_cliente, producto_clave, cantidad, iva, subtotal, total) VALUES (1, 1, 2, 21, 40.4, 48.88);