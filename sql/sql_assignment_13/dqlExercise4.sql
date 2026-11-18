SELECT player_name, player_salary
FROM Player JOIN Team ON Player.team_id = Team.team_id
JOIN Sport ON Team.sport.id = Sport.sport.id
WHERE sport_name = 'Foot Ball' AND player_salary > 200000;