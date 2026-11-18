CREATE TABLE Principal(
    principal_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    hire_date DATE NOT NULL,
    salary NUMERIC(10,2),
    CONSTRAINT pk_principal PRIMARY KEY (principal_id)
);

CREATE TABLE School(
    school_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    principal_id  INT NOT NULL,
    CONSTRAINT pk_school PRIMARY KEY (school_id),
    CONSTRAINT uq_school_principal UNIQUE (principal_id),
    CONSTRAINT fk_school_principal FOREIGN KEY (principal_id)
    REFERENCES Principal (principal_id)
);

CREATE TABLE Student(
    student_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    grade_level INT NOT NULL,
    home_address VARCHAR(255),
    emergency_phone VARCHAR(20) NOT NULL,
    school_id  INT NOT NULL,
    CONSTRAINT pk_student PRIMARY KEY (student_id),
    CONSTRAINT chk_student_grade CHECK (grade_level BETWEEN 0 AND 12),
    CONSTRAINT fk_student_school FOREIGN KEY (school_id)
    REFERENCES School (school_id)
);