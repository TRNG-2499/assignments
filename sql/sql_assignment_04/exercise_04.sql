CREATE TABLE Department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100),
    location VARCHAR(100)
);

CREATE TABLE Doctor (
    doctor_id INT PRIMARY KEY,
    department_id INT NOT NULL REFERENCES Department(department_id),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    specialty VARCHAR(100),
    phone VARCHAR(25)
);

CREATE TABLE Patient (
    patient_id INT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_of_birth DATE,
    phone VARCHAR(25),
    address VARCHAR(255)
);

CREATE TABLE Appointment (
    appointment_id INT PRIMARY KEY,
    patient_id INT NOT NULL REFERENCES Patient(patient_id),
    doctor_id INT NOT NULL REFERENCES Doctor(doctor_id),
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(255),
    status VARCHAR(50)
);

CREATE TABLE Prescription (
    prescription_id INT PRIMARY KEY,
    appointment_id INT NOT NULL REFERENCES Appointment(appointment_id),
    medication_name VARCHAR(100),
    dosage VARCHAR(50),
    instructions VARCHAR(255)
);

CREATE TABLE Room (
    room_id INT PRIMARY KEY,
    department_id INT NOT NULL REFERENCES Department(department_id),
    room_number VARCHAR(20),
    room_type VARCHAR(50),
    is_available BOOLEAN
);