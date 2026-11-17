-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  UPDATE books
  SET page_count = 220
  WHERE (title = 'Slaughterhouse-Five');