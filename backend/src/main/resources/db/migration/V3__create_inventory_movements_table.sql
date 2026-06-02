CREATE TABLE inventory_movements (
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT NOT NULL,
    quantity INTEGER NOT NULL,
    movement_type VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_inventory_movements_product
        FOREIGN KEY (product_id)
        REFERENCES products(id)
);