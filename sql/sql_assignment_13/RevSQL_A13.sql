SELECT player_name, player_salary, sport_name
FROM Player JOIN Team ON Player.team_id = Team.team_id
JOIN Sport ON Team.sport_id = Sport.sport_id
WHERE Player.player_salary > 200000 AND Sport.sport_name = 'Foot Ball';