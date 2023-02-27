create database quan_ly_ban_hang_san_pham;
use quan_ly_ban_hang_san_pham;
create table customer(
c_id int primary key,
c_name varchar(25),
c_age tinyint
);
create table order_product(
o_id int primary key,
c_id int,
o_date date,
o_total_price int,
foreign key (c_id) references customer(c_id)
);
create table product(
p_id int primary key,
p_name varchar(25),
p_price int
);
create table order_detail(
o_id int,
p_id int,
od_qty int,
primary key(o_id,p_id),
foreign key (p_id) references product(p_id),
foreign key (o_id) references order_product(o_id)
);
insert into customer
value(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);
insert into order_product
value(1,1,'2006-03-21',null),
(2,2,'2006-03-23',null),
(3,1,'2006-03-16',null);
insert into product
value(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);
insert into order_detail
value(1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);
select c_id, o_date, o_total_price from order_product;
select customer.c_name, product.p_name
from customer inner join order_product on customer.c_id = order_product.c_id
inner join order_detail on order_product.o_id=order_detail.o_id
inner join product on order_detail.p_id = product.p_id;
select customer.c_name
from customer left join order_product on customer.c_id = order_product.c_id
where order_product.c_id is null;
select order_product.o_id, o_date, sum(product.p_price * order_detail.od_qty) as total_price
from order_product 
inner join order_detail on order_product.o_id = order_detail.o_id
inner join product on order_detail.p_id = product.p_id
group by order_product.o_id;





