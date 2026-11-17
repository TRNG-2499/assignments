CREATE TABLE Department (
	department_id INT PRIMARY KEY,
	department_name VARCHAR(100),
	location VARCHAR(100)
);

CREATE TABLE Doctor (
	doctor_id INT PRIMARY KEY,
	department_id INT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	specialty VARCHAR(50),
	phone VARCHAR(25),
	FOREIGN KEY (department_id)
		REFERENCES Department(department_id)
);

CREATE TABLE Patient (
	patient_id INT PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	date_of_birth DATE,
	phone VARCHAR(25),
	address VARCHAR(100)
);

CREATE TABLE Appointment (
	appointment_id INT PRIMARY KEY,
	patient_id INT,
	doctor_id INT,
	appointment_date DATE,
	appointment_time TIME,
	reason VARCHAR(100),
	status VARCHAR(50),
	FOREIGN KEY (patient_id)
		REFERENCES Patient(patient_id),

	FOREIGN KEY (doctor_id)
		REFERENCES Doctor(doctor_id)
);

CREATE TABLE Prescription (
	prescription_id INT PRIMARY KEY,
	appointment_id INT,
	medication_name VARCHAR(50),
	dosage VARCHAR(50),
	instructions VARCHAR(200),
	FOREIGN KEY (appointment_id)
		REFERENCES Appointment(appointment_id)
);

CREATE TABLE Room (
	room_id INT PRIMARY KEY,
	department_id INT,
	room_number VARCHAR(10),
	room_type VARCHAR(30),
	is_available BOOLEAN,
	FOREIGN KEY (department_id)
		REFERENCES Department(department_id)
);