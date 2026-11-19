SELECT player_name
FROM Player p
JOIN Team t ON p.team_id = t.team_id
JOIN Sport s ON t.sport_id = s.sport_id
WHERE p.salary > 200000 AND s.sport_name = 'Foot Ball'