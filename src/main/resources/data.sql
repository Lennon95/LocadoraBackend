
insert into marca (id, nome) values 
    (1, 'GM'),
    (2, 'Toyota'),
    (3, 'Ford'),
    (4, 'Nissan'),
    (5, 'Fiat'),
    (6, 'Jeep');

insert into modelo (id, nome, idmarca, valor) values 
    (1, 'Cruze',1, 100.0),
    (8, 'Onix', 1, 60.0),
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
    (9, 'APX-2023',  2, 7,   1, 1, 1,  0, 'Prata'),

    (10, 'APX-2026',  1, 8,   1, 1, 0,  0, 'Branco'),
    (11, 'APX-2027',  1, 8,   1, 1, 0,  0, 'Branco'),
    (12, 'APX-2028',  5, 5,   1, 1, 0,  0, 'Prata'),
    (13, 'APX-2029',  5, 5,   1, 1, 0,  0, 'Prata');

insert into cliente (id, documento, nome, endereco, locacoesfeitas, estcivil, datanascimento) 
    values 
        (1, '20202020', 'João Silva', 'Porto Alegre - RS', 4, 1, '1980-12-12'),
        (2, '30303030', 'Maria Joana', 'Kingston - JM', 4, 1, '1968-10-08'),
        (3, '40404040', 'Jack Nickolson', 'Los Angeles - CA', 4, 1, '1950-02-02');
