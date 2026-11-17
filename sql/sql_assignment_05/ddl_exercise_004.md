# Exercise Four

Given the following information, create SQL scripts to create the three tables described.

Principles have a name, hire date, and salary.
Schools have a name, and a single principle
Students have a name, a grade level (7th, 8th, 9th, etc...), a home address, an emergency contact phone number, and a school



CREATE TABLE principles(
    principle_name VARCHAR(100) NOT NULL,
    hire_date DATE NOT NULL,
    salary INT NOT NULL,
    PRIMARY KEY (principle_name)
);


CREATE TABLE schools(
    school_name VARCHAR(100) NOT NULL,
    school_principle VARCHAR(100) NOT NULL,
    FOREIGN KEY (school_principle) REFERENCES principles(principle_name),
    PRIMARY KEY (school_name)
);

CREATE TABLE students(
    student_name VARCHAR(100) NOT NULL,
    grade_level INT NOT NULL,
    home_address VARCHAR(100) NOT NULL,
    emergency_contact VARCHAR(100) NOT NULL,
    school VARCHAR(100) NOT NULL,
    FOREIGN KEY (school) REFERENCES schools(school_name),
    PRIMARY KEY(student_name)
);