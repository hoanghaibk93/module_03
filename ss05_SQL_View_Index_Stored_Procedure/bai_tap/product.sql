create database management_product;
use management_product;
create table products (
id int,
product_code varchar(10),
product_name varchar(30),
product_price double,
product_amount int,
product_description varchar(99),
product_status bit,
primary key (id)
);
insert into products 
value(1, 'xxvl-001','sách',100000,5,'sách bán chạy nhất', 1),
(2, 'xxvl-002','vỏ',300000,5,'vở đẹp', 1),
(3, 'xxvl-003','bàn học',300000,5,'bàn bằng nhựa', 1),
(4, 'xxvl-004','sữa',200000,5,'sữa ngon', 1),
(5, 'xxvl-005','tivi',500000,5,'tivi samsung', 1);
create unique index index_product_code on products(product_code); 
create index index_product_name_price on products(product_name, product_price);
explain select *
from products
where product_code = 'xxvl-004';
create view view_products 
as 
select f