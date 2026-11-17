CREATE TABLE department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL,
    location VARCHAR(100)
);

CREATE TABLE doctor (
    doctor_id INT PRIMARY KEY,
    department_id INT NOT NULL REFERENCES department(department_id),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    specialty VARCHAR(100),
    phone VARCHAR(11)
);

CREATE TABLE patient (
    patient_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE, -- at first i had not null but maybe i have been over using, what about john doe's
    phone VARCHAR(11),
    address VARCHAR(255)
);

CREATE TABLE room (
    room_id INT PRIMARY KEY,
    department_id INT NOT NULL REFERENCES department (department_id),
    room_number VARCHAR(4) NOT NULL,
    room_type VARCHAR(20),
    is_available BOOLEAN NOT NULL
);

CREATE TABLE appointment (
    appointment_id INT PRIMARY KEY,
    patient_id INT NOT NULL REFERENCES patient (patient_id),
    doctor_id INT NOT NULL REFERENCES doctor (doctor_id),
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    reason VARCHAR(500) NOT NULL,
    status VARCHAR(50)
);

CREATE TABLE prescription (
    prescription_id INT PRIMARY KEY,
    appointment_id INT NOT NULL REFERENCES appointment (appointment_id),
    medication_name VARCHAR(50) NOT NULL,
    dosage VARCHAR(100) NOT NULL,
    instructions VARCHAR(500)
);