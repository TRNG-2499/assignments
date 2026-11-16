CREATE TABLE Principle (
    principle_id INT PRIMARY KEY, 
    name VARCHAR(100),
    hire_date DATE,
    salary DECIMAL(10, 2)
);

CREATE TABLE School (
    school_id INT PRIMARY KEY,
    name VARCHAR(100),
    principle_id INT REFERENCES Principle(principle_id)
);

CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    grade_level VARCHAR(10),
    home_address VARCHAR(100),
    emergency_contact_phone VARCHAR(15),
    school_id INT REFERENCES School(school_id)
);