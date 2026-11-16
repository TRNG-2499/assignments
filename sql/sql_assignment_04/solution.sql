CREATE TABLE Department(
    department_id INT PRIMARY KEY,
    department_name VARCHAR(200),
    "location" VARCHAR(200)
);

CREATE TABLE Doctor(
    doctor_id INT PRIMARY KEY,
    department_id INT,
    first_name VARCHAR(200),
    last_name VARCHAR(200),
    specialty VARCHAR(200),
    phone VARCHAR(200),

    CONSTRAINT department_id
    FOREIGN KEY (department_id)
    REFERENCES Department(department_id)
);

CREATE TABLE Patient(
    patient_id INT PRIMARY KEY,
    first_name VARCHAR(200),
    last_name VARCHAR(200),
    date_of_birth DATE,
    phone VARCHAR(200),
    "address" VARCHAR(200)
);

CREATE TABLE Appointment(
    appointment_id INT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    appointment_date TIME,
    reason VARCHAR(200),
    "status" VARCHAR(200),

    CONSTRAINT patient_id
    FOREIGN KEY (patient_id)
    REFERENCES Patient(patient_id),
    
    CONSTRAINT doctor_id
    FOREIGN KEY (doctor_id)
    REFERENCES Doctor(doctor_id)
);

CREATE TABLE Prescription(
    prescription_id INT PRIMARY KEY,
    appointment_id INT,
    medication_name VARCHAR(200),
    dosage VARCHAR(200),
    instructions VARCHAR(200),

    CONSTRAINT appointment_id
    FOREIGN KEY (appointment_id)
    REFERENCES Appointment(appointment_id)
);

CREATE TABLE Room(
    room_id INT PRIMARY KEY,
    department_id INT,
    room_number VARCHAR(200),
    room_type VARCHAR(200),
    is_available BOOLEAN,

    CONSTRAINT department_id 
    FOREIGN KEY (department_id)
    REFERENCES Department(department_id)
);