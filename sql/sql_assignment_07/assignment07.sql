-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  INSERT INTO books
  VALUES (3063, 'Bermese Days',1002,1934,287);