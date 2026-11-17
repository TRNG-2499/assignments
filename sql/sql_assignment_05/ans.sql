CREATE TABLE Principal (
    principal_id SERIAL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    hire_date    DATE NOT NULL,
    salary       NUMERIC(10, 2)
);

CREATE TABLE School (
    school_id    SERIAL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    principal_id INT NOT NULL UNIQUE,
    FOREIGN KEY (principal_id) REFERENCES Principal(principal_id)
);

CREATE TABLE Student (
    student_id              SERIAL PRIMARY KEY,
    name                    VARCHAR(100) NOT NULL,
    grade_level             VARCHAR(10) NOT NULL,
    home_address            VARCHAR(200),
    emergency_contact_phone VARCHAR(20),
    school_id               INT NOT NULL,
    FOREIGN KEY (school_id) REFERENCES School(school_id)
);