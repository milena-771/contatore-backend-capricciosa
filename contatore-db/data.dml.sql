DELETE FROM sizes;
DELETE FROM shapes;
DELETE FROM bases;
DELETE FROM ingredients;

INSERT INTO sizes
    (size_name)
    VALUES
    ('Petite'), ('Moyenne'), ('Grande');

INSERT INTO shapes
    (shape_name)
    VALUES
    ('Classique (plate)'), ('Calzone (chausson)');


INSERT INTO bases
    (base_name)
    VALUES
    ('Blanche'), ('Sauce tomate'), ('Crème fraîche'), ('Mixte');

INSERT INTO ingredients
    (ingredient_name)
    VALUES
    ('Tomate fraîche'), ('Tomate confite'), ('Tomate séchée'), ('Asperge'),
    ('Jambon blanc'), ('Poulet'), ('Jambon cru'), ('Aubergine grillée'), ('Copeaux de parmesan'),
    ('Mozzarella'), ('Boeuf épicé'), ('Olive verte'), ('Olive noire'), ('Champignon de paris'),
    ('Gorgonzola'), ('Oignon cru'), ('Oignon confit'), ('Poivron vert cru'), ('Poivron rouge cru'),
    ('Poivron vert confit'), ('Poivron rouge confit'), ('Artichaut');
    
  