SELECT Sport.sport_name 
FROM Player
	LEFT JOIN Team ON Player.team_id = Team.team_id
	LEFT JOIN Sport ON Team.sport_id = Sport.sport_id
ORDER BY Player.player_salary DESC 
LIMIT 1;