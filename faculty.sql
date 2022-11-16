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
    password VARCHAR(255),
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

INSERT Faculty VALUES(1,"John","David","dj@rit.edu","Gold","dj");
INSERT Faculty VALUES(2,"Molly","Bonnie","mb@rit.edu","gol-234","password");
INSERT Faculty_Password VALUES(1,'dj');
INSERT Faculty_Password VALUES(2,'password');


INSERT Skill VALUES(1,"php");
INSERT Skill VALUES(1,"java");
INSERT Skill VALUES(1,"python");

INSERT Skill VALUES(2,"html");
INSERT Skill VALUES(2,"css");
INSERT Skill VALUES(2,"ruby");

INSERT faculty_skill VALUES(1,1);
INSERT faculty_skill VALUES(2,2);

 INSERT abstract VALUES(1,1,"Python is cool","A summary of python being very cool.");
 INSERT abstract VALUES(2,2,"Java is super fun!","Java can be very complex, but what if I say theres any easier way to learn?");
 
 INSERT abstract_skill VALUES(1,1);
 INSERT abstract_skill values(2,2);
 
INSERT Student(lastName,firstName, email) VALUES("Johnson","Jamal","jj@rit.edu");
INSERT Student(lastName,firstName, email) VALUES("Morales","Miles","mm@rit.edu");

INSERT Student_Password VALUES(10000,"ILovemyMom123");
INSERT Student_Password VALUES(10001,"Spiderman12");

INSERT Skill VALUES(10000,"php");
INSERT Skill VALUES(10000,"java");
INSERT Skill VALUES(10000,"python");

INSERT Skill VALUES(10001,"bash");
INSERT Skill VALUES(10001,"css");
INSERT Skill VALUES(10001,"C++");

INSERT Student_Skill VALUES(10000,10000);
INSERT Student_Skill VALUES(10000,10001);

SELECT * FROM Skill;

SELECT Faculty.firstName, Skill.skill_name FROM Skill
INNER JOIN Faculty_Skill ON Faculty_Skill.skill_id = Skill.skill_id
INNER JOIN Faculty ON Faculty_Skill.faculty_id = Faculty.faculty_id;