CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    preco_custo DOUBLE PRECISION not null,
    preco_venda DOUBLE PRECISION not null,
    medida TEXT NOT NULL,
    categoria TEXT NOT NULL
);