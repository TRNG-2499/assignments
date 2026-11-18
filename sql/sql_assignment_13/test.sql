SELECT player_name FROM Player
JOIN Team ON Player.team_id = Team.team_id
JOIN Sport ON Team.sport_id = Sport.sport_id
WHERE
  Player.player_salary > 200000 AND
  Sport.name = 'Foot Ball';
