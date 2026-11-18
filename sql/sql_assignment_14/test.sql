SELECT FIRST(Sport.sport_name) FROM Sport
JOIN Team ON Sport.sport_id = Team.sport_id
JOIN Player ON Team.team_id = Player.team_id
GROUP BY Sport.sport_id
ORDER BY MAX(Player.player_salary) DESC;
