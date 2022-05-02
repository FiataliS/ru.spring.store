DROP TABLE purchases IF EXISTS;
DROP TABLE product IF EXISTS;
DROP TABLE users IF EXISTS;

CREATE TABLE IF NOT EXISTS product (id bigserial, name VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO product (name, price) VALUES ('Гала', 10), ('Черный принц', 13), ('Карамелька', 23), ('Спартан', 50), ('Фуджи', 47), ('Ренет Симиренко', 5), ('Хоней Крисп', 73);

CREATE TABLE IF NOT EXISTS users (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO users (name) VALUES ('Пользователь_1'), ('Пользователь_2');

CREATE TABLE IF NOT EXISTS purchases (userId int REFERENCES users (id), productId int REFERENCES product (id));
INSERT INTO purchases (userId, productId) VALUES (1,2),(1,1),(1,3),(1,4),(2,3),(2,4),(2,1);