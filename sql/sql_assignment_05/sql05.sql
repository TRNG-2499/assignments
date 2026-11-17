CREATE TABLE principal (
    principle_id INT PRIMARY KEY,
    principle_name VARCHAR(100) NOT NULL,
    hire_date DATE NOT NULL,
    salary DECIMAL(8,2) NOT NULL
);

CREATE TABLE schools (
    school_id INT PRIMARY KEY,
    school_name VARCHAR(50) NOT NULL,
    principle INT NOT NULL REFERENCES principal(principle_id)
);

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100),
    grade_level int,
    home_address VARCHAR(150),
    emergency_contact VARCHAR(150),
    school INT NOT NULL REFERENCES schools(school_id)
);

-- author INT NOT NULL REFERENCES writer(writer_id),