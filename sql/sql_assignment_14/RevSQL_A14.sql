SELECT sport_name FROM Sport
JOIN Team ON Sport.sport_id = Team.sport_id
JOIN Player ON Team.team_id = Player.team_id
ORDER BY player_salary DESC LIMIT 1;