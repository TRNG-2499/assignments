CREATE TABLE Department (
    department_id INTEGER PRIMARY KEY,
    department_name VARCHAR(100),
    location VARCHAR(100)
);

CREATE TABLE Patient (
    patient_id INTEGER PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_of_birth DATE,
    phone VARCHAR(20),
    address VARCHAR(50)
);

CREATE TABLE Doctor (
    doctor_id INTEGER PRIMARY KEY,
    department_id INTEGER NOT NULL REFERENCES Department(department_id),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    speciality VARCHAR(50),
    phone VARCHAR(20)
);

CREATE TABLE Appointment (
    appointment_id INTEGER PRIMARY KEY,
    patient_id INTEGER NOT NULL REFERENCES Patient(patient_id),
    doctor_id INTEGER NOT NULL REFERENCES Doctor(doctor_id),
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(100),
    status VARCHAR(100)
);

CREATE TABLE Prescription (
    prescription_id INTEGER PRIMARY KEY,
    appointment_id INTEGER NOT NULL REFERENCES Appointment(appointment_id),
    medication_name VARCHAR(50),
    dosage VARCHAR(50),
    instructions VARCHAR(100)
);

CREATE TABLE Room (
    room_id INTEGER PRIMARY KEY,
    department_id INTEGER NOT NULL REFERENCES Department(department_id),
    room_number VARCHAR(10),
    room_type VARCHAR(20),
    is_available BOOLEAN
);