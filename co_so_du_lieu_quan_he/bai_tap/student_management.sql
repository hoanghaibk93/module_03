create database student_management;
use student_management;
create table class(
id int primary key,
name varchar(300)
);
insert into class(id, name)
value (1, 'Huy'),
(2, 'Hung'),
(3, 'Anh'),
(4, 'Phuc');
select * from class;
Drop table class;
DRop database student_management;
create table teacher(
id int primary key auto_increment,
name varchar(200),
age int,
country varchar(300)
);
Drop table teacher;
insert into teacher(name, age, country)
value ('Quynh',20,'Viet Nam'),
('Mr.Smirth',25,'English'),
('Miss.Thu',30,'French'),
('Miss.Huong',30,'French');
delete from teacher
where id > 2;
select * from teacher;
update teacher
set age = 40
where id = 2;
