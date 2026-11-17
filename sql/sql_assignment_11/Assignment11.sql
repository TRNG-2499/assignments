-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  SELECT *
  FROM books
  WHERE (publication > 1900 AND publication < 1950)
  