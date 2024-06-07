CREATE TABLE insumers (
    id SERIAL PRIMARY KEY ,
    preco DOUBLE PRECISION not null,
    nome TEXT NOT NULL,
    medida TEXT NOT NULL,
    categoria TEXT NOT NULL,
    quantidade INTEGER NOT NULL

);