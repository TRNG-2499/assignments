CREATE TABLE Principles(
    name VARCHAR(50),
    hire_date DECIMAL DATE,
    salary (10,2)
);

CREATE TABLE Schools(
    name VARCHAR(50),
    single_principle VARCHAR(50)
);

CREATE TABLE Students(
    name VARCHAR(50),
    grade_level INT,
    home_address VARCHAR(50),
    emergency_contact VARCHAR(50),
    school VARCHAR(50)
);