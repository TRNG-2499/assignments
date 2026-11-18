CREATE TABLE Principle (
    employee_id varchar(30) PRIMARY KEY,
    name varchar(30) NOT NULL,
    hire_date date NOT NULL,
    salary int
);

CREATE TABLE School (
    name varchar(25) NOT NULL,
    principle_id varchar(30),
    school_id int primary key,

    constraint fk_principle_id foreign key
                    (principle_id) references Principle(employee_id)
);

CREATE TABLE Student (
    name varchar(30) NOT NULL,
    grade varchar(2) NOT NULL CHECK ( grade >= 1 AND grade <= 12 ),
    home_address varchar(30) NOT NULL,
    emergency_contact int NOT NULL,
    school_id varchar(25),
    school_name varchar(25) references School(name),

    constraint fk_school_name foreign key
                     (school_id) references School(school_id)

);