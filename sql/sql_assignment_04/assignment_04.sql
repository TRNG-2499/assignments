CREATE TABLE department (
    department_id INT NOT NULL UNIQUE,
    department_name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    PRIMARY KEY (department_id)
);

CREATE TABLE patient (
    patient_id INT NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    phone VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    PRIMARY KEY (patient_id)
);

CREATE TABLE room (
    room_id INT NOT NULL UNIQUE,
    department_id INT NOT NULL,
    room_number VARCHAR(100) NOT NULL UNIQUE,
    room_type VARCHAR(100) NOT NULL,
    is_available BOOLEAN NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department (department_id),
    PRIMARY KEY (room_id)
);

CREATE TABLE doctor (
    doctor_id INT NOT NULL UNIQUE,
    department_id INT NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100) NOT NULL,
    phone VARCHAR(100),
    FOREIGN KEY (department_id) REFERENCES department (department_id),
    PRIMARY KEY (doctor_id)
);

CREATE TABLE appointment (
    appointment_id INT NOT NULL UNIQUE,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    reason VARCHAR(100) NOT NULL,
    status VARCHAR(100) NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patient (patient_id),
    FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id),
    PRIMARY KEY (appointment_id)
);

CREATE TABLE prescription (
    prescription_id INT NOT NULL UNIQUE,
    appointment_id INT NOT NULL,
    medication_name VARCHAR(100) NOT NULL,
    dosage VARCHAR(100) NOT NULL,
    instructions VARCHAR(100) NOT NULL,
    FOREIGN KEY (appointment_id) REFERENCES appointment (appointment_id),
    PRIMARY KEY (prescription_id)
);