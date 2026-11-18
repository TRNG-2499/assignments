-- Tablespace: pg_default

-- DROP TABLESPACE IF EXISTS pg_default;

ALTER TABLESPACE pg_default
  OWNER TO postgres;

  SELECT s.sport_name
  FROM player p
  JOIN Team t ON p.team_id = t.team_id
  JOIN Sport s ON t.sport_id = s.sport_id
  WHERE p.player_salary = (SELECT MAX(player_salary) FROM player);
  
  