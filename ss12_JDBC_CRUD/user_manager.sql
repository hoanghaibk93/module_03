CREATE database demo;
use demo;
create table users(
id int(3) not null auto_increment,
name varchar(120) not null,
email varchar(220) not null,
country varchar(120),
primary key (id)
);
insert into users(name, email, country)
value('Huy','huy.hoang@gmail.com','VietNam'),
('Minh','minh.pham@gmail.com','Phap'),
('Tung','tung.pham@gmail.com','Duc'),
('Thu','thu.pham@gmail.com','Lao'),
('Nhu','nhu.pham@gmail.com','VietNam');