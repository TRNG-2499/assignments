

CREATE TABLE Principal (
    principal_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    hire_date DATE,
    salary DECIMAL(10, 2)
);

CREATE TABLE School (
    school_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    principal_id INT UNIQUE,
    FOREIGN KEY (principal_id) REFERENCES Principal(principal_id)
);


CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    grade_level VARCHAR(50),
    home_address VARCHAR(255),
    emergency_contact_phone VARCHAR(50),
    school_id INT,
    FOREIGN KEY (school_id) REFERENCES School(school_id)
);