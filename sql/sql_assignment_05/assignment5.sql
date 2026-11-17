-- assuming 'principle' is supposed to be principal...
DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS School;
DROP TABLE IF EXISTS Principal;

CREATE TABLE Principal(
	name varchar PRIMARY KEY,
	hire_date Date,
	salary bigint
);

CREATE TABLE School(
	name varchar PRIMARY KEY,
	principal varchar REFERENCES Principal(name)
);

CREATE TABLE Student(
	name varchar PRIMARY KEY,
	grade_level int,
	home_address varchar,
	emergency_contact varchar,
	school varchar REFERENCES School(name)
);