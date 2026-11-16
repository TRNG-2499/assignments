CREATE SCHEMA IF NOT EXISTS school_schema;
SET search_path TO school_schema; --To keep it private
CREATE TABLE IF NOT EXISTS Principles(
principle_id BIGSERIAL PRIMARY KEY,
first_name VARCHAR(120) NOT NULL,
last_name VARCHAR(120) NOT NULL,
hire_date DATE NOT NULl DEFAULT CURRENT_DATE,
salary DECIMAL(12, 2) NOT NULL CHECK (salary >= 0)
);
SELECT * FROM principles;


CREATE TABLE IF NOT EXISTS schools(
school_id BIGSERIAL PRIMARY KEY,
school_name VARCHAR(120) NOT NULL UNIQUE,
principle_id BIGINT UNIQUE NOT NULL REFERENCES principles(principle_id)
);
SELECT * FROM schools;


CREATE TABLE IF NOT EXISTS students(
student_id BIGSERIAL NOT NULL PRIMARY KEY,
first_name VARCHAR(120) NOT NULL,
last_name VARCHAR(120) NOT NULL,
grade_level VARCHAR(10) NOT NULL,
home_address VARCHAR(200) NOT NULL,
emergency_contact VARCHAR(30) NOT NULL,
school_id BIGINT REFERENCES schools(school_id)
);
SELECT * FROM students;