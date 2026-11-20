
-- Exercise
--SQL statement that returns the names of all doctors who have no appointments at all in the Appointment table.

SELECT d.first_name, d.last_name FROM doctor d
LEFT JOIN appointment a
ON d.doctor_id = a.doctor_id AND a.status = 'Scheduled'
WHERE a.appointment_id IS NULL; 

CREATE TABLE department (
    department_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL
);



CREATE TABLE doctor (
    doctor_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    department_id INT NOT NULL REFERENCES department(department_id),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

CREATE TABLE appointment (
    appointment_id INT GENERATED ALWAYS AS IDENTITY (START WITH 101 INCREMENT BY 1) PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL REFERENCES doctor(doctor_id),
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    reason VARCHAR(200) NOT NULL,
    status VARCHAR(50) NOT NULL
);

INSERT INTO department (department_name, location) VALUES
    ('Cardiology', 'Building A'),
    ('Neurology', 'Building B'),
    ('Orthopedics', 'Building C'),
    ('Pediatrics', 'Building D');
SELECT * FROM department;


INSERT INTO doctor (department_id, first_name, last_name, specialty, phone) VALUES
    (1, 'James', 'Mercer', 'Cardiologist', '555-1001'),
    (1, 'Sandra', 'Yue', 'Cardiologist', '555-1002'),
    (2, 'Omar', 'Haddad', 'Neurologist', '555-1003'),
    (2, 'Priya', 'Nair', 'Neurologist', '555-1004'),
    (3, 'Carlos', 'Reyes', 'Orthopedic Surgeon', '555-1005'),
    (4, 'Beth', 'Olsen', 'Pediatrician', '555-1006'),
    (4, 'Tom', 'Finch', 'Pediatrician', '555-1007');

SELECT * FROM doctor;	

INSERT INTO appointment (patient_id, doctor_id, appointment_date, appointment_time, reason, status) VALUES
    (1, 1, '2025-03-10', '09:00', 'Chest pain', 'Completed'),
    (2, 3, '2025-03-11', '10:30', 'Migraines', 'Completed'),
    (3, 1, '2025-03-12', '14:00', 'Follow-up', 'Scheduled'),
    (4, 5, '2025-03-13', '11:00', 'Knee injury', 'Scheduled'),
    (5, 2, '2025-03-14', '09:30', 'Annual check', 'Scheduled'),
    (1, 4, '2025-03-15', '13:00', 'Headaches', 'Scheduled');	

SELECT * FROM appointment;
	