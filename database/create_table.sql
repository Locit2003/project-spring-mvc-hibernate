use shop_fashion;

CREATE TABLE `category`
(
	`id` bigint auto_increment primary key,
    `name` VARCHAR(255) NOT NULL,
    `status` tinyint DEFAULT(1),
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NULL,
    `delete_at` DATETIME NULL
);

CREATE TABLE `product`
(
	`id` bigint primary key auto_increment,
    `name` VARCHAR(255) NOT NULL,
    `image` VARCHAR(255) NOT NULL,
    `price` FLOAT NOT NULL,
    `sale_price` FLOAT NULL,
    `description` text NULL,
    `category_id` bigint NOT NULL,
	`created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NULL,
    `delete_at` DATETIME NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE `account`
(
	`id` BIGINT PRIMARY KEY auto_increment,
    `fullname` VARCHAR(200) NOT NULL,
    `userName` VARCHAR(200) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `role` VARCHAR(20) DEFAULT 'user', 
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NULL,
    `delete_at` DATETIME NULL
)