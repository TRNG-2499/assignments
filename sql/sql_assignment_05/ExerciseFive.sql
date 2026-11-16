CREATE TABLE Principles (
    principle_id INT PRIMARY KEY,
    principle_name VARCHAR(50),
    hire_date DATE,
    salary DECIMAL(10,2)
);

CREATE TABLE Schools (
    school_id INT PRIMARY KEY,
    school_name VARCHAR(50),
    principle INT REFERENCES Principles(principle_id)
);

CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(50),
    grade_level VARCHAR(6),
    home_address VARCHAR(50),
    emergency_contact VARCHAR(50),
    school INT REFERENCES Schools(school_id)
);
