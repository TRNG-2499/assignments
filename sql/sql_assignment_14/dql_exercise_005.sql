SELECT sport_name FROM sports_league.sport
	WHERE sport_id = (
	SELECT sport_id FROM sports_league.team 
	WHERE team_id = (
	Select team_id FROM sports_league.player
	WHERE player_salary = ( 
	SELECT MAX(player_salary) FROM sports_league.player)));
	
	