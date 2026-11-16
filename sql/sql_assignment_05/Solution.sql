CREATE TABLE Principles (
    principle_id INTEGER PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    hire_date DATE,
    salary INTEGER
);

CREATE TABLE School (
    school_id INTEGER PRIMARY KEY,
    principle_id INTEGER REFERENCES Principles(principle_id),
    school_name VARCHAR(255)
);

CREATE TABLE Student (
    student_id INTEGER PRIMARY KEY,
    school_id INTEGER REFERENCES School(school_id),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    grade_level VARCHAR(10),
    home_address VARCHAR(255),
    emergency_contact VARCHAR(255)
);