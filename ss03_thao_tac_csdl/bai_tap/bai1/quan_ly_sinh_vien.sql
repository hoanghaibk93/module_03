create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class_room (
class_id int primary key auto_increment,
class_name varchar(60) not null,
start_date date not null,
status bit
);
create table student(
student_id int primary key auto_increment,
student_name varchar(30),
address varchar(50),
phone varchar(20),
status bit,
class_id int not null,
foreign key (class_id) references class_room(class_id)
);
create table subject(
sub_id int primary key auto_increment,
sub_name varchar(30) not null,
credit tinyint not null default 1 check(credit >=1),
status bit default 1
);
create table mark(
mark_id int primary key auto_increment,
sub_id int not null,
student_id int not null,
unique(sub_id, student_id),
mark float default 0 check (mark between 0 and 100),
exam_times tinyint default 1,
foreign key (sub_id) references subject(sub_id),
foreign key (student_id) references student(student_id)
);
drop table mark;
insert into class_room
value(1,'A1','2008-12-20',1),
(2,'A2','2008-12-22',1),
(3,'B3',current_date,0);
insert into student
value(1,'Hung','Ha Noi','0912113113',1,1),
(2,'Hoa','Hai Phong','',1,1),
(3,'Manh','HCM','0123123123',0,2);
insert into subject
value(1,'CF',5,1),
(2,'C',6,1),
(3,'HDJ',5,1),
(4,'RDBMS',10,1);
insert into mark
value(1,1,1,8,1),
(2,1,2,10,2),
(3,2,1,12,1);
select * from student where student_name like 'h%';
select * from class_room where start_date like '%12%';
select * from subject where credit between 3 and 5;
update student set class_id = 2 where student_id = 1;
select student.student_name, subject.sub_name, mark.mark
from student inner join mark on student.student_id = mark.student_id
inner join subject on mark.sub_id = subject.sub_id
order by mark.mark desc, student.student_name;



