CREATE TABLE Principle(
    principle_id INT PRIMARY KEY,
    principle_name VARCHAR(100),
    hire_date DATE,
    salary INT
);

CREATE TABLE School(
    school_id INT PRIMARY KEY,
    school_name VARCHAR(100),
    principle_id INT UNIQUE,
    FOREIGN KEY (principle_id) REFERENCES Principle(principle_id)
);

CREATE TABLE Student(
    student_id INT PRIMARY KEY,
    school_id INT,
    student_name VARCHAR (100),
    grade_level VARCHAR (100),
    home_address VARCHAR(100),
    emergency_contact VARCHAR(100),
    FOREIGN KEY  (school_id) REFERENCES School(school_id)
); 