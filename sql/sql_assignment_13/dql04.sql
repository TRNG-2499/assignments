SELECT p.player_id, p.player_name, t.team_name, p."player Salary"
FROM Player p
JOIN Team t ON p.team_id = t.team_id
JOIN Sport s ON t.sport_id = s.sport_id
WHERE s.sport_name = 'Football'
AND p."player Salary" > 200000;