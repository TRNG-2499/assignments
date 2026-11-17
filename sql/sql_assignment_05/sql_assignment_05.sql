CREATE TABLE Principal (
    name VARCHAR(200) PRIMARY KEY,
    hire_date DATE,
    salary INT

);

CREATE TABLE School (
    name VARCHAR(200) PRIMARY KEY,
    principle VARCHAR(200),
    FOREIGN KEY (principle) REFERENCES Principal(name)
);

CREATE TABLE Students (
    name VARCHAR(200) PRIMARY KEY,
    grade_level VARCHAR(10),
    home_address VARCHAR(200),
    emergency_number VARCHAR(20),
    school VARCHAR(200),
    FOREIGN KEY (school) REFERENCES School(name)

);
