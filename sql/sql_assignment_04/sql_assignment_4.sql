create table Department (
	department_id integer generated always as identity primary key,
	department_name varchar,
	location varchar
);

create table Doctor (
	doctor_id integer generated always as identity primary key,
	department_id integer,
	first_name varchar,
	last_name varchar,
	specialty varchar,
	phone varchar,
	foreign key(department_id) references Department(department_id)
);

create table Patient(
	patient_id integer generated always as identity primary key,
	first_name varchar,
	last_name varchar,
	date_of_birth date,
	phone varchar,
	address varchar
);

create table Appointment(
	appointment_id integer generated always as identity primary key,
	patient_id integer,
	doctor_id integer,
	appointment_date date,
	appointment_time time,
	reason varchar,
	status varchar,
	foreign key(patient_id) references Patient(patient_id),
	foreign key(doctor_id) references Doctor(doctor_id)
);

create table Prescription(
	prescription_id integer generated always as identity primary key,
	appointment_id integer,
	medication_name varchar,
	dosage varchar,
	instructions varchar,
	foreign key(appointment_id) references Appointment(appointment_id)
);

create table Room(
	room_id integer generated always as identity primary key,
	department_id integer,
	room_number varchar,
	room_type varchar,
	is_available boolean,
	foreign key(department_id) references Department(department_id)
);