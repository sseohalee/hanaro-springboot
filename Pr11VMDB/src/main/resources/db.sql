use mydb;
CREATE TABLE PRODUCT (
     id 	BIGINT	PRIMARY KEY AUTO_INCREMENT,
     name varchar(255) NOT NULL,
     price int NOT NULL,
     limit_date date DEFAULT (CURRENT_DATE)
);

select * from product;

insert into product(id, name, price, limit_date) values
       (1, '상추버거',3000,'2023-12-30'),
       (2, '소고기버거',1000,'2023-12-05'),
       (3, '치즈버거',2000,'2023-12-05');
