SELECT player_name, player_salary FROM sports_league.player
	WHERE team_id IN (
	SELECT team_id FROM sports_league.team 
	WHERE sport_id IN (
	SELECT sport_id FROM sports_league.sport 
	WHERE sport_name = 'Foot Ball'))
	AND player_salary > 200000;
