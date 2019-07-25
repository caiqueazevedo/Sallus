CREATE DATABASE eCommerce;
USE eCommerce;

CREATE TABLE clientes(
    id_cliente INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    cpf VARCHAR (14) NOT NULL,
    data_nascimento DATE NOT NULL,
    data_cadastro DATE NOT NULL,
    sexo CHAR,

    PRIMARY KEY (id_cliente)
);

CREATE TABLE email(
    id_email INTEGER NOT NULL,
    email VARCHAR(255) NOT NULL
-- FK id_cliente
);

CREATE TABLE fone(
    id_fone INTEGER NOT NULL,
    numero_fone VARCHAR (10) UNIQUE NOT NULL,
    ddd_fone CHAR(5)
-- FK id_cliente
);

CREATE TABLE endereco(
    id_endereco INTEGER NOT NULL,
-- FK id_cliente
-- FK id_cidade
-- FK id_tipo_cliente
    nome_rua VARCHAR(100) NOT NULL,
    nome_bairro VARCHAR(100) NOT NULL,
    complemento VARCHAR(100)
);

CREATE TABLE tipo_endereco(

    id_tipo_endereco INTEGER NOT NULL,
    nome_tipo_endereco VARCHAR(30) NOT NULL
);

CREATE TABLE cidade(
    id_cidade INTEGER NOT NULL,
-- FK sigla_estado
    nome_cidade VARCHAR(70) NOT NULL
);

CREATE TABLE estado(
    sigla_estado CHAR(2) NOT NULL,
    nome_estado VARCHAR(30) NOT NULL
);


CREATE TABLE pedido(
    id_pedido INTEGER NOT NULL,
-- fk id_cliente
-- fk id_status
    data_pedido DATE NOT NULL,
    valor_pedido DECIMAL NOT NULL

);

CREATE TABLE status_pedido(
    id_status INTEGER NOT NULL,
    status VARCHAR(30) NOT NULL

);

CREATE TABLE itens(
-- FK id_pedido
-- FK id_produto
    quantidade_produto BIGINT NOT NULL
);

CREATE TABLE produto(
    id_produto INTEGER NOT NULL AUTO_INCREMENT,
-- FK id_tipo_produto
    nome_produto VARCHAR(100) NOT NULL,
    valor_unidade DECIMAL NOT NULL,
    descricao text,
    PRIMARY KEY (id_produto)
);

CREATE TABLE tipo_produto(
    id_tipo_produto INTEGER NOT NULL,
    nome_tipo_produto VARCHAR(100) NOT NULL
);

DROP TABLE produto;
DROP DATABASE eCommerce;


SELECT * FROM produto;
SELECT * FROM clientes;

SHOW tables;

ALTER TABLE clientes DROP id_cliente;
ALTER TABLE clientes ADD id_cliente INTEGER NOT NULL AUTO_INCREMENT;

select * from produto;
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Vassoura',2.50,'Usada para limpar');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Caneta',1.50,'Usada para escrever e desenhar');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Ventilador',95.00,'Usado para ventilar ambientes quentes');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Atadura elástica',54.99,'Indicada para proteção da musculatura, curativos compressivos...');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Fones de ouvido',40.00,'Ouvir músicas maneiras');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Mouse',30.99,'Usado para navegar no computador');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Teclado',40.50,'Usado para digitar textos no computador');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('HD',350.00,'Usado para armazenar dados no computador');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Tênys-pé',10.00,'Evitar o chulé');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Pendrive',20.00,'Armazenador portátil de arquivos');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Canetão',9.40,'Escrever no quadro branco');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Carteira',40.00,'Guardar dinheiro e documentos');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Caderno',25.00,'Anotar e escrever');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Garrafa térmica',82.99,'Manter temperatura do líquido por mais tempo');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Computador',2700.00,'Trabalhar e jogar league of legends');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Intellij',5000.00,'Codar em JAVA');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('PyCharm',5000.00,'Codar em Python');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Sublime',00.00,'Trabalhar com HTML');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Workbanch',00.00,'Criar banco de dados');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Próteses',200.00,'Substituir partes do corpo que foram perdidas');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Chinelo',20.00,'Pra não tomar banho descalço');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Sapato',200.00,'Pra não andar descalço');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Bermuda',60.00,'Usar na praia');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Regata',20.00,'Não use regata!!');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('XAMPP',00.00,'Conectar o DB');
INSERT INTO produto (nome_produto,valor_unidade,descricao) VALUES ('Postman',00.00,'Faz alguma coisa...');
