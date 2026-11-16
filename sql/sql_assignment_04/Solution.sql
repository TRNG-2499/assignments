CREATE TABLE Department (
    department_id INTEGER PRIMARY KEY,
    department_name VARCHAR(255),
    location VARCHAR(255)
);

CREATE TABLE Doctor (
    doctor_id INTEGER PRIMARY KEY,
    department_id INTEGER,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    specialty VARCHAR(255),
    phone VARCHAR(20),
    CONSTRAINT department_fk FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

CREATE TABLE Patient (
    patient_id INTEGER PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    date_of_birth DATE,
    phone VARCHAR(20),
    address VARCHAR(255)
);

CREATE TABLE Appointment (
    appointment_id INTEGER PRIMARY KEY,
    patient_id INTEGER,
    doctor_id INTEGER,
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(255),
    status VARCHAR(255),
    CONSTRAINT patient_fk FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    CONSTRAINT doctor_fk FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE Prescription (
    prescription_id INTEGER PRIMARY KEY,
    appointment_id INTEGER,
    medication_name VARCHAR(255),
    dosage VARCHAR(255),
    instructions VARCHAR(255),
    CONSTRAINT appointment_fk FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id)
);

CREATE TABLE Room (
    room_id INTEGER PRIMARY KEY,
    department_id INTEGER REFERENCES Department(department_id),
    room_number VARCHAR(10),
    room_type VARCHAR(50),
    is_available BOOLEAN
);