-- Zaher Asad, Joshua Arquette, Arsh Aneja
-- 11/14/2022
-- ISTE 330
-- Group Project

DROP DATABASE IF EXISTS academicSkills;
CREATE DATABASE academicSkills;
USE academicSkills;

Drop table if exists Faculty_Password;
DROP TABLE IF EXISTS Faculty_Skill;
drop table if exists Abstract_Skill;
DROP TABLE IF EXISTS Skill;
DROP TABLE IF EXISTS abstract;
Drop table if exists Faculty;
Drop table if exists Student_Skill;
Drop table if exists Student_Password;
Drop table if exists Student; 

CREATE TABLE Faculty (
    faculty_id int AUTO_INCREMENT,
    lastName varchar(255),
    firstName varchar(255),
    email varchar(255),
    officeNumber varchar(255),
    password varchar(255),
    primary key (faculty_id)
);
create table Skill(
	skill_id int not null auto_increment,
    skill_name varchar(255),
	key(skill_id)
);

Create table Faculty_Password(
faculty_id int NOT NULL,
    encrypted_password varchar(255) NOT NULL,
    PRIMARY KEY (faculty_id),
    FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id)
);

create table Faculty_Skill(
	faculty_id int not null,
    skill_id int not null,
	FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id),
	FOREIGN KEY (skill_id) REFERENCES Skill(skill_id)
);

Create table abstract(
	abstract_id int not null,
    faculty_id int not null,
    abstractName varchar(255),
    abstractSummary varchar(255),
     KEY (abstract_id),
    FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id)
);

create table Abstract_Skill(
	abstract_id int not null,
    skill_id int not null,
	FOREIGN KEY (abstract_id) REFERENCES abstract(abstract_id),
	FOREIGN KEY (skill_id) REFERENCES Skill(skill_id)
);

create table Student(
    student_id int not null AUTO_INCREMENT,
    lastName varchar(255) not null,
    firstName varchar(255) not null,
    email varchar(255) not null,
    grade varchar(255),
    password varchar(255),
    primary key (student_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000;

Create table Student_Password(
     student_id int NOT NULL,
    encrypted_password varchar(255) NOT NULL,
    PRIMARY KEY (student_id),
    FOREIGN KEY (student_id) REFERENCES Student(student_id)
);

create table Student_Skill(
	student_id int not null,
    skill_id int not null auto_increment,
	FOREIGN KEY (student_id) REFERENCES Student(student_id),
	FOREIGN KEY (skill_id) REFERENCES Skill(skill_id)
);



insert Faculty values(1,"John","David","dj@rit.edu","Gold","10099878e72cf7e0ee4aa0cbce77aa8d5e6825f3");
insert Faculty values(2,"Molly","Bonnie","mb@rit.edu","gol-234","5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8");
insert Faculty_Password values(1,'dj');
insert Faculty_Password values(2,'password');


insert Skill values(1,"php");
insert Skill values(1,"java");
insert Skill values(1,"python");

insert Skill values(2,"html");
insert Skill values(2,"css");
insert Skill values(2,"ruby");

insert faculty_skill values(1,1);
insert faculty_skill values(2,2);

 insert abstract values(1,1,"Python is cool","A summary of python being very cool.");
 insert abstract values(2,2,"Java is super fun!","Java can be very complex, but what if I say theres any easier way to learn?");
  insert abstract values(2,2,"Java is super fun!","Java can be very complex, but what if I say theres any easier way to learn?");

 
 
 insert abstract_skill values(1,1);
 insert abstract_skill values(2,2);
 
insert Student(lastName,firstName, email, password) values("Johnson","Jamal","jj@rit.edu","ILovemyMom123");
insert Student(lastName,firstName, email, password) values("Morales","Miles","mm@rit.edu","Spiderman12");

insert Student_Password values(10000,"ILovemyMom123");
insert Student_Password values(10001,"Spiderman12");

insert Skill values(10000,"php");
insert Skill values(10000,"java");
insert Skill values(10000,"python");


insert Skill values(10001,"bash");
insert Skill values(10001,"css");
insert Skill values(10001,"C++");

insert Student_Skill values(10000,10000);
insert Student_Skill values(10000,10001);

select * from Skill;


select Faculty.firstName, Skill.skill_name from Skill
inner join Faculty_Skill on Faculty_Skill.skill_id = Skill.skill_id
inner join Faculty on Faculty_Skill.faculty_id = Faculty.faculty_id;


select password from Faculty where email = "dj@rit.edu";
select * from Faculty;

select student_id from student where email = "mm@rit.edu";
select firstName from Faculty where email = "dj@rit.edu";
 
 select Faculty.firstName, Faculty.lastName, Faculty.officeNumber, Skill.skill_name  from Skill inner join Faculty_Skill on Faculty_Skill.skill_id = Skill.skill_id inner join Faculty on Faculty_Skill.faculty_id = Faculty.faculty_id where skill_name = "php";

select skill_id, skill_name, abstractName from Skill
inner join abstract_skill using (skill_id)
inner join Abstract using(abstract_id);
 
 select * from Faculty;
