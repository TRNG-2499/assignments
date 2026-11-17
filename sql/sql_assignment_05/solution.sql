CREATE TABLE Principles (
    principle_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    hire_date DATE NOT NULL,
    salary NUMERIC(10, 2) NOT NULL
);

CREATE TABLE Schools (
    school_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    principle_id INT NOT NULL UNIQUE,
    FOREIGN KEY (principle_id) REFERENCES Principles(principle_id)
);

CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    grade_level INT NOT NULL,
    home_address VARCHAR(100),
    emergency_contact VARCHAR(100),
    school_id INT NOT NULL, 
    FOREIGN KEY (school_id) REFERENCES Schools(school_id)
);