-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  SELECT p.player_name
  FROM player p
  JOIN Team t ON p.team_id = t.team_id
  JOIN Sport s ON t.sport_id = s.sport_id
  WHERE s.sport_name = 'Foot Ball'
  AND p.player_salary > 20000;
  