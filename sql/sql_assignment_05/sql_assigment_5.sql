create table Principle (
	name varchar primary key,
	hire_date date,
	salary numeric(10, 2)
);

create table School (
	name varchar primary key,
	principle_name varchar,
	foreign key(principle_name) references Principle(name)
);

create table Students (
	name varchar,
	grade_level varchar check (grade_level in ('7th, 8th, 9th, 10th')),
	home_address varchar,
	emergency_contact varchar,
	school varchar,
	foreign key(school) references School(name)
);
