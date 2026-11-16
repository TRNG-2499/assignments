CREATE TABLE Department (
    department_ID INT PRIMARY KEY,
    department_name VARCHAR(50),
    location VARCHAR(50)
);

CREATE TABLE Doctor (
    doctor_id INT PRIMARY KEY,
    department_id INT REFERENCES Department(department_ID),
    first_name VARCHAR(25),
    last_name VARCHAR(25),
    specialty VARCHAR(50),
    phone VARCHAR(25)
);

CREATE TABLE Room (
    room_id INT PRIMARY KEY,
    department_id INT REFERENCES Department(department_ID),
    room_number VARCHAR(20),
    room_type VARCHAR(50),
    is_available BOOLEAN
);

CREATE TABLE Patient (
    patient_id INT PRIMARY KEY,
    first_name VARCHAR(25),
    last_name VARCHAR(25),
    date_of_birth Date,
    phone VARCHAR(25),
    address VARCHAR(75)
);

CREATE TABLE Appointment (
    appointment_id INT PRIMARY KEY,
    patient_id INT REFERENCES Patient(patient_id),
    doctor_id INT REFERENCES Doctor(doctor_id),
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(100),
    status VARCHAR(50)
);

CREATE TABLE Prescription (
    prescription_id INT PRIMARY KEY,
    appointment_id INT REFERENCES Appointment(appointment_id),
    medication_name VARCHAR(50),
    dosage VARCHAR(50),
    instructions VARCHAR(100)
);