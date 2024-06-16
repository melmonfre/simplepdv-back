CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco_custo DOUBLE PRECISION not null,
    preco_venda DOUBLE PRECISION not null,
    medida VARCHAR(5) NOT NULL,
    categoria VARCHAR(50) NOT NULL
);