CREATE SCHEMA school;

CREATE TABLE school.principle (
	principle_id INT PRIMARY KEY,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	hire_date DATE,
	salary INT
);

CREATE TABLE school.schools (
	school_id INT PRIMARY KEY,
	school_name VARCHAR(100),
	principle_id INT NOT NULL REFERENCES school.principle(principle_id)
);

CREATE TABLE school.student (
	student_id INT PRIMARY KEY,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	grade INT,
	home_address VARCHAR(100),
	emergency_phone VARCHAR(20),
	school_id INT NOT NULL REFERENCES school.schools(school_id)
);