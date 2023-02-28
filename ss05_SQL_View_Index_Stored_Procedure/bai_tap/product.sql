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
select product_code, product_name, product_price, product_status
from products;
select * from view_products;
update view_products
set product_name = 'điện thoai'
where product_code = 'xxvl-005';
drop view view_products;
delimiter $$
create procedure method_products()
begin 
 select * from products;
 end $$
delimiter ;
 call method_products();
delimiter $$
create procedure and_method_products(in id int,in product_code varchar(10), in product_name varchar(30), in product_price double, in product_amount int, in product_description varchar(99), in product_status bit)
begin 
 insert into products
 values (id, product_code, product_name, product_price, product_amount, product_description, product_status);
 end $$
delimiter ; 
call and_method_products(6, 'xxvl-006','tivi',500000,5,'tivi samsung', 0);
call and_method_products(7, 'xxvl-009','tivi',500000,5,'tivi samsung', 0);
 delimiter $$
create procedure update_method_products(in by_id int,in new_product_code varchar(10), in new_product_name varchar(30), in new_product_price double, in new_product_amount int, in new_product_description varchar(99), in new_product_status bit)
begin 
 update products
 set
 product_code = new_product_code,
 product_name = new_product_name ,
 product_price = new_product_price,
 product_amount = new_product_amount,
 product_description = new_product_description,
 product_status = new_product_status
 where id = by_id;
 end $$
delimiter ; 
call update_method_products(6,'xxvl-010','tủ lạnh',540000,7,'samsung', 1);
 delimiter $$
create procedure delete_method_products(in by_id int)
begin 
 delete from products
 where id = by_id;
 end $$
delimiter ; 
call delete_method_products(4);
