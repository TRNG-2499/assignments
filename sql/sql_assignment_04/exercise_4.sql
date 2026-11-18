CREATE SCHEMA hospital;

CREATE TABLE hospital.department (
	department_id INT PRIMARY KEY,
	department_name VARCHAR(100),
	location VARCHAR(100)
);

CREATE TABLE hospital.room (
	room_id INT PRIMARY KEY,
	room_number VARCHAR(100),
	room_type VARCHAR(100),
	is_available BOOLEAN,
	department_id INT REFERENCES hospital.department(department_id)
);

CREATE TABLE hospital.doctor (
	doctor_id INT PRIMARY KEY,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	specialty VARCHAR(100),
	phone VARCHAR(100),
	department_id INT REFERENCES hospital.department(department_id)
);

CREATE TABLE hospital.patient (
	patient_id INT PRIMARY KEY,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	date_of_birth DATE,
	phone VARCHAR(100),
	address VARCHAR(100)
);

CREATE TABLE hospital.appointment (
	appointment_id INT PRIMARY KEY,
	appointment_date DATE,
	appointment_time TIME,
	reason VARCHAR(100),
	status VARCHAR(100),
	patient_id INT REFERENCES hospital.patient(patient_id),
	doctor_id INT REFERENCES hospital.doctor(doctor_id)
);

CREATE TABLE hospital.prescription (
	prescription_id INT PRIMARY KEY,
	medication_name VARCHAR(100),
	dosage VARCHAR(100),
	instructions VARCHAR(100),
	appointment_id INT REFERENCES hospital.appointment(appointment_id)
);
