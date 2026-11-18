-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  SELECT d.first_name, d.last_name, d.doctor_id
  FROM doctor d
  LEFT JOIN appointment a ON d.doctor_id = a.doctor_id
  WHERE a.doctor_id IS NULL;
  