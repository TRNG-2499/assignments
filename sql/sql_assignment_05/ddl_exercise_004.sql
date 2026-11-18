CREATE TABLE IF NOT EXISTS Principle(
    principle_id INT PRIMARY KEY,
    principle_name VARCHAR(30),
    hire_date DATE,
    salary BIGINT
);

CREATE TABLE IF NOT EXISTS School(
    school_id INT PRIMARY KEY,
    school_name VARCHAR(30),
    principle_id INT,
    FOREIGN KEY (principle) REFERENCES Principle(principle_id)
);

CREATE TABLE IF NOT EXISTS Student(
    student_id INT PRIMARY KEY,
    student_name VARCHAR(30),
    grade_level INT,
    home_address VARCHAR(100),
    emergency_contact_phone_number VARCHAR(10),
    school INT,
    FOREIGN KEY (school) REFERENCES School(school_id)
);