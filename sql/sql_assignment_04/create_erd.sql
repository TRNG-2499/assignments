CREATE TABLE Department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100),
    location VARCHAR(100)
);

CREATE TABLE Room (
      room_id INT PRIMARY KEY,
      department_id INT NOT NULL,
      room_number VARCHAR(20),
      room_type VARCHAR(50),
      is_available BIT,

      CONSTRAINT FK_Room_Department
          FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

CREATE TABLE Doctor (
    doctor_id INT PRIMARY KEY,
    department_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    specialty VARCHAR(100) NOT NULL,
    phone VARCHAR(25) NOT NULL,

    CONSTRAINT FK_Doctor_Department
        FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

CREATE TABLE Patient (
    patient_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    phone VARCHAR(25),
    address VARCHAR(255)
);

CREATE TABLE Appointment (
     appointment_id INT PRIMARY KEY,
     patient_id INT NOT NULL,
     doctor_id INT NOT NULL,
     appointment_date DATE,
     appointment_time TIME,
     reason VARCHAR(255),
     status VARCHAR(30),

     CONSTRAINT FK_Appointment_Patient
         FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),

     CONSTRAINT FK_Appointment_Doctor
         FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE Prescription (
    prescription_id INT PRIMARY KEY,
    appointment_id INT NOT NULL,
    medication_name VARCHAR(100),
    dosage VARCHAR(100),
    instructions VARCHAR(500),

    CONSTRAINT FK_Prescription_Appointment
      FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id)
);