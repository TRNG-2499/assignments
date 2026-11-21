CREATE TABLE Principles (
    principle_id INT PRIMARY KEY,
    name VARCHAR(100),
    salary INT,
    hire_date DATE
);

CREATE TABLE School (
    school_id INT PRIMARY KEY,
    name VARCHAR(100),
    principle_id INT REFERENCES Principles(principle_id)
);

CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    grade_level INT,
    home_address VARCHAR(200),
    emergency_phone VARCHAR(20),
    school_id INT REFERENCES School(school_id)
);
