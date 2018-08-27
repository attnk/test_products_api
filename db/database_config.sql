-- *******************************************
-- DB
-- *******************************************
-- postgree (porta: 5432)
--	user for API: product_app
--	pwd for API: productapp123
-- *******************************************

-- User: postgres
-- DROP USER postgres;

CREATE USER postgres WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  REPLICATION;

-- ///////////////////////////////////////

-- User: product_app
-- DROP USER product_app;
CREATE USER product_app WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION;
GRANT postgres TO product_app;
COMMENT ON ROLE product_app IS 'Product app user';

-- ///////////////////////////////////////

-- Database: product
-- DROP DATABASE product;
CREATE DATABASE product
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
COMMENT ON DATABASE product
    IS 'database for products';
CREATE SCHEMA product
    AUTHORIZATION postgres;
GRANT ALL ON SCHEMA product TO product_app WITH GRANT OPTION;

-- ///////////////////////////////////////

-- Table: product.product
-- DROP TABLE product.product;
CREATE TABLE product.product
(
    id bigint NOT NULL DEFAULT nextval('product.product_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    category text COLLATE pg_catalog."default",
    size text COLLATE pg_catalog."default",
    created_at timestamp without time zone,
    price_from numeric,
    price_to numeric,
    CONSTRAINT id PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE product.product
    OWNER to postgres;
    
-- //////////////////////////////////////

-- Table: product.product_images
-- DROP TABLE product.product_images;
CREATE TABLE product.product_images
(
    id bigint NOT NULL DEFAULT nextval('product.product_images_id_seq'::regclass),
    product_id bigint NOT NULL,
    url text COLLATE pg_catalog."default",
    CONSTRAINT product_images_pkey PRIMARY KEY (id),
    CONSTRAINT fk_product_images FOREIGN KEY (product_id)
        REFERENCES product.product (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE product.product_images
    OWNER to postgres;
COMMENT ON TABLE product.product_images
    IS 'Data from images';

-- //////////////////////////////////////

INSERT INTO product.product(
	name, category, size, created_at, price_from, price_to)
	VALUES ('Toalha de banho', 'Toalhas', 'adulto', now(), 79.90, 49.90);

-- //////////////////////////////////////

	INSERT INTO product.product_images(
	product_id, url)
	VALUES (1, 'https://thumb10.shutterstock.com/thumb_large/2973451/587783213/stock-photo-sun-lights-to-the-clean-white-towels-on-the-hotel-bed-feels-cozy-comfort-and-relax-for-cozy-587783213.jpg');
	
	INSERT INTO product.product_images(
	product_id, url)
	VALUES (1, 'https://thumb10.shutterstock.com/thumb_large/2429366/590662787/stock-photo-white-towel-on-bed-decoration-in-bedroom-interior-vintage-light-filter-590662787.jpg');
	
	INSERT INTO product.product_images(
	product_id, url)
	VALUES (1, 'https://thumb10.shutterstock.com/thumb_large/2429366/590662787/stock-photo-white-towel-on-bed-decoration-in-bedroom-interior-vintage-light-filter-590662787.jpg');
	
	INSERT INTO product.product_images(
	product_id, url)
	VALUES (1, 'https://thumb10.shutterstock.com/thumb_large/2973451/587783213/stock-photo-sun-lights-to-the-clean-white-towels-on-the-hotel-bed-feels-cozy-comfort-and-relax-for-cozy-587783213.jpg');

-- //////////////////////////////////////
-- toalha de rosto
  INSERT INTO product.product(
  name, category, size, created_at, price_from, price_to)
  VALUES ('Toalha de rosto', 'Toalhas', 'Toalha de rosto', now(), 39.90, 19.90);

  INSERT INTO product.product_images(
  product_id, url)
  VALUES (2, 'https://thumb1.shutterstock.com/thumb_large/661648/143696806/stock-photo-rolled-up-white-beach-towel-on-white-background-143696806.jpg');

  INSERT INTO product.product_images(
  product_id, url)
  VALUES (2, 'https://thumb1.shutterstock.com/thumb_large/4254733/708934429/stock-photo-pink-face-towel-in-a-roll-on-an-isolated-white-background-708934429.jpg');

  INSERT INTO product.product_images(
  product_id, url)
  VALUES (2, 'https://thumb1.shutterstock.com/thumb_large/661648/143696806/stock-photo-rolled-up-white-beach-towel-on-white-background-143696806.jpg');

  INSERT INTO product.product_images(
  product_id, url)
  VALUES (2, 'https://thumb1.shutterstock.com/thumb_large/4254733/708934429/stock-photo-pink-face-towel-in-a-roll-on-an-isolated-white-background-708934429.jpg');

-- //////////////////////////////////////
-- lençol adulto king
  INSERT INTO product.product(
  name, category, size, created_at, price_from, price_to)
  VALUES ('Lençol Adulto', 'Lençol adulto', 'King size', now(), 59.90, 39.90);

  INSERT INTO product.product_images(
  product_id, url)
  VALUES (3, 'https://thumb1.shutterstock.com/thumb_large/277009/786226663/stock-photo-simple-gray-and-white-bedroom-interior-with-blanket-and-pillows-on-king-size-bed-bright-window-786226663.jpg');

  INSERT INTO product.product_images(
  product_id, url)
  VALUES (3, 'https://thumb1.shutterstock.com/thumb_large/277009/782654206/stock-photo-grey-and-yellow-room-with-king-size-bed-poster-and-lamp-standing-on-bedside-table-782654206.jpg');

  INSERT INTO product.product_images(
  product_id, url)
  VALUES (3, 'https://thumb1.shutterstock.com/thumb_large/277009/786226663/stock-photo-simple-gray-and-white-bedroom-interior-with-blanket-and-pillows-on-king-size-bed-bright-window-786226663.jpg');

  INSERT INTO product.product_images(
  product_id, url)
  VALUES (3, 'https://thumb1.shutterstock.com/thumb_large/277009/782654206/stock-photo-grey-and-yellow-room-with-king-size-bed-poster-and-lamp-standing-on-bedside-table-782654206.jpg');


-- //////////////////////////////////////
-- toalha de mão
INSERT INTO product.product(
  name, category, size, created_at, price_from, price_to)
  VALUES ('Toalha de mão', 'Toalhas', 'Toalhas de mão', now(), 49.90, 29.90);

INSERT INTO product.product_images(
  product_id, url)
  VALUES (4, 'https://thumb9.shutterstock.com/thumb_large/3819122/1042317892/stock-photo-the-blue-gray-towel-roll-in-hand-on-white-background-isolation-1042317892.jpg');

INSERT INTO product.product_images(
  product_id, url)
  VALUES (4, 'https://thumb1.shutterstock.com/thumb_large/1528667/144521369/stock-photo-basket-of-pure-white-towels-on-wooden-table-in-japanese-restaurant-144521369.jpg');

INSERT INTO product.product_images(
  product_id, url)
  VALUES (4, 'https://thumb9.shutterstock.com/thumb_large/3819122/1042317892/stock-photo-the-blue-gray-towel-roll-in-hand-on-white-background-isolation-1042317892.jpg');

INSERT INTO product.product_images(
  product_id, url)
  VALUES (4, 'https://thumb1.shutterstock.com/thumb_large/1528667/144521369/stock-photo-basket-of-pure-white-towels-on-wooden-table-in-japanese-restaurant-144521369.jpg');



-- //////////////////////////////////////
-- toalha de mesa

INSERT INTO product.product(
  name, category, size, created_at, price_from, price_to)
  VALUES ('Toalha de mesa', 'Cozinha', 'Mesa', now(), 29.90, 19.90);

INSERT INTO product.product_images(
  product_id, url)
  VALUES (5, 'https://thumb10.shutterstock.com/thumb_large/2061695/355891343/stock-photo-table-cloth-kitchen-red-color-isolated-on-white-355891343.jpg');

INSERT INTO product.product_images(
  product_id, url)
  VALUES (5, 'https://thumb9.shutterstock.com/thumb_large/1427423/537583432/stock-photo-kitchen-background-with-table-cloth-537583432.jpg');

INSERT INTO product.product_images(
  product_id, url)
  VALUES (5, 'https://thumb10.shutterstock.com/thumb_large/2061695/355891343/stock-photo-table-cloth-kitchen-red-color-isolated-on-white-355891343.jpg');

INSERT INTO product.product_images(
  product_id, url)
  VALUES (5, 'https://thumb9.shutterstock.com/thumb_large/1427423/537583432/stock-photo-kitchen-background-with-table-cloth-537583432.jpg');

-- //////////////////////////////////////
-- travesseiro
INSERT INTO product.product(
  name, category, size, created_at, price_from, price_to)
  VALUES ('Travesseiro', 'Travesseiros', 'Adulto', now(), 29.90, 19.90);

INSERT INTO product.product_images(
  product_id, url)
  VALUES (6, 'https://thumb1.shutterstock.com/thumb_large/3040346/760987840/stock-photo-white-linen-pillow-cushion-mockup-on-plaid-inrerior-photo-760987840.jpg');

INSERT INTO product.product_images(
  product_id, url)
  VALUES (6, 'https://thumb1.shutterstock.com/thumb_large/137002/1054812590/stock-photo-different-pillows-on-chair-in-room-1054812590.jpg');

INSERT INTO product.product_images(
  product_id, url)
  VALUES (6, 'https://thumb1.shutterstock.com/thumb_large/3040346/760987840/stock-photo-white-linen-pillow-cushion-mockup-on-plaid-inrerior-photo-760987840.jpg');

INSERT INTO product.product_images(
  product_id, url)
  VALUES (6, 'https://thumb1.shutterstock.com/thumb_large/137002/1054812590/stock-photo-different-pillows-on-chair-in-room-1054812590.jpg');

