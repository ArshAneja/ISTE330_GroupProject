-- Zaher Asad, Joshua Arquette, Arsh Aneja, Yunhao Dong
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
END //


delimiter ;

CALL GetAcademics();