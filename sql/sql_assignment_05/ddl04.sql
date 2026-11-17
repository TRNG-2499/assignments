CREATE TABLE principal (
    principal_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    hire_date DATE,
    salary INT
);

CREATE TABLE school (
    school_id INT PRIMARY_KEY,
    school_name VARCHAR(100) NOT NULL,
    principal INT,
    FOREIGN KEY (principal) REFERENCES principal(principal_id)
);

CREATE TABLE student (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    grade_level INT,
    address VARCHAR(255),
    emergency_phone VARCHAR(20),
    school INT,
    FOREIGN KEY (school) REFERENCES school(school_id)
);