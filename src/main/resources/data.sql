DROP TABLE IF EXISTS veiculo;

CREATE TABLE veiculo (
    ID IDENTITY NOT NULL PRIMARY KEY ,
    NOME varchar(100),
    MARCA varchar(100),
    MODELO varchar(100),
    DATAFABRICACAO DATE,
    CMKMCIDADE REAL,
    CMKMRODOVIA REAL
);

INSERT INTO veiculo (NOME, MARCA, MODELO, DATAFABRICACAO, CMKMCIDADE, CMKMRODOVIA)
VALUES ('voyageRodi', 'voyage' , 'flat' ,'2021-05-10', 60.0, 80.0 );

INSERT INTO veiculo (NOME, MARCA, MODELO, DATAFABRICACAO, CMKMCIDADE, CMKMRODOVIA)
VALUES ('FerrariAntonio', 'ferrari' , 'corrida' ,'2018-10-13', 40.0, 60.0 );

INSERT INTO veiculo (NOME, MARCA, MODELO, DATAFABRICACAO, CMKMCIDADE, CMKMRODOVIA)
VALUES ('mercedesApoio', 'mercedes' , 'ret' ,'2015-10-13', 20.0, 55.0 );