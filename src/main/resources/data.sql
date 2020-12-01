TRUNCATE TABLE marca;
insert into marca (id, nome) values 
    (1, 'GM'),
    (2, 'Toyota'),
    (3, 'Ford'),
    (4, 'Nissan'),
    (5, 'Fiat'),
    (6, 'Jeep');

truncate table modelo;
insert into modelo (id, nome, nroMarca) values 
    (1, 'Cruze',1),
    (2, 'Ethios',2),
    (3, 'F-1000',3),
    (4, 'Sentra',4),
    (5, 'Palio',5),
    (6, 'Compass',6);