CREATE TABLE login(
	usuario CHAR(20),
	senha CHAR(20)	
);

CREATE TABLE musico (
	id_musico CHAR(20) PRIMARY KEY NOT NULL,
	nome_musico CHAR(20),
	data_nascimento CHAR(60),
	nome_genero CHAR(20),
	fotos CHAR(200),
	biografia CHAR(512),
	FOREIGN KEY (nome_genero) REFERENCES genero(nome_genero)
);

CREATE TABLE letra (	
	id_letra CHAR(20) PRIMARY KEY NOT NULL,
	nome_letra CHAR(20),
	id_musico CHAR(20),
	nome_genero CHAR(20),
	url_video CHAR(50),	
	data_criacao DATE,
	texto CHAR(1000),
	FOREIGN KEY (id_musico) REFERENCES musico(id_musico),
	FOREIGN KEY (nome_genero) REFERENCES genero(nome_genero)
);

CREATE TABLE genero (
	nome_genero CHAR(20) PRIMARY KEY NOT NULL,
	descricao CHAR(60)
);

CREATE TABLE acesso_cantor (
	id_musico CHAR(20),
	numero_visitas INT,
	ultima_visita DATE,
	FOREIGN KEY (id_musico) REFERENCES letra(id_musico)
);

CREATE TABLE acesso_letra (
	id_letra CHAR(20),
	numero_visitas INT,
	ultima_visita DATE,
	FOREIGN KEY (id_letra) REFERENCES letra(id_letra)
);

CREATE TABLE musico_genero(
	id_musico CHAR(20),
	nome_genero CHAR(20),
	PRIMARY KEY (id_musico, nome_genero),
	FOREIGN KEY (id_musico) REFERENCES musico(id_musico),
	FOREIGN KEY (nome_genero) REFERENCES genero(nome_genero)
);


