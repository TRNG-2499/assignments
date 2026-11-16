CREATE TABLE Patient(
  PatientID SERIAL NOT NULL PRIMARY KEY,
  FirstName TEXT NOT NULL,
  LastName TEXT NOT NULL,
  DateOfBirth DATE NOT NULL,
  Phone TEXT NOT NULL,
  Address TEXT NOT NULL
);

CREATE TABLE Department(
  DepartmentID SERIAL NOT NULL PRIMARY KEY,
  DepartmentName TEXT NOT NULL,
  Location TEXT NOT NULL
);

CREATE TABLE Room(
  RoomID SERIAL NOT NULL PRIMARY KEY,
  DepartmentID INTEGER NOT NULL REFERENCES Department(DepartmentName),
  RoomNumber TEXT NOT NULL,
  RommType TEXT NOT NULL,
  IsAvailable BOOLEAN NOT NULL
);

CREATE TABLE Doctor(
  DoctorID SERIAL NOT NULL PRIMARY KEY,
  DepartmentID INTEGER NOT NULL REFERENCES Department(DepartmentName),
  FirstName TEXT NOT NULL,
  LastName TEXT NOT NULL,
  Specialty TEXT NOT NULL,
  Phone TEXT NOT NULL
);

CREATE TABLE Appointment(
  AppointmentID SERIAL NOT NULL PRIMARY KEY,
  PatientID INTEGER NOT NULL REFERENCES Patient(PatientID),
  DoctorID INTEGER NOT NULL REFERENCES Doctor(DoctorID),
  AppointmentDate DATE NOT NULL,
  AppointmentTime TIME NOT NULL,
  Reason TEXT NOT NULL,
  Status TEXT NOT NULL
);

CREATE TABLE Prescription(
  PrescriptionID SERIAL NOT NULL PRIMARY KEY,
  AppointmentID INTEGER NOT NULL REFERENCES Appointment(AppointmentID),
  MedicationName TEXT NOT NULL,
  Dosage TEXT NOT NULL,
  Instructions TEXT NOT NULL
);
