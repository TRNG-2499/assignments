SELECT Team.sport_id FROM Team JOIN Player ON Team.team_id = Player.team_id
WHERE Player.'player Salary' = (SELECT MAX('player Salary') FROM Player);