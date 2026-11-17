CREATE TABLE Principle (
principle_id SERIAL PRIMARY KEY,
principle_name VARCHAR(100),
principle_hire_date DATE,
principle_salary REAL
);

CREATE TABLE School (
school_id SERIAL PRIMARY KEY,
school_name VARCHAR(100),
school_principle_id INT REFERENCES Principle (principle_id)
);

CREATE TABLE Students (
student_id SERIAL PRIMARY KEY,
student_name VARCHAR(100),
student_grade INT,
student_home_address VARCHAR(100),
student_emergency_phone_number VARCHAR(50),
student_school_id INT REFERENCES School (school_id)
);