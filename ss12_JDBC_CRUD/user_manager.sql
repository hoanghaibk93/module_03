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

DELIMITER $$
CREATE procedure findAll()
begin
select * 
from users;
end; $$
DELIMITER ;
call findAll();
Delimiter $$
create procedure updateUser(in new_name varchar(30), in new_email varchar(99), in new_country varchar(99), in new_id int)
begin
update users
set name = new_name,
email = new_email,
country = new_country
where id = new_id;
end; $$
delimiter ;
call updateUser('Trung Hoành','hoang.trung@gmail.com','phap',9)