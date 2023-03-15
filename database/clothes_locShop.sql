CREATE DATABASE clothes_locShop

USE clothes_locShop

CREATE TABLE role(
id int primary key AUTO_INCREMENT,
name varchar(50) NULL
)

CREATE TABLE users(
id int primary key AUTO_INCREMENT,
username varchar(100) NULL,
password varchar(200) NULL,
enabled bit NULL
)

CREATE TABLE users_roles(
id int primary key AUTO_INCREMENT,
userId int NOT NULL,
roleId int NOT NULL,
FOREIGN KEY (userId) REFERENCES users(id),
FOREIGN KEY (roleId) REFERENCES role(id)
)


CREATE TABLE category
(
	id bigint primary key AUTO_INCREMENT,
    name varchar(150) NOT NULL,
    status tinyint DEFAULT(1),
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NULL,
    delete_at DATETIME NULL
)


CREATE TABLE product
(
	id bigint primary key AUTO_INCREMENT,
    name varchar(150) NOT NULL,
    image varchar(150) NOT NULL,
    price FLOAT NOT NULL,
    sale_price FLOAT NULL,
    description text NULL,
    category_id bigint NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NULL,
    delete_at DATETIME NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

