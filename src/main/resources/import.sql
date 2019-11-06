DROP DATABASE triband;
CREATE DATABASE triband;
USE triband;

CREATE FUNCTION haversine(lat1 NUMERIC(10,6),long1 NUMERIC(10,6), lat2 NUMERIC(10,6), long2 NUMERIC(10,6))
RETURNS DOUBLE
RETURN POW(0.5*(RADIANS(lat2-lat1)), 2) + COS(RADIANS(lat1))*COS(RADIANS(lat2))*POW(0.5*(RADIANS(long2-long1)),2);


CREATE FUNCTION distancia(lat1 NUMERIC(10,6),long1 NUMERIC(10,6), lat2 NUMERIC(10,6), long2 NUMERIC(10,6))
RETURNS DOUBLE
RETURN 12742 * ATAN2(SQRT(haversine(lat1, long1, lat2, long2)), SQRT(1-haversine(lat1, long1, lat2, long2))) ;

CREATE TABLE foto(

	id_foto BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    id_banda BIGINT,
    id_estudio BIGINT,
    path VARCHAR(300),
    
    PRIMARY KEY(id_foto)
);

CREATE TABLE banda(

    id_banda BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    email VARCHAR(50) UNIQUE ,
    id_foto BIGINT,
    integrantes INT,
    nome VARCHAR(50),
    senha VARCHAR(20),
    telefone VARCHAR(20),
    
    PRIMARY KEY(id_banda),
    FOREIGN KEY(id_foto) REFERENCES foto(id_foto) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE avaliacao_banda(

    id_avaliacao_banda BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    id_banda BIGINT NOT NULL,
    compromisso_horario INT,
    cuidado_equipamento INT,
    data_avaliacao_banda DATE,
    
    
    PRIMARY KEY(id_avaliacao_banda),
    FOREIGN KEY(id_banda) REFERENCES banda(id_banda) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE localizacao(

    id_localizacao BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
	bairro varchar(20),
    cep BIGINT(8),
    cidade varchar(35),
    estado varchar(20),
    numero INT,
    rua VARCHAR(30),
    latitude DOUBLE,
    longitude DOUBLE,
    
	PRIMARY KEY(id_localizacao)
);


CREATE TABLE estudio(

    id_estudio BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
	cnpj VARCHAR(20),
    email VARCHAR(50),
    id_foto BIGINT NOT NULL,
    id_localizacao BIGINT NOT NULL,
    nome VARCHAR(30),
    senha VARCHAR(15),
	preco DOUBLE NOT NULL,
    descricao VARCHAR(1000),
	telefone VARCHAR(20),
    
    PRIMARY KEY(id_estudio),
    FOREIGN KEY(id_foto) REFERENCES foto(id_foto) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_localizacao) REFERENCES localizacao(id_localizacao) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE avaliacao_estudio(

    id_avaliacao_estudio BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
	id_estudio BIGINT NOT NULL,
    atendimento INT,
    compromisso_horario INT,
    limpeza INT,
    qualidade_equipamento INT,
    data_avaliacao_estudio DATE,
    
    PRIMARY KEY(id_avaliacao_estudio),
    FOREIGN KEY(id_estudio) REFERENCES estudio(id_estudio) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE servico(

	id_servico BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    descricao VARCHAR(1000),
    id_estudio BIGINT NOT NULL,
    
    PRIMARY KEY(id_servico),
    FOREIGN KEY(id_estudio) REFERENCES estudio(id_estudio) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE subservico(

    id_subservico BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    descricao VARCHAR(1000),
    id_servico BIGINT NOT NULL,
	
    PRIMARY KEY(id_subservico),
    FOREIGN KEY(id_servico) REFERENCES servico(id_servico) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE reserva(

    id_reserva BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    id_banda BIGINT NOT NULL,
    id_estudio BIGINT NOT NULL,
	data_reserva DATE,
    horario_inicio TIME,
    horario_final TIME,
    total_a_pagar DOUBLE NOT NULL,
    
    PRIMARY KEY(id_reserva),
    FOREIGN KEY(id_banda) REFERENCES banda(id_banda) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_estudio) REFERENCES estudio(id_estudio) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE chat(
    id_banda BIGINT NOT NULL,
    id_estudio BIGINT NOT NULL,
    id_chat BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    
    PRIMARY KEY(id_chat),
    FOREIGN KEY(id_banda) REFERENCES banda(id_banda) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_estudio) REFERENCES estudio(id_estudio) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE mensagem(
    id_mensagem BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    id_chat BIGINT NOT NULL,    
	horario TIME,
	conteudo VARCHAR(500),
    
    PRIMARY KEY(id_mensagem),
    FOREIGN KEY(id_chat) REFERENCES chat(id_chat) ON DELETE CASCADE ON UPDATE CASCADE
);



-- Chave estrangeira para tabela fotos

ALTER TABLE foto ADD FOREIGN KEY(id_banda) REFERENCES banda(id_banda) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE foto ADD FOREIGN KEY(id_estudio) REFERENCES estudio(id_estudio) ON UPDATE CASCADE ON DELETE CASCADE;




INSERT INTO localizacao VALUES
(1,'a',1,'a','a',1,'a', -28.449750, -52.199235),
(2,'b',2,'b','b',2,'b', -28.450894, -52.199193),
(3,'c',3,'c','c',3,'c', -28.451004, -52.199391),
(4,'d',4,'d','d',4,'d', -28.449365, -52.199478),
(5,'e',5,'e','e',5,'e', -28.452599, -52.199242),
(6,'f',6,'f','f',6,'f', -28.452159, -52.199144),
(7,'g',7,'g','g',7,'g', -28.452159, -52.199144);

INSERT INTO foto VALUES 
(1,null,null,'/foto1.jpg'),
(2,null,null,'/foto2.jpg'),
(3,null,null,'/foto3.jpg'),
(4,null,null,'/foto4.jpg'),
(5,null,null,'/foto5.jpg'),
(6,null,null,'/foto6.jpg'),
(7,null,null,'/foto7.jpg'),

(8,null,null,'/foto8.jpg'),
(9,null,null,'/foto9.jpg'),
(10,null,null,'/foto10.jpg'),
(11,null,null,'/foto11.jpg'),
(12,null,null,'/foto12.jpg'),
(13,null,null,'/foto13.jpg'),
(14,null,null,'/foto14.jpg')
;

INSERT INTO banda VALUES 
(1,'a@g.com',1,4,'a','123','(51)994225198'),
(2,'b@g.com',2,4,'b','123','(51)994225198'),
(3,'c@g.com',3,4,'c','123','(51)994225198'),
(4,'d@g.com',4,4,'d','123','(51)994225198'),
(5,'e@g.com',5,4,'e','123','(51)994225198'),
(6,'f@g.com',6,4,'f','123','(51)994225198'),
(7,'g@g.com',7,4,'g','123','(51)994225198');

INSERT INTO avaliacao_banda VALUES
(1,1,4,4,date('2003-12-31 14:00:00')),
(2,2,5,5,date('2003-12-31 15:30:00')),
(3,3,5,5,date('2003-12-31 14:00:00')),
(4,4,1,1,date('2003-12-31 12:00:00')),
(5,5,3,5,date('2003-12-31 15:30:00')),
(6,6,5,1,date('2003-12-31 16:00:00')),
(7,7,2,2,date('2003-12-31 17:30:00'));

INSERT INTO estudio VALUES 
(1,1,'ea@g.com',7,1,'meia-boca','123',20.00,'a','(51)994225198'),
(2,2,'eb@g.com',8,2,'do Paulo','123',18.11,'a','(51)994225198'),
(3,3,'ec@g.com',9,3,'c','123',12,'a','(51)994225198'),
(4,4,'ed@g.com',10,4,'d','123',123,'a','(51)994225198'),
(5,5,'ee@g.com',11,5,'e','123',2.1,'a','(51)994225198'),
(6,6,'ef@g.com',12,6,'f','123',12.3,'a','(51)994225198'),
(7,7,'eg@g.com',13,7,'g','123',39.9,'a','(51)994225198');

INSERT INTO reserva VALUES 
(1,1,1, DATE('2003-12-31'),TIME('13:00:00'),TIME('14:00:00'),12341.22),
(2,2,1, DATE('2003-12-31'),TIME('14:30:00'),TIME('15:30:00'),10.31),
(3,3,3,date('2003-12-31'),time('13:00:00'),time('14:00:00'),123),
(4,4,1,date('2003-12-31'),time('11:00:00'),time('12:00:00'),32.3),
(5,5,5,date('2003-12-31'),time('13:00:00'),time('15:30:00'),29),
(6,6,6,date('2003-12-31'),time('15:10:00'),time('16:00:00'),1),
(7,7,7,date('2003-12-31'),time('13:00:00'),time('17:30:00'),0.6),
(8,7,7, DATE('2003-12-31'),TIME('13:00:00'),TIME('14:00:00'),12),
(9,6,6, DATE('2003-12-31'),TIME('14:30:00'),TIME('15:30:00'),20.2),
(10,5,5,date('2003-12-31'),time('13:00:00'),time('14:00:00'),123.1),
(11,4,4,date('2003-12-31'),time('11:00:00'),time('12:00:00'),32.3),
(12,3,3,date('2003-12-31'),time('13:00:00'),time('15:30:00'),29),
(13,2,2,date('2003-12-31'),time('13:00:00'),time('16:00:00'),1),
(14,1,1,date('2003-12-31'),time('13:00:00'),time('17:30:00'),0.6);

INSERT INTO avaliacao_estudio VALUES
(1,1,5,5,5,5,date('2003-12-31 14:00:00')),
(2,2,5,5,5,5,date('2003-12-31 15:30:00')),
(3,3,5,5,5,5,date('2003-12-31 14:00:00')),
(4,4,5,5,5,5,date('2003-12-31 12:00:00')),
(5,5,5,5,5,5,date('2003-12-31 15:30:00')),
(6,6,5,5,5,5,date('2003-12-31 16:00:00')),
(7,7,5,5,5,5,date('2003-12-31 17:30:00'));

INSERT INTO chat VALUES 
(1,1,1),
(2,2,2),
(3,3,3),
(4,4,4),
(5,5,5),
(6,6,6),
(7,7,7);

INSERT INTO mensagem VALUES
(1,1,TIME('2003-12-10 13:22:00'),'A'),
(2,2,TIME('2003-12-10 13:22:01'),'B'),
(3,3,TIME('2003-12-10 13:22:02'),'C'),
(4,4,TIME('2003-12-10 13:22:03'),'D'),
(5,5,TIME('2003-12-10 13:22:04'),'E'),
(6,6,TIME('2003-12-10 13:22:05'),'F'),
(7,7,TIME('2003-12-10 13:22:06'),'G');


INSERT INTO servico VALUES 
(1,'A',1),
(2,'B',1),
(3,'C',2),
(4,'D',3),
(5,'E',2),
(6,'F',4),
(7,'G',5),
(8,'KK',6),
(9,'FDSKO',7);


INSERT INTO subservico VALUES
(1,'ABCD',     1),
(2,'ABdsfCD',  2),
(3,'ABCDedd',  3),
(4,'ABasdfCD', 4),
(5,'ABCssssD', 5),
(6,'ABCDd',    6),
(7,'ABdasCD', 7);


