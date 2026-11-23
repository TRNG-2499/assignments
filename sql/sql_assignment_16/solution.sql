/*
DROP TABLE Department CASCADE;
DROP TABLE Doctor CASCADE;
DROP TABLE Appointment CASCADE;
TRUNCATE TABLE Patient CASCADE;

CREATE TABLE Department (
	department_id SERIAL PRIMARY KEY,
	department_name VARCHAR(20),
	location VARCHAR(20)
);

CREATE TABLE Doctor (
	doctor_id SERIAL PRIMARY KEY,
	department_id SERIAL REFERENCES Department(department_id),
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	speciality VARCHAR(20),
	phone VARCHAR(8)
);

CREATE TABLE Appointment (
	appointment_id SERIAL PRIMARY KEY,
	patient_id INTEGER REFERENCES Patient(patient_id),
	doctor_id SERIAL REFERENCES Doctor(doctor_id),
	appointment_date DATE,
	appointment_time TIME,
	reason VARCHAR(100),
	status VARCHAR(12)
);

INSERT INTO Department (department_id, department_name, location) VALUES (1, 'Cardiology', 'Building A');
INSERT INTO Department (department_id, department_name, location) VALUES (2, 'Neurology', 'Building B');
INSERT INTO Department (department_id, department_name, location) VALUES (3, 'Orthopedics', 'Building C');
INSERT INTO Department (department_id, department_name, location) VALUES (4, 'Pediatrics', 'Building D');

INSERT INTO Doctor (department_id, first_name, last_name, speciality, phone) VALUES (1, 'James', 'Mercer', 'Cariologist', '555-1001');
INSERT INTO Doctor (department_id, first_name, last_name, speciality, phone) VALUES (1, 'Sandra', 'Yue', 'Cardiologist', '555-1002');
INSERT INTO Doctor (department_id, first_name, last_name, speciality, phone) VALUES (2, 'Omar', 'Haddad', 'Neurologist', '555-1003');
INSERT INTO Doctor (department_id, first_name, last_name, speciality, phone) VALUES (2, 'Priya', 'Neir', 'Neurologist', '555-1004');
INSERT INTO Doctor (department_id, first_name, last_name, speciality, phone) VALUES (3, 'Carlos', 'Reyes', 'Orthopedic Surgeon', '555-1005');
INSERT INTO Doctor (department_id, first_name, last_name, speciality, phone) VALUES (4, 'Beth', 'Olsen', 'Pediatrician', '555-1006');
INSERT INTO Doctor (department_id, first_name, last_name, speciality, phone) VALUES (4, 'Tom', 'Finch', 'Pediatrician', '555-1007');

INSERT INTO Patient VALUES (1, 'Gerald', 'Perks', '2012-02-9', '456-5551', 'Drake Avenue 1');
INSERT INTO Patient VALUES (2, 'Edwin', 'Hanks', '2012-03-14', '456-5552', 'Drake Avenue 2');
INSERT INTO Patient VALUES (3, 'Will', 'Taffer', '2012-09-5', '456-5553', 'Drake Avenue 3');
INSERT INTO Patient VALUES (4, 'Flores', 'Diane', '2012-06-19', '456-5554', 'Drake Avenue 4');
INSERT INTO Patient VALUES (5, 'Juniper', 'Groves', '2012-12-29', '456-5555', 'Drake Avenue 5');

INSERT INTO Appointment (patient_id, doctor_id, appointment_date, appointment_time, reason, status) VALUES (1, 1, '2025-03-10', '09:00', 'Chest pain', 'Completed');
INSERT INTO Appointment (patient_id, doctor_id, appointment_date, appointment_time, reason, status) VALUES (2, 3, '2025-03-11', '10:30', 'Migraines', 'Completed');
INSERT INTO Appointment (patient_id, doctor_id, appointment_date, appointment_time, reason, status) VALUES (3, 1, '2025-01-12', '14:00', 'Follow-up', 'Scheduled');
INSERT INTO Appointment (patient_id, doctor_id, appointment_date, appointment_time, reason, status) VALUES (4, 5, '2025-03-13', '11:00', 'Knee injury', 'Scheduled');
INSERT INTO Appointment (patient_id, doctor_id, appointment_date, appointment_time, reason, status) VALUES (5, 2, '2025-03-14', '09:30', 'Annual check', 'Scheduled');
INSERT INTO Appointment (patient_id, doctor_id, appointment_date, appointment_time, reason, status) VALUES (1, 4, '2025-03-15', '13:00', 'Headaches', 'Scheduled');

SELECT * FROM Patient;
*/
SELECT * FROM Doctor d WHERE (SELECT COUNT(*) FROM Appointment a WHERE a.doctor_id = d.doctor_id) <= 0;