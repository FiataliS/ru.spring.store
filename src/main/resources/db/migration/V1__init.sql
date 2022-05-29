CREATE TABLE IF NOT EXISTS product (id bigserial, name VARCHAR(255),  price int, country VARCHAR (255), PRIMARY KEY (id));
INSERT INTO product (name, price, country) VALUES ('Гала', 10, 'Китай'), ('Черный принц', 13, 'Китай'), ('Карамелька', 23, 'Китай'), ('Спартан', 50, 'Россия'), ('Фуджи', 47, 'Китай'), ('Ренет Симиренко', 5, 'Россия'), ('Хоней Крисп', 73, 'Китай'), ('Спартан', 500, 'Россия'), ('Фуджи', 35, 'Китай'), ('Ренет Симиренко', 80, 'Россия'), ('Хоней Крисп', 49, 'Китай');

CREATE TABLE IF NOT EXISTS users (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO users (name) VALUES ('Пользователь_1'), ('Пользователь_2');

CREATE TABLE IF NOT EXISTS purchases (user_id int REFERENCES users (id), product_id int REFERENCES product (id));
INSERT INTO purchases (user_id, product_id) VALUES (1,2),(1,1),(1,3),(1,4),(2,3),(2,4),(2,1);