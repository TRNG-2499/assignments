CREATE SCHEMA district;

CREATE TABLE district.principles (
    principle_name VARCHAR(100) PRIMARY KEY,
    hire_date DATE,
    salary NUMERIC
);

CREATE TABLE district.schools (
    school_name VARCHAR(100) PRIMARY KEY,
    principle_name VARCHAR(100) UNIQUE REFERENCES district.principles(principle_name);
);

CREATE TABLE dsitrict.students (
    student_name VARCHAR(100) PRIMARY KEY,
    grade_level VARCHAR(10),
    home_address VARCHAR(100),
    emergency_contact VARCHAR(20),
    school_name VARCHAR(100) REFERENCES district.schools(school_name)
);