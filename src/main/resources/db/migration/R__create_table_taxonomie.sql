CREATE TABLE IF NOT EXISTS taxonomy
(
    id SERIAL NOT NULL PRIMARY KEY,
    id_product_nature SERIAL NOT NULL,
    id_structuration SERIAL NOT NULL,
    context_trigram VARCHAR(3),
    mandatory BOOLEAN NOT NULL,
    recommended BOOLEAN NOT NULL
);