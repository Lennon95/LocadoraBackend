
insert into marca (id, nome) values 
    (1, 'GM'),
    (2, 'Toyota'),
    (3, 'Ford'),
    (4, 'Nissan'),
    (5, 'Fiat'),
    (6, 'Jeep');

insert into modelo (id, nome, idmarca) values 
    (1, 'Cruze',1),
    (2, 'Ethios',2),
    (3, 'F-1000',3),
    (4, 'Sentra',4),
    (5, 'Palio',5),
    (6, 'Compass',6);

insert into carro (id, placa, idmarca, idmodelo, arCondicionado, direcao, cambioAutomatico, km, cor) values 
    (1, "APX-1232", 1, 1, true, true, true, 0, 'Preto'),
    (2, "APX-1233", 1, 1, true, true, true, 0, 'Preto'),
    (3, "APX-1234", 1, 1, true, true, true, 0, 'Preto'),
    (4, "APX-1235", 1, 1, true, true, true, 0, 'Preto'),
    (5, "APX-1236", 1, 1, true, true, true, 0, 'Preto');
