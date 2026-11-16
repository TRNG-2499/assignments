CREATE TABLE Principal (
    principal_id INT PRIMARY KEY,
    principal_name VARCHAR(100),
    hire_date DATE,
    salary DECIMAL(12, 2)
);

CREATE TABLE School (
    school_id INT PRIMARY KEY,
    school_name VARCHAR(150),
    principal_id INT NOT NULL REFERENCES Principal(principal_id)
);

CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100),
    grade_level VARCHAR(10),
    home_address VARCHAR(255),
    emergency_contact_phone VARCHAR(25),
    school_id INT NOT NULL REFERENCES School(school_id)
);