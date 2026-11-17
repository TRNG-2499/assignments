DROP TABLE IF EXISTS Principals;
DROP TABLE IF EXISTS Schools;
DROP TABLE IF EXISTS Students;

CREATE TABLE Principals (
    name VARCHAR(100) PRIMARY KEY,
    hire_date DATE,
    salary DECIMAL
);

CREATE TABLE Schools (
    name VARCHAR(100) PRIMARY KEY,
    principal VARCHAR(100) REFERENCES Principals(name)
);

CREATE TABLE Students (
    name VARCHAR(100) PRIMARY KEY,
    grade_level INTEGER,
    home_address VARCHAR(200),
    emergency_contact_phone VARCHAR(100),
    school VARCHAR(100) REFERENCES Schools(name)
);