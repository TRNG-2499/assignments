CREATE TABLE Principal (
    name VARCHAR(50) PRIMARY KEY,
    hire_date DATE NOT NULL,
    salary FLOAT NOT NULL
);

CREATE TABLE School (
    name VARCHAR(50) PRIMARY KEY,
    principal_name VARCHAR(50) UNIQUE NOT NULL REFERENCES Principal(name)
);

CREATE TABLE Student (
    name VARCHAR(50) NOT NULL,
    grade_level INTEGER NOT NULL,
    home_address VARCHAR(50),
    emergency_contact VARCHAR(20),
    school VARCHAR(50) NOT NULL REFERENCES School(name)
);