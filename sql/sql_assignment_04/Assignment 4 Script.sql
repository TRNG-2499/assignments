CREATE TABLE Department(
department_id INT PRIMARY KEY,
department_name VARCHAR(100),
location VARCHAR(500)
);

CREATE TABLE Doctor(
doctor_id INT PRIMARY KEY,
department_ID INT REFERENCES Department(department_id),
first_name VARCHAR(50),
last_name VARCHAR(50), 
specialty VARCHAR(100),
phone VARCHAR(20)
);

CREATE TABLE Room(
room_id INT PRIMARY KEY,
department_id INT REFERENCES Department(department_id),
room_number VARCHAR(10),
room_type VARCHAR(100),
is_available BOOLEAN
);

CREATE TABLE Patient(
patient_id INT PRIMARY KEY,
first_name VARCHAR(50),
last_name VARCHAR(50),
date_of_birth VARCHAR(10),
phone VARCHAR(20),
address VARCHAR(500)
);

CREATE TABLE Appointment(
appointment_id INT PRIMARY KEY,
patient_id INT REFERENCES Patient(patient_id),
docker_id INT REFERENCES Doctor(doctor_id),
appointment_date DATE,
appointment_time TIME,
reason VARCHAR(500),
status VARCHAR(20)
);

CREATE TABLE Prescription(
prescription_id INT PRIMARY KEY,
appointment_id INT REFERENCES Appointment(appointment_id),
medication_name VARCHAR(100),
dosage VARCHAR(50),
instructions VARCHAR(500)
);