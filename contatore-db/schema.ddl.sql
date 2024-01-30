DROP TABLE IF EXISTS shapes;
DROP TABLE IF EXISTS sizes;
DROP TABLE IF EXISTS bases;
DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS pizzas;
DROP TABLE IF EXISTS possess;

CREATE TABLE shapes (
    id SERIAL,
    shape_name VARCHAR(50),
    CONSTRAINT pk_shape_id PRIMARY KEY(id)
);

CREATE TABLE sizes (
    id SERIAL,
    size_name VARCHAR(50),
    CONSTRAINT pk_size_id PRIMARY KEY(id)
);

CREATE TABLE bases (
    id SERIAL,
    base_name VARCHAR(50),
    CONSTRAINT pk_base_id PRIMARY KEY(id)
);

CREATE TABLE ingredients (
    id SERIAL,
    ingredient_name VARCHAR(50),
    CONSTRAINT pk_ingredient_id PRIMARY KEY(id)
);

CREATE TABLE pizzas (
    id SERIAL,
    base_id INT,
    size_id INT,
    shape_id INT,
    command_number VARCHAR(100),
    price DOUBLE PRECISION,
    initial VARCHAR(50),
    status VARCHAR(50),
    CONSTRAINT pk_pizza_id PRIMARY KEY(id),
        CONSTRAINT fk_base_id 
        FOREIGN KEY(base_id)
        REFERENCES bases(id),
        CONSTRAINT fk_size_id 
        FOREIGN KEY(size_id)
        REFERENCES sizes(id),
        CONSTRAINT fk_shape_id 
        FOREIGN KEY(shape_id)
        REFERENCES shapes(id)
);

CREATE TABLE possess (
    id SERIAL,
    ingredient_id INT,
    pizza_id INT,
    UNIQUE (ingredient_id, pizza_id),
    CONSTRAINT pk_possess_id PRIMARY KEY(id),
    CONSTRAINT fk_ingredient_id 
        FOREIGN KEY(ingredient_id)
        REFERENCES ingredients(id),
        CONSTRAINT fk_pizza_id 
        FOREIGN KEY(pizza_id)
        REFERENCES pizzas(id)
);
