SELECT player_name 
FROM Team as t
JOIN Player as p ON t.team_id = p.team_id
WHERE t.sport_id = 40001 AND p."player Salary" > 200000;