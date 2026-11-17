-- drop tables in this specific order, depends on hierarchy of calls
DROP TABLE IF EXISTS Prescription;
DROP TABLE IF EXISTS Appointment;
DROP TABLE IF EXISTS Patient;
DROP TABLE IF EXISTS Doctor;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS Department;

CREATE TABLE Department(
	department_id int PRIMARY KEY,
	department_name varchar,
	location varchar
);

CREATE TABLE Room(
	room_id int PRIMARY KEY,
	department_id int REFERENCES Department(department_id),
	room_number varchar,
	room_type varchar,
	is_available boolean
);

CREATE TABLE Patient(
	patient_id int PRIMARY KEY,
	first_name varchar,
	last_name varchar,
	date_of_birth Date,
	phone varchar,
	address varchar
);

CREATE TABLE Doctor(
	doctor_id int PRIMARY KEY,
	department_id int REFERENCES Department(department_id),
	first_name varchar,
	last_name varchar,
	specialty varchar,
	phone varchar
);

CREATE TABLE Appointment(
	appointment_id int PRIMARY KEY,
	patient_id int REFERENCES Patient(patient_id),
	doctor_id int REFERENCES Doctor(doctor_id),
	appointment_date Date,
	appointment_Time Time,
	reason varchar,
	status varchar
);

CREATE TABLE Prescription(
	prescription_id int PRIMARY KEY,
	appointment_id int REFERENCES Appointment(appointment_id),
	medication_name varchar,
	dosage varchar,
	instructions varchar
);