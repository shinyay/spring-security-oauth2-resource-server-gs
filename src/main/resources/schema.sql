DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
    `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);