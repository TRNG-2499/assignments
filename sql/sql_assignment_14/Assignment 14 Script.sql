SELECT s.sport_name, MAX(p.player_salary) AS sport_max_salary
FROM Player AS p JOIN Team AS t ON p.team_id = t.team_id
JOIN Sport AS s ON t.sport_id = s.sport_id
GROUP BY s.sport_name
ORDER BY sport_max_salary DESC
LIMIT 1;