CREATE TABLE IF NOT EXISTS Department (
department_id int NOT NULL PRIMARY KEY,
department_name VARCHAR(120) NOT NULL,
location VARCHAR(200) NOT NULL
);

SELECT * FROM Department;

CREATE TABLE IF NOT EXISTS Doctor (
doctor_id int NOT NULL PRIMARY KEY,
department_id int NOT NULL References Department(department_id),
first_name VARCHAR(120) NOT NULL,
last_name VARCHAR(120) NOT NULL,
speciality VARCHAR(120) NOT NULL,
phone VARCHAR(120) NOT NULL
);
SELECT * FROM Doctor;
ALTER TABLE DOCTOR RENAME COLUMN speciality TO specialty;

CREATE TABLE IF NOT EXISTS Patient(
patient_id int NOT NULL PRIMARY KEY,
first_name VARCHAR(120) NOT NULL,
last_name VARCHAR(120) NOT NULL,
date_of_birth DATE NOT NULL,
phone VARCHAR(120) NOT NULL,
address VARCHAR(200) NOT NULL
);
SELECT * FROM Patient;

CREATE TABLE IF NOT EXISTS ROOM (
room_id int NOT NULL PRIMARY KEY,
department_id int NOT NULL REFERENCES Department(department_id),
room_number VARCHAR(120) NOT NULL,
room_type VARCHAR(120),
is_available boolean
);

SELECT * FROM ROOM;

--DROP TABLE Appointment;

CREATE TABLE IF NOT EXISTS Appointment(
appointment_id int NOT NULL PRIMARY KEY,
patient_id int NOT NULL REFERENCES Patient(patient_id),
doctor_id int NOT NULL REFERENCES Doctor(doctor_id),
appointment_date Date,
appointment_time Time,
reason VARCHAR(200),
status VARCHAR(200)
);
SELECT * FROM Appointment;

CREATE TABLE IF NOT EXISTS Prescription(
prescription_id int NOT NULL PRIMARY KEY,
appointment_id int NOT NULL REFERENCES Appointment(appointment_id),
medication_name VARCHAR(120) NOT NULL,
dosage VARCHAR(120) NOT NULL,
instructions VARCHAR(200)
);

SELECT * FROM Prescription;
