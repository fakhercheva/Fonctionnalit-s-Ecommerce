DROP TABLE IF EXISTS produit;
DROP TABLE IF EXISTS categorie;

CREATE TABLE categorie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    parent_id BIGINT,
    CONSTRAINT fk_categorie_parent FOREIGN KEY (parent_id) REFERENCES categorie(id)
);

CREATE TABLE produit (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prix DOUBLE NOT NULL,
    quantite_stock INT NOT NULL,
    categorie_id BIGINT,
    CONSTRAINT fk_produit_categorie FOREIGN KEY (categorie_id) REFERENCES categorie(id)
);

INSERT INTO categorie (nom, description, parent_id) VALUES ('Électronique', 'Produits électroniques', NULL);
INSERT INTO categorie (nom, description, parent_id) VALUES ('Téléphones', 'Smartphones et accessoires', 1);
INSERT INTO categorie (nom, description, parent_id) VALUES ('Informatique', 'Ordinateurs et périphériques', 1);
INSERT INTO categorie (nom, description, parent_id) VALUES ('Maison', 'Articles pour la maison', NULL);
INSERT INTO categorie (nom, description, parent_id) VALUES ('Cuisine', 'Appareils de cuisine', 4);

INSERT INTO produit (nom, prix, quantite_stock, categorie_id) VALUES ('iPhone 15', 1200.00, 10, 2);
INSERT INTO produit (nom, prix, quantite_stock, categorie_id) VALUES ('Samsung Galaxy S24', 1100.00, 15, 2);
INSERT INTO produit (nom, prix, quantite_stock, categorie_id) VALUES ('PC Portable HP', 950.00, 8, 3);
INSERT INTO produit (nom, prix, quantite_stock, categorie_id) VALUES ('TV', 80.00, 20, 5);

