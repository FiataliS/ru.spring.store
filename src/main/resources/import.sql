DROP TABLE product IF EXISTS;
CREATE TABLE IF NOT EXISTS product (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO product (title, price) VALUES ('Гала', 10), ('Черный принц', 13), ('Карамелька', 23),('Спартан', 50),
('Фуджи', 47), ('Ренет Симиренко', 5), ('Хоней Крисп', 73)
