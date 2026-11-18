SELECT Player.player_id, Player.player_name FROM Player
JOIN Team ON Player.team_id=Team.team_id
JOIN Sport ON Team.sport_id=Sport.sport_id
WHERE Player.player_Salary > 200000
AND Sport.sport_name='Foot Ball';