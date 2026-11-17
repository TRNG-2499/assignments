DROP TABLE IF EXISTS Department;
DROP TABLE IF EXISTS Doctor;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS Appointment;
DROP TABLE IF EXISTS Patient;
DROP TABLE IF EXISTS Prescription;

CREATE TABLE Department (
    department_id INTEGER PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    location VARCHAR(100)
);

CREATE TABLE Doctor (
    doctor_id INTEGER PRIMARY KEY,
    department_id VARCHAR(100) NOT NULL REFERENCES Department(department_id),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    specialty VARCHAR(100),
    phone VARCHAR(25) NOT NULL
);

CREATE TABLE Room (
    room_id INTEGER PRIMARY KEY,
    department_id INTEGER NOT NULL REFERENCES Department(department_id),
    room_number VARCHAR(100) NOT NULL,
    room_type VARCHAR(100),
    is_available BOOLEAN
);

CREATE TABLE Appointment (
    appointment_id INTEGER PRIMARY KEY,
    patient_id INTEGER NOT NULL REFERENCES Patient(patient_id),
    doctor_id INTEGER NOT NULL REFERENCES Doctor(doctor_id),
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    reason VARCHAR(200),
    status VARCHAR(100)
);

CREATE TABLE Patient (
    patient_id INTEGER PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    phone VARCHAR(25) NOT NULL,
    address VARCHAR(100)
);

CREATE TABLE Prescription (
    prescription_id INTEGER PRIMARY KEY,
    appointment_id INTEGER NOT NULL REFERENCES Appointment(appointment_id),
    medication_name VARCHAR(100) NOT NULL,
    dosage VARCHAR(100) NOT NULL,
    instructions VARCHAR(500)
);