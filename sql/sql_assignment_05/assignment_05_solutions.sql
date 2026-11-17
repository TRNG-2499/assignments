CREATE SCHEMA assignment_5;

BEGIN TRANSACTION;
	CREATE TABLE assignment_5.Principles (
		principle_id INTEGER PRIMARY KEY,
		name VARCHAR(50),
		salary VARCHAR(50)
	);
	CREATE TABLE assignment_5.Schools (
		school_id INTEGER PRIMARY KEY,
		name VARCHAR(100),
		principle_id INTEGER REFERENCES assignment_5.Principles(principle_id)
	);
	CREATE TABLE assignment_5.Students (
		student_id INTEGER PRIMARY KEY,
		name VARCHAR(100),
		grade_level VARCHAR(50),
		home_address VARCHAR(100),
		emergency_contact_phone VARCHAR(50),
		school_id INTEGER REFERENCES assignment_5.Schools(school_id)
	);
COMMIT;

DROP SCHEMA assignment_5 CASCADE;