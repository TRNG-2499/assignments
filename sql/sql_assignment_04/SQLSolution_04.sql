CREATE SCHEMA hospital;

CREATE TABLE hospital.department (
    department_id INTEGER PRIMARY KEY,
    department_name VARCHAR(100),
    location VARCHAR(100)
);

CREATE TABLE hospital.doctor (
    doctor_id INTEGER PRIMARY KEY,
    department_id INTEGER REFERENCES hospital.department(department_id),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    specialty VARCHAR(100),
    phone VARCHAR(20)
);

CREATE TABLE hospital.patient (
    patient_id INTEGER PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    date_of_birth DATE,
    phone VARCHAR(20),
    address VARCHAR(100)
);

CREATE TABLE hospital.appointment (
    appointment_id INTEGER PRIMARY KEY,
    patient_id INTEGER REFERENCES hospital.patient(patient_id),
    doctor_id INTEGER REFERENCES hospital.doctor(doctor_id),
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(250),
    status VARCHAR(50)
);

CREATE TABLE hospital.prescription (
    prescription_id INTEGER PRIMARY KEY,
    appointment_id INTEGER REFERENCES hospital.appointment(appointment_id),
    medication_name VARCHAR(100),
    dosage VARCHAR(100),
    instructions VARCHAR(250)
);

CREATE TABLE hospital.room(
    room_id INTEGER PRIMARY KEY,
    department_id INTEGER REFERENCES hospital.department(department_id),
    room_number VARCHAR(10),
    room_type VARCHAR(50),
    is_available BOOLEAN
);