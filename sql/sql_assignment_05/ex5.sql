CREATE TABLE Principles {
    name VARCHAR(50) PRIMARY KEY,
    hire_date DATE,
    salary INT
}

CREATE TABLE Schools {
    name VARCHAR(50) PRIMARY KEY,
    principle VARCHAR(50) UNIQUE NOT NULL,
    CONSTRAINT fk_principle
        FOREIGN KEY (principle)
        REFERENCES Principles(name)
        ON DELETE CASCADE
}

CREATE TABLE Students {
    name VARCHAR(50) PRIMARY KEY,
    grade_level SMALLINT NOT NULL,
    home_address VARCHAR(255) NOT NULL,
    emergency_phone VARCHAR(50) NOT NULL,
    school VARCHAR(50) NOT NULL,
    FOREIGN KEY school REFERENCES Schools(name)
}