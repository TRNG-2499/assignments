CREATE SCHEMA hospital;

CREATE TABLE hospital.Department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    location VARCHAR(100)
);

CREATE TABLE hospital.Patient (
    patient_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    phone VARCHAR(20),
    address VARCHAR(255)
);

CREATE TABLE hospital.Doctor (
    doctor_id INT PRIMARY KEY,
    department_id INT NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    speciality VARCHAR(100),
    phone VARCHAR(20),
    FOREIGN KEY (department_id) REFERENCES hospital.Department(department_id)
);

CREATE TABLE hospital.Room (
    room_id INT PRIMARY KEY,
    department_id INT NOT NULL,
    room_number VARCHAR(20) NOT NULL,
    room_type VARCHAR(50),
    is_available BOOLEAN DEFAULT TRUE
);

CREATE TABLE hospital.Appointment (
    appointment_id INT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(255),
    status VARCHAR (30),
    FOREIGN KEY (patient_id) REFERENCES hospital.Patient(patient_id),
    FOREIGN KEY (doctor_id)  REFERENCES hospital.Doctor(doctor_id)
)

CREATE TABLE hospital.Prescription (
    prescription_id INT PRIMARY_KEY,
    appointment_id INT NOT NULL,
    medication_name VARCHAR(100) NOT NULL,
    dosage VARCHAR(50),
    instructions VARCHAR(255),
    FOREIGN KEY (appointment_id) REFERENCES hospital.Appointment(appointment_id)
)