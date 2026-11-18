SELECT player_name FROM player
JOIN team ON player.team_id = team.team_id
WHERE player_salary > 200000
AND team.sport_id = 40001;