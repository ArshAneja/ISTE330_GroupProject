-- Zaher Asad, Joshua Arquette, Arsh Aneja
-- Group Project - Search Procedure
-- 11/13/22
-- Professor Habermas Jim

-- Delete GetAcademics if exists
DROP PROCEDURE IF EXISTS GetAcademics;

-- Use academicSkills database
USE academicSkills;

delimiter //
-- Create a procedure
CREATE PROCEDURE GetAcademics()
BEGIN 
    SELECT * FROM Faculty;
    SELECT * FROM Skill;
    SELECT * FROM Student;

    SELECT CONCAT(Faculty.firstName, " ", Faculty.lastName) AS "Faculty Name", Skill.skill_name FROM Skill
        INNER JOIN Faculty_Skill ON Faculty_Skill.skill_id = Skill.skill_id
        INNER JOIN Faculty ON Faculty_Skill.faculty_id = Faculty.faculty_id;

END //


delimiter ;

CALL GetAcademics();