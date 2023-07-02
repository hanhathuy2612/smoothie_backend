-- liquibase formatted sql

-- changeset withu:1687585100504-1
CREATE TABLE ingredient
(
    id                      BIGINT AUTO_INCREMENT NOT NULL,
    color_code              VARCHAR(255)          NULL,
    ingredient_type         VARCHAR(255)          NULL,
    quantity                DOUBLE PRECISION      NOT NULL,
    quantity_per_milliliter DOUBLE PRECISION      NOT NULL,
    unit_type               VARCHAR(255)          NULL,
    CONSTRAINT ingredientPK PRIMARY KEY (id)
);

-- changeset withu:1687585100504-2
ALTER TABLE ingredient
    ADD CONSTRAINT UC_INGREDIENTINGREDIENT_TYPE_COL UNIQUE (ingredient_type);

