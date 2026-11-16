CREATE TABLE Principles(
    principal_name VARCHAR(200) PRIMARY KEY,
    hire_date DATE,
    salary INT
);

CREATE TABLE Schools(
    school_name VARCHAR(200) PRIMARY KEY,
    principal_name VARCHAR(200) NOT NULL,

    CONSTRAINT principal_name
    FOREIGN KEY (principal_name)
    REFERENCES principals(principal_name)
);

CREATE TABLE Students(
    student_name VARCHAR(200) PRIMARY KEY,
    grade_level INT,
    home_address VARCHAR(200),
    emergency_phone_contact VARCHAR(200),
    school_name VARCHAR(200),

    CONSTRAINT school_name
    FOREIGN KEY (school_name)
    REFERENCES Schools(school_name)
);