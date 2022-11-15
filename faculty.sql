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
    encrypted_password int NOT NULL,
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
    abstractSkills varchar(255),
    PRIMARY KEY (abstract_id),
    FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id)
);

create table Abstract_Skill(
	abstract_id int not null,
    skill_id int not null,
	FOREIGN KEY (abstract_id) REFERENCES abstract(abstract_id),
	FOREIGN KEY (skill_id) REFERENCES Skill(skill_id)
);

create table Student(
    student_id int AUTO_INCREMENT,
    lastName varchar(255),
    firstName varchar(255),
    email varchar(255),
    grade varchar(255),
    password varchar(255),
    primary key (student_id)
);

Create table Student_Password(
     student_id int NOT NULL,
    encrypted_password int NOT NULL,
    PRIMARY KEY (student_id),
    FOREIGN KEY (student_id) REFERENCES Student(student_id)
);

create table Student_Skill(
	student_id int not null,
    skill_id int not null,
	FOREIGN KEY (student_id) REFERENCES Student(student_id),
	FOREIGN KEY (skill_id) REFERENCES Skill(skill_id)
);


insert Faculty values(1,"John","David","dj@rit.edu","Gold","dj");
insert Skill values(1,"php");
insert Skill values(1,"java");
insert Skill values(1,"python");
insert faculty_skill values(1,1);





select Faculty.firstName, Skill.skill_name from Skill
inner join Faculty_Skill on Faculty_Skill.skill_id = Skill.skill_id
inner join Faculty on Faculty_Skill.faculty_id = Faculty.faculty_id;




