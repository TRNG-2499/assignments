SELECT Sport.sport_name, player_name, player_salary FROM Player
JOIN Team ON Player.team_id = Team.team_id
JOIN Sport ON Team.sport_Id = Sport.sport_id
WHERE Player.player_salary = (SELECT MAX(player_salary) FROM Player);