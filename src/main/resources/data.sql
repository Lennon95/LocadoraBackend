
insert into marca (id, nome) values 
    (1, 'GM'),
    (2, 'Toyota'),
    (3, 'Ford'),
    (4, 'Nissan'),
    (5, 'Fiat'),
    (6, 'Jeep');

insert into modelo (id, nome, idmarca, valor) values 
    (1, 'Cruze',1, 100.0),
    (2, 'Ethios',2, 80.0),
    (7, 'Corolla',2, 120.0),
    (3, 'F-1000',3, 70.0),
    (4, 'Sientra',4, 80.0),
    (5, 'Palio',5 , 40.0),
    (6, 'Compass',6, 200.0);

insert into carro (id, placa, idmarca,  idmodelo, direcao, arcondicionado, cambioautomatico, km, cor) values 
    (1, 'APX-1232',  1, 1,   1, 1, 1,  0, 'Preto'),
    (2, 'APX-1233',  1, 1,   1, 1, 1,  0, 'Preto'),
    (3, 'APX-1234',  1, 1,   1, 1, 1,  0, 'Preto'),
    (4, 'APX-1235',  1, 1,   1, 1, 1,  0, 'Preto'),
    (5, 'APX-1236',  1, 1,   1, 1, 1,  0, 'Preto'),

    (6, 'APX-2020',  2, 2,   1, 1, 1,  0, 'Branco'),
    (7, 'APX-2021',  2, 2,   1, 1, 1,  0, 'Branco'),
    (8, 'APX-2022',  2, 7,   1, 1, 1,  0, 'Prata'),
    (9, 'APX-2023',  2, 7,   1, 1, 1,  0, 'Prata');
