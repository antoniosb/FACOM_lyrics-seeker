CREATE TABLE login(
	usuario CHAR(20),
	senha CHAR(20)	
);

CREATE TABLE genero (
	id_genero INTEGER PRIMARY KEY AUTOINCREMENT,
	nome_genero CHAR(20) NOT NULL,
	descricao CHAR(60)
);

CREATE TABLE artista (
	id_artista INTEGER PRIMARY KEY AUTOINCREMENT,
	nome_artista CHAR(20),
	data_nascimento TEXT,
	id_genero INTEGER,
	url_foto CHAR(200),
	biografia CHAR(512),
	FOREIGN KEY (id_genero) REFERENCES genero(id_genero)
);


CREATE TABLE musica (	
	id_musica INTEGER PRIMARY KEY AUTOINCREMENT,
	nome_musica CHAR(60),
	id_artista INTEGER,
	id_genero INTEGER,
	url_video CHAR(100),	
	data_criacao TEXT,
	letra CHAR(1000),
	FOREIGN KEY (id_artista) REFERENCES artista(id_artista),
	FOREIGN KEY (id_genero) REFERENCES genero(id_genero)
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


