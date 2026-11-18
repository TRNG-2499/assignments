SELECT p.player_name, p."player Salary"
FROM Player AS p
JOIN Team AS t ON p.team_id = t.team_id
JOIN Sport AS s ON t.sport_id = s.sport_id
WHERE s.sport_id = 40001
 AND p."player Salary" > 200000;