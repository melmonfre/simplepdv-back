CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    precoCusto DOUBLE PRECISION not null,
    precoVenda DOUBLE PRECISION not null,
    medida TEXT NOT NULL,
    categoria TEXT NOT NULL
);