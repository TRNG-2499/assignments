SELECT DISTINCT sport_name
FROM Sport s
JOIN Team t ON t.sport_id = s.sport_id
JOIN Player p ON t.team_id = p.team_id
WHERE salary IN (
	SELECT MAX(salary)
	FROM Player
)