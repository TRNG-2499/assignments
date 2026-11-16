CREATE TABLE Principals(
name VARCHAR(100) PRIMARY KEY,
hireDATE VARCHAR(50),
salary INT
);

CREATE TABLE Schools(
name VARCHAR(100) PRIMARY KEY,
principalsName VARCHAR(100) UNIQUE REFERENCES Principals(name)
);

CREATE TABLE Students(
name VARCHAR(100),
gradeLevel INT,
address VARCHAR(500),
emergencyContact VARCHAR(20),
school VARCHAR(100) REFERENCES Schools(name)
);

