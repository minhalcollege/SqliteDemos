-- this is a notebook file...
-- here we do a summary:


--DBMS: Data base management system:
-- IDE for db's?

--comment dash dash:
CREATE TABLE tableName;

--/*
--this is also supported
--*/


--create tables:
--pseudo code
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    column3 datatype,
   ....
);

--Example:
CREATE TABLE Students(
    --google calls the id: _id
    --naming convention - common practice:
    _id INT,
    firstName TEXT, --NCHAR(24),
    lastName TEXT
);

--Naming Conventions: All Caps on Syntax keywords




--INSERT
-- Add a record:

--Pseudo code:
INSERT INTO table_name(column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);


--Concrete:
INSERT INTO Students(_id, firstName, lastName)
VALUES(1, 'Tomer', 'Bu')



-- Delete a table:
DROP TABLE Students;
 CREATE TABLE Students (
	_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	firstName	TEXT,
	lastName	TEXT
);

--pseudo code Syntax:
--SELECT * FROM TableName
--SELECT col1, col2 FROM TableName

--concrete:
SELECT * FROM Students;

--UPDATE
UPDATE Students
  SET firstName = 'Master', lastName = 'Yoda'
  WHERE _id = 1;

  SELECT * FROM Students;




--
DELETE FROM Students
WHERE _id = 1;










