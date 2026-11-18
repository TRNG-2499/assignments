Create Table part.Department (
	department_id Serial primary key, 
	department_name varchar(200), 
	location varchar(100)
);

Create Table part.Doctor (
	docter_id serial primary key, 
	department_id integer, 
	first_name varchar(100), 
	last_name varchar(100), 
	specialty varchar(100),
	phone varchar(20),
	constraint doctor_fk foreign key (department_id) references part.department(department_id)
);

Create Table part.Patient (
	patient_id Serial primary key, 
	first_name varchar(100),
	last_name varchar(100), 
	date_of_brith Date, 
	phone varchar(20),
	address varchar(255)
);

Create Table part.Appointment (
	appointment_id serial primary key, 
	patient_id integer, 
	doctor_id integer, 
	appointment_date Date, 
	appointment_time Time, 
	reason varchar(255), 
	status varchar(50), 
	constraint appointment_patient_fk foreign key (patient_id) references part.Patient(patient_id),
	constraint appointment_doctor_fk foreign key (doctor_id) references part.Doctor(doctor_id)
);

Create Table part.Prescription (
	prescription_id serial primary key, 
	appointment_id integer, 
	medication_name varchar(100), 
	dosage varchar(100), 
	instructions varchar(255), 
	constraint prescription_fk foreign key (appointment_id) references part.Appointment(appointment_id)
);

Create Table part.Room (
	room_id serial primary key, 
	department_id integer, 
	room_number varchar(20), 
	room_type varchar(100),
	is_available boolean, 
	constraint room_fk foreign key (department_id) references part.Department(department_id)
);
