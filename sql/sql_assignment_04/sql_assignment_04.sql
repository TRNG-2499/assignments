CREATE TABLE Department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100),
    location VARCHAR(100)

);

CREATE TABLE Doctor (
    doctor_id INT PRIMARY KEY,
    department_id INT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    specialty VARCHAR(100),
    phone VARCHAR(20),
    FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

CREATE TABLE Room (
    room_id INT PRIMARY KEY,
    department_id INT,
    room_number VARCHAR(20),
    room_type VARCHAR(100),
    is_available BOOLEAN,
    FOREIGN KEY (department_id) REFERENCES Department(department_id)

);

CREATE TABLE Patient (
    patient_id INT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_of_birth DATE,
    phone VARCHAR(20),
    address VARCHAR(200)
);


CREATE TABLE Appointment (
    appointment_id INT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(500),
    status VARCHAR(30),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE Prescription (
    prescription_id INT PRIMARY KEY,
    appointment_id INT,
    medication_name VARCHAR(150),
    dosage VARCHAR(150),
    instructions VARCHAR(500)
    FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id)
);