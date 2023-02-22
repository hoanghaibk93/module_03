create database student_management;
create table Class(
id int primary key,
name varchar(300)
);
insert into Class(id, name)
value (1, 'Huy'),
(2, 'Hung'),
(3, 'Anh'),
(4, 'Phuc');
select * from Class;
Drop table Class;
DRop database student_management;
create table Teacher(
id int primary key auto_increment,
name varchar(200),
age int,
country varchar(300)
);
insert into Teacher(name, age, country)
value ('Quynh',20,'Viet Nam'),
('Mr.Smirth',25,'English'),
('Miss.Thu',30,'French'),
('Miss.Huong',30,'French');
delete from Teacher
where id > 2;
select * from Teacher;
update Teacher
set age = 40
where id = 2;
