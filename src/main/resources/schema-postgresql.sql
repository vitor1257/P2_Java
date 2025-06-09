
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS filmes (
    id SERIAL PRIMARY KEY,
    nomefilme VARCHAR(30),
    genero VARCHAR(50),
    dt_lancamento DATE,
    descfilme VARCHAR(255)

);

CREATE TABLE IF NOT EXISTS jogos (
    id SERIAL PRIMARY KEY,
    nomejogo VARCHAR(30),
    genero VARCHAR(50),
    dt_lancamento DATE,
    descjogo VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS favoritos (
    id SERIAL PRIMARY KEY,
    item_id INT NOT NULL,
    tipo VARCHAR(10) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    genero VARCHAR(255),
    dt_lancamento DATE,
    descricao TEXT
);
