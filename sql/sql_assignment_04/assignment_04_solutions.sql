CREATE SCHEMA assignment_3;

/*
Create tables
*/
BEGIN TRANSACTION;
	CREATE TABLE assignment_3.Department (
		department_id INTEGER PRIMARY KEY,
		department_name VARCHAR(100),
		location VARCHAR(100)
	);
	CREATE TABLE assignment_3.Doctor (
		doctor_id INTEGER PRIMARY KEY,
		department_id INTEGER REFERENCES assignment_3.Department(department_id),
		first_name VARCHAR(20),
		last_name VARCHAR(20),
		specialty VARCHAR(50),
		phone VARCHAR(50)
	);
	CREATE TABLE assignment_3.Patient (
		patient_id INTEGER PRIMARY KEY,
		first_name VARCHAR(20),
		last_name VARCHAR(20),
		date_of_birth DATE,
		phone VARCHAR(20),
		address VARCHAR(100)
	);
	CREATE TABLE assignment_3.Appointment (
		appointment_id INTEGER PRIMARY KEY,
		patient_id INTEGER REFERENCES assignment_3.Patient(patient_id),
		doctor_id INTEGER REFERENCES assignment_3.Doctor(doctor_id),
		appointment_date DATE,
		appointment_time TIME,
		reason VARCHAR(1000),
		status VARCHAR(30)
	);
	CREATE TABLE assignment_3.Prescription (
		prescription_id INTEGER PRIMARY KEY,
		appointment_id INTEGER REFERENCES assignment_3.Appointment(appointment_id),
		medication_name VARCHAR(50),
		dosage VARCHAR(50),
		instructions VARCHAR(1000)
	);
	CREATE TABLE assignment_3.Room (
		room_id INTEGER PRIMARY KEY,
		department_id INTEGER REFERENCES assignment_3.Department(department_id),
		room_number VARCHAR(20),
		room_type VARCHAR(20),
		is_available BOOLEAN
	);
COMMIT;
SELECT * FROM assignment_3.Room;

DROP SCHEMA assignment_3 CASCADE;