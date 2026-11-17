
CREATE TABLE principle (
    principle_id INT PRIMARY KEY,
    name VARCHAR(255),
    hire_date DATE,
    SALARY int
)

CREATE TABLE school (
    school_id INT PRIMARY KEY,
    name VARCHAR(255),
    principle_id INT REFERENCES principle(principle_id)
)

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    grade TINYINT,
    address VARCHAR(255),
    number INT,
    school_id INT REFERENCES school(school_id)
)