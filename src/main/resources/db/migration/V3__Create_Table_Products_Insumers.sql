CREATE TABLE products_insumers (
    product_id INTEGER NOT NULL,
    insumer_id INTEGER NOT NULL,
    Primary Key (product_id, insumer_id),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (insumer_id) REFERENCES insumers(id)
);