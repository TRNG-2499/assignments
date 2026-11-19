SELECT s.sport_name
FROM Player p
JOIN Team t  ON p.team_id  = t.team_id
JOIN Sport s ON t.sport_id = s.sport_id
ORDER BY p."player Salary" DESC
LIMIT 1;