Drop table if exists Faculty_Password;
DROP TABLE IF EXISTS Faculty_Skill;
drop table if exists Abstract_Skill;
DROP TABLE IF EXISTS Skill;
DROP TABLE IF EXISTS abstract;
Drop table if exists Faculty;

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
	skill_id int not null,
    skill_name varchar(255),
    primary key(skill_id)
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




