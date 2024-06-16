CREATE TABLE insumers (
    id SERIAL PRIMARY KEY ,
    preco DOUBLE PRECISION not null,
    nome VARCHAR(255) NOT NULL,
    medida VARCHAR(5) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    quantidade INTEGER NOT NULL

);