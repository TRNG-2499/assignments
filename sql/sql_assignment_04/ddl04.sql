CREATE TABLE Department(
    department_id INT NOT NULL,
    department_name VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    CONSTRAINT pk_department PRIMARY KEY (department_id)
);

CREATE TABLE Patient(
    patient_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    phone VARCHAR(20),
    address VARCHAR(255)
    CONSTRAINT pk_patient PRIMARY KEY (patient_id)
);

CREATE TABLE Doctor(
    doctor_id INT NOT NULL,
    department_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    specialty VARCHAR(100),
    phone VARCHAR(20),
    CONSTRAINT pk_doctor PRIMARY KEY (doctor_id),
    CONSTRAINT fk_doctor FOREIGN KEY (department_id)
    REFERENCES Department (department_id)

);

CREATE TABLE Room(
    room_id INT NOT NULL,
    department_id  INT NOT NULL,
    room_number VARCHAR(10) NOT NULL,
    room_type VARCHAR(50),
    is_avaliable BOOLEAN DEFAULT TRUE,
    CONSTRAINT pk_roomPRIMARY KEY (room_id),
    CONSTRAINT fk_room_department FOREIGN KEY (department_id)
    REFERENCES Department (department_id)
);

CREATE TABLE Appointment(
    appointment_id    INT          NOT NULL,
    patient_id        INT          NOT NULL,
    doctor_id         INT          NOT NULL,
    appointment_date  DATE         NOT NULL,
    appointment_time  TIME         NOT NULL,
    reason            VARCHAR(255),
    status            VARCHAR(20),
    CONSTRAINT pk_appointment PRIMARY KEY (appointment_id),
    CONSTRAINT fk_appointment_patient FOREIGN KEY (patient_id)
    REFERENCES Patient (patient_id),
    CONSTRAINT fk_appointment_doctor FOREIGN KEY (doctor_id)
    REFERENCES Doctor (doctor_id)

);

CREATE TABLE Prescription (
    prescription_id INT NOT NULL,
    appointment_id INT NOT NULL,
    medication_name  VARCHAR(100) NOT NULL,
    dosage VARCHAR(50),
    instructions VARCHAR(255),
    CONSTRAINT pk_prescription PRIMARY KEY (prescription_id),
    CONSTRAINT fk_prescription_appointment FOREIGN KEY (appointment_id)
    REFERENCES Appointment (appointment_id)
);