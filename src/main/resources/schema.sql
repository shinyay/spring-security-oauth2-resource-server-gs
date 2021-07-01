DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
    `id` bigint(20) NOT NULL,
    `name` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);