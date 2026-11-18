Create Table part.Principal (
	principal_id serial primary key, 
	name varchar(100), 
	hire_date date, 
	salary decimal(10, 2)
);

Create Table part.School (
	school_id serial primary key, 
	name varchar(100), 
	principal_id integer unique not null, -- note to self: stops from having 2 schools have same princpal
	constraint school_principal_fk foreign Key (principal_id) references part.Principal(principal_id)
);

Create Table part.Student (
	student_id serial primary key, 
	name varchar(100), 
	grade_level varchar(20), 
	home_address varchar(255), 
	emergency_contact_phone varchar(20),
	school_id integer, 
	constraint student_school_fk foreign Key (school_id) references part.School(school_id)
);