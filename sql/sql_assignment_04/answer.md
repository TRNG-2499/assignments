CREATE TABLE  Department(
    department_id Int primary key,
    department_name varChar(50),
    location varChar(50)
);

CREATE TABLE Doctor(
    doctor_id INT PRIMARY KEY,
    department_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    specialty VARCHAR(50),
    phone VARCHAR(50),
    CONSTRAINT fk_department 
        FOREIGN KEY (department_id)
        REFERENCES Department(department_id)
);

CREATE TABLE Appointment(
    appointment_id INT PRIMARY KEY,
    patient_id INT,
    doctor_id INT, 
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(50),
    status VARCHAR(50),
    CONSTRAINT fk_patient
        FOREIGN KEY (patient_id)
        REFERENCEs Patien(patient_id),
    CONSTRAINT fk_doctor
        FOREIGN KEY (doctor_id)
        REFERENCEs Doctor(doctor_id)

);
CREATE TABLE Patient (
    patient_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    date_of_birth DATE,
    phone VARCHAR(50),
    address VARCHAR(50)
);

CREATE TABLE Prescription (
    prescription_id INT PRIMARY KEY,
    appointment_id INT,
    medication_name VARCHAR(50),
    dosage VARCHAR(50),
    instructions VARCHAR(50),
    CONSTRAINT fk_appointment
        FOREIGN KEY (appointment_id)
        REFERENCEs Appointment(appointment_id)

);


CREATE TABLE Room (
    room_id INT PRIMARY KEY,
    department_id INT,
    room_number VARCHAR(50),
    room_type VARCHAR(50),
    is_available BOOLEAN,
    CONSTRAINT fk_room_department
        FOREIGN KEY (department_id)
        REFERENCES Department(department_id)
);