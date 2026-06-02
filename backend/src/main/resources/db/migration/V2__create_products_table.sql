CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    unit VARCHAR(30) NOT NULL,
    quantity INTEGER NOT NULL,
    minimum_quantity INTEGER NOT NULL
);