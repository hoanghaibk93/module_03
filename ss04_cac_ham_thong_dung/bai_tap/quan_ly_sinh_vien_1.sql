create database quan_ly_sinh_vien_1;
use quan_ly_sinh_vien_1;
create table class_room (
class_id int primary key auto_increment,
class_name varchar(60) not null,
start_date date not null,
class_status bit
);
create table student(
student_id int primary key auto_increment,
student_name varchar(30),
address varchar(50),
phone varchar(20),
student_status bit,
class_id int not null,
foreign key (class_id) references class_room(class_id)
);
create table subject_nomal(
sub_id int primary key auto_increment,
sub_name varchar(30) not null,
credit tinyint not null default 1 check(credit >=1),
subject_status bit default 1
);
create table mark(
mark_id int primary key auto_increment,
sub_id int not null,
student_id int not null,
unique(sub_id, student_id),
mark float default 0 check (mark between 0 and 100),
exam_times tinyint default 1,
foreign key (sub_id) references subject_nomal(sub_id),
foreign key (student_id) references student(student_id)
);
insert into class_room
value(1,'A1','2008-12-20',1),
(2,'A2','2008-12-22',1),
(3,'B3',current_date,0);
insert into student
value(1,'Hung','Ha Noi','0912113113',1,1),
(2,'Hoa','Hai Phong','',1,1),
(3,'Manh','HCM','0123123123',0,2);
insert into subject_nomal
value(1,'CF',5,1),
(2,'C',6,1),
(3,'HDJ',5,1),
(4,'RDBMS',10,1);
insert into mark
value(1,1,1,8,1),
(2,1,2,10,2),
(3,2,1,12,1);
select * from subject_nomal
where credit = (select max(credit) from subject_nomal);
select s.sub_id, s.sub_name, s.credit, s.subject_status, m.mark 
from subject_nomal s inner join mark m on s.sub_id = m.sub_id
where  mark = (select max(mark) from mark);
select s.student_id, s.student_name, s.address, s.phone, s.student_status, s.class_id, avg(mark)
from mark m inner join student s on m.student_id = s.student_id
group by m.student_id;
