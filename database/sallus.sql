-- CRIANDO AS TABELAS
DROP DATABASE IF EXISTS projeto_ecommerce;

CREATE DATABASE projeto_ecommerce;

USE projeto_ecommerce;

CREATE TABLE cliente(
	id_cliente			INTEGER						NOT NULL,
	nome				VARCHAR(100)				NOT NULL,
    cpf					VARCHAR(14)		UNIQUE		NOT NULL,
	data_nascimento		DATE 						NOT NULL,
	data_cadastro		DATE 						NOT NULL,
	SEXO				CHAR(1)			
);

CREATE TABLE cadastro(
    id_cliente			INTEGER		 				NOT NULL,
    login				VARCHAR(20)		UNIQUE		NOT NULL,
    email				VARCHAR(255)	UNIQUE		NOT NULL,
    senha 				VARCHAR(20)					NOT NULL
);

CREATE TABLE fone(
	id_fone				INTEGER						NOT NULL,
    id_cliente			INTEGER						NOT NULL,
    numero_fone			VARCHAR(10)		UNIQUE		NOT NULL,
    ddd_fone			CHAR(5)						NOT NULL	
);

CREATE TABLE endereco(
	id_endereco			INTEGER						NOT NULL,
    id_cliente			INTEGER						NOT NULL,
    id_cidade			INTEGER						NOT NULL,
	id_tipo				INTEGER						NOT NULL,
    nome_rua			VARCHAR(100)				NOT NULL,
    nome_bairro			VARCHAR(100)				NOT NULL,
    complemento			VARCHAR(100)
);
    
CREATE TABLE tipo_endereco(
	id_tipo				INTEGER						NOT NULL,
	nome_tipo			VARCHAR(30)					NOT NULL        
);
    
CREATE TABLE cidade(
	id_cidade			INTEGER						NOT NULL,
	sigla_estado		CHAR(2)						NOT NULL,
	nome_cidade			VARCHAR(70)					NOT NULL
);
    
CREATE TABLE estado(
	sigla_estado		CHAR(2)						NOT NULL,
	nome_estado			VARCHAR(30)					NOT NULL
);

CREATE TABLE pedido(
	id_pedido			INTEGER						NOT NULL,
    id_cliente			INTEGER						NOT NULL,
    id_status			INTEGER						NOT NULL,
    data_pedido			DATE						NOT NULL,
    valor_pedido		DECIMAL						NOT NULL
    
);

CREATE TABLE status_pedido(
	id_status			INTEGER						NOT NULL,
    status_nome				VARCHAR(30)					NOT NULL
);

CREATE TABLE itens(
	id_pedido			INTEGER						NOT NULL,
    id_produto			INTEGER						NOT NULL,
	quantidade_produto	INTEGER						NOT NULL,
    preco_itens			DECIMAL						NOT NULL
);

CREATE TABLE produto(
	id_produto			INTEGER						NOT NULL,
    id_categoria		INTEGER						NOT NULL,
    nome_produto		VARCHAR(100)				NOT NULL,
    valor_unidade		DECIMAL						NOT NULL
);

CREATE TABLE categoria_produto(
	id_categoria		INTEGER						NOT NULL,
	nome_categoria		VARCHAR(100)				NOT NULL
);

CREATE TABLE anuncio(
	id_anuncio				INTEGER					NOT NULL,
	id_cliente				INTEGER					NOT NULL,
    id_produto				INTEGER					NOT NULL,
    data_anuncio			TIMESTAMP				NOT NULL,
    titulo					TEXT					NOT NULL,
    descricao				TEXT					NOT NULL
);
-- CRIANDO AS PRIMARY KEYS

ALTER TABLE cliente
ADD CONSTRAINT PK_CLIENTE
PRIMARY KEY (id_cliente);

ALTER TABLE cadastro
ADD CONSTRAINT PK_CADASTRO
PRIMARY KEY (email);

ALTER TABLE fone
ADD CONSTRAINT PK_FONE
PRIMARY KEY (id_fone);

ALTER TABLE endereco
ADD CONSTRAINT PK_ENDERECO
PRIMARY KEY (id_endereco);

ALTER TABLE tipo_endereco
ADD CONSTRAINT PK_TIPO_ENDERECO
PRIMARY KEY (id_tipo);

ALTER TABLE cidade
ADD CONSTRAINT PK_CIDADE
PRIMARY KEY (id_cidade);

ALTER TABLE estado
ADD CONSTRAINT PK_ESTADO
PRIMARY KEY (sigla_estado);

ALTER TABLE pedido
ADD CONSTRAINT PK_PEDIDO
PRIMARY KEY (id_pedido);

 ALTER TABLE status_pedido
ADD CONSTRAINT PK_STATUS_PEDIDO
PRIMARY KEY (id_status);

ALTER TABLE itens
ADD CONSTRAINT PK_ITENS
PRIMARY KEY (id_pedido, id_produto);

ALTER TABLE produto
ADD CONSTRAINT PK_PRODUTO
PRIMARY KEY (id_produto);

ALTER TABLE categoria_produto
ADD CONSTRAINT PK_CATEGORIA_PRODUTO
PRIMARY KEY (id_categoria);

ALTER TABLE anuncio
ADD CONSTRAINT	PK_ANUNCIO
PRIMARY KEY (id_anuncio);

-- CRIANDO FOREIGN KEYS

ALTER TABLE cadastro
ADD CONSTRAINT FK_CADASTRO
FOREIGN KEY (id_cliente)
REFERENCES cliente (id_cliente);

ALTER TABLE fone
ADD CONSTRAINT FK_FONE
FOREIGN KEY (id_cliente)
REFERENCES cliente (id_cliente);

ALTER TABLE endereco
ADD CONSTRAINT FK_ENDERECO
FOREIGN KEY (id_cliente)
REFERENCES cliente (id_cliente);

ALTER TABLE endereco
ADD CONSTRAINT FK_ENDERECO_CIDADE
FOREIGN KEY (id_cidade)
REFERENCES cidade (id_cidade);

ALTER TABLE cidade
ADD CONSTRAINT FK_CIDADE
FOREIGN KEY (sigla_estado)
REFERENCES estado (sigla_estado);

ALTER TABLE endereco
ADD CONSTRAINT FK_ENDERECO_TIPO
FOREIGN KEY (id_tipo)
REFERENCES tipo_endereco (id_tipo);

ALTER TABLE pedido
ADD CONSTRAINT FK_PEDIDO_STATUS
FOREIGN KEY (id_status)
REFERENCES status_pedido (id_status);

ALTER TABLE pedido
ADD CONSTRAINT FK_PEDIDO_CLIENTE
FOREIGN KEY (id_cliente)
REFERENCES cliente (id_cliente);

ALTER TABLE itens
ADD CONSTRAINT FK_ITENS_PEDIDO
FOREIGN KEY (id_pedido)
REFERENCES pedido (id_pedido);

ALTER TABLE itens
ADD CONSTRAINT FK_ITENS_PRODUTO
FOREIGN KEY (id_produto)
REFERENCES produto (id_produto);

ALTER TABLE produto
ADD CONSTRAINT FK_PRODUTO
FOREIGN KEY (id_categoria)
REFERENCES categoria_produto (id_categoria);

ALTER TABLE anuncio
ADD CONSTRAINT FK_ANUNCIO_PRODUTO
FOREIGN KEY (id_produto)
REFERENCES produto (id_produto);

ALTER TABLE anuncio
ADD CONSTRAINT FK_ANUNCIO_CLIENTE
FOREIGN KEY (id_cliente)
REFERENCES cliente (id_cliente);

-- INSERÇÃO DE DADOS

INSERT INTO estado
	(sigla_estado, nome_estado)
VALUES 
	('AC', 'Acre'),
    ('AL', 'Alagoas'),
    ('AP', 'Amapá'),
    ('AM', 'Amazonas'),
    ('BA', 'Bahia'),
    ('CE', 'Ceará'),
    ('DF', 'Distrito Federal'),
    ('ES', 'Vitória'),
    ('GO', 'Goiás'),
    ('MA', 'Maranhão'),
    ('MT', 'Mato Grosso'),
    ('MS', 'Mato Grosso'),
    ('MG', 'Minas Gerais'),
    ('PA', 'Pará'),
    ('PB', 'Paraíba'),
	('PR', 'Paraná'),
    ('PE', 'Pernambuco'),
    ('PI', 'Piauí'),
    ('RJ', 'Rio de Janeiro'),
    ('RN', 'Rio Grande do Norte'),
    ('RS', 'Rio Grande do SUl'),
    ('RO', 'Rondônia'),
    ('RR', 'Roraima'),
    ('SC', 'Santa Catarina'),
    ('SE', 'Sergipe'),
    ('SP', 'São Paulo'),
    ('TO','Tocantins');
    
    

    
SELECT * FROM estado;






















