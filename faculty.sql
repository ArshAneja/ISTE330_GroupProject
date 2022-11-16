-- Zaher Asad, Joshua Arquette, Arsh Aneja
-- 11/14/2022
-- ISTE 330
-- Group Project

DROP DATABASE IF EXISTS academicSkills;
CREATE DATABASE academicSkills;
USE academicSkills;

DROP TABLE IF EXISTS Faculty_Password;
DROP TABLE IF EXISTS Faculty_Skill;
DROP TABLE IF EXISTS Abstract_Skill;
DROP TABLE IF EXISTS Skill;
DROP TABLE IF EXISTS abstract;
DROP TABLE IF EXISTS Faculty;
DROP TABLE IF EXISTS Student_Skill;
DROP TABLE IF EXISTS Student_Password;
DROP TABLE IF EXISTS Student; 

CREATE TABLE Faculty (
    faculty_id INT AUTO_INCREMENT,
    lastName VARCHAR(255),
    firstName VARCHAR(255),
    email VARCHAR(255),
    officeNumber VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY (faculty_id)
);
create table Skill(
	skill_id INT NOT NULL auto_increment,
    skill_name VARCHAR(255),
	key(skill_id)
);

Create table Faculty_Password(
faculty_id INT NOT NULL,
    encrypted_password VARCHAR(255) NOT NULL,
    PRIMARY KEY (faculty_id),
    FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id)
);

create table Faculty_Skill(
	faculty_id INT NOT NULL,
    skill_id INT NOT NULL,
	FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id),
	FOREIGN KEY (skill_id) REFERENCES Skill(skill_id)
);

Create table Abstract(
	abstract_id INT NOT NULL,
    faculty_id INT NOT NULL,
    abstractName VARCHAR(255),
    abstractSummary VARCHAR(255),
    PRIMARY KEY (abstract_id),
    FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id)
);

create table Abstract_Skill(
	abstract_id INT NOT NULL,
    skill_id INT NOT NULL,
	FOREIGN KEY (abstract_id) REFERENCES abstract(abstract_id),
	FOREIGN KEY (skill_id) REFERENCES Skill(skill_id)
);

create table Student(
    student_id INT NOT NULL AUTO_INCREMENT,
    lastName VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    grade VARCHAR(255),
    PASSWORD VARCHAR(255),
    PRIMARY KEY (student_id)
)ENGINE=InnoDB AUTO_INCREMENT=10000;

Create table Student_Password(
     student_id INT NOT NULL,
    encrypted_password VARCHAR(255) NOT NULL,
    PRIMARY KEY (student_id),
    FOREIGN KEY (student_id) REFERENCES Student(student_id)
);

create table Student_Skill(
	student_id INT NOT NULL,
    skill_id INT NOT NULL AUTO_INCREMENT,
	FOREIGN KEY (student_id) REFERENCES Student(student_id),
	FOREIGN KEY (skill_id) REFERENCES Skill(skill_id)
);



insert Faculty values(1,"John","David","dj@rit.edu","Gold","dj");
insert Faculty values(2,"Molly","Bonnie","mb@rit.edu","gol-234","password");
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
 
 insert abstract_skill values(1,1);
 insert abstract_skill values(2,2);
 
insert Student(lastName,firstName, email) values("Johnson","Jamal","jj@rit.edu");
insert Student(lastName,firstName, email) values("Morales","Miles","mm@rit.edu");

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









