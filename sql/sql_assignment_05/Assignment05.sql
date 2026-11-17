-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  CREATE TABLE Principles (
	principle_name text PRIMARY KEY,
	date int,
	salary int
  );

  CREATE TABLE Schools (
	school_name text PRIMARY KEY,
	principle_name text,
	CONSTRAINT principle
        FOREIGN KEY (principle_name) REFERENCES Principles(principle_name)
  );

  CREATE TABLE Students (
	student_name text, 
	grade_level text,
	home_address text,
	emergency_contact_number int,
	school_name text, 
	CONSTRAINT school
        FOREIGN KEY (school_name) REFERENCES Schools(school_name)
  );