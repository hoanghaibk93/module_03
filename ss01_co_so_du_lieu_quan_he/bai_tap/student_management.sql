create database student_management;
use student_management;
create table class_room(
id int primary key,
name varchar(300)
);
insert into class_room(id, name)
value (1, 'Huy'),
(2, 'Hung'),
(3, 'Anh'),
(4, 'Phuc');
select * from class_room;
drop table class_room;
drop database student_management;
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
insert into teacher
value(4,'Cong',40,'VN'),
(3,'Hai',30,'VN');
select * from teacher
WHERE country = 'VN'
limit 1;
select min(age) as 'tuoinho' from teacher;
