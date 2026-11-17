--note: FK (foreign keys) depend on previously created tables
CREATE TABLE Principals(
	principal_id INT PRIMARY KEY,
	name VARCHAR(50),
	hire_date DATE,
	salary NUMERIC (10, 2)
);

CREATE TABLE Schools (
	school_id INT PRIMARY KEY,
	name VARCHAR(50),
	principal_id INT UNIQUE NOT NULL,
	FOREIGN KEY (principal_id)
		REFERENCES Principals(principal_id)
);

CREATE TABLE Students (
	student_id INT PRIMARY KEY,
	name VARCHAR(50),
	grade_level VARCHAR(10),
	home_address VARCHAR(100),
	emergency_contact_phone_number VARCHAR(25),
	school_id INT,
	FOREIGN KEY (school_id)
		REFERENCES Schools(school_id)
);