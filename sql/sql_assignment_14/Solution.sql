SELECT s.sport_name
FROM Player AS p
JOIN Team AS t ON p.team_id = t.team_id
JOIN Sport AS s ON t.sport_id = s.sport_id
ORDER BY p."player Salary" DESC
LIMIT 1;