-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;


CREATE TABLE Department (
    department_id    INT PRIMARY KEY,
    department_name  VARCHAR(100) NOT NULL,
    location         VARCHAR(100)
);


CREATE TABLE Doctor (
    doctor_id        INT PRIMARY KEY,
    department_id    INT NOT NULL,
    first_name       VARCHAR(50) NOT NULL,
    last_name        VARCHAR(50) NOT NULL,
    specialty        VARCHAR(100),
    phone            VARCHAR(20),
    CONSTRAINT fk_doctor_department
        FOREIGN KEY (department_id) REFERENCES Department(department_id)
);


CREATE TABLE Patient (
    patient_id       INT PRIMARY KEY,
    first_name       VARCHAR(50) NOT NULL,
    last_name        VARCHAR(50) NOT NULL,
    date_of_birth    DATE NOT NULL,
    phone            VARCHAR(20),
    address          VARCHAR(255)
);


CREATE TABLE Appointment (
    appointment_id   INT PRIMARY KEY,
    patient_id       INT NOT NULL,
    doctor_id        INT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    reason           VARCHAR(255),
    status           VARCHAR(20),
    CONSTRAINT fk_appointment_patient
        FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    CONSTRAINT fk_appointment_doctor
        FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);


CREATE TABLE Prescription (
    prescription_id  INT PRIMARY KEY,
    appointment_id   INT NOT NULL,
    medication_name  VARCHAR(100) NOT NULL,
    dosage           VARCHAR(50),
    instructions     VARCHAR(255),
    CONSTRAINT fk_prescription_appointment
        FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id)
);


CREATE TABLE Room (
    room_id          INT PRIMARY KEY,
    department_id    INT NOT NULL,
    room_number      VARCHAR(20) NOT NULL,
    room_type        VARCHAR(50),
    is_available     BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_room_department
        FOREIGN KEY (department_id) REFERENCES Department(department_id)
);