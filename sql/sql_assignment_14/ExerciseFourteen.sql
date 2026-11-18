SELECT sport_name, player_name FROM Player
JOIN team ON player.team_id = team.team_id
JOIN sport ON sport.sport_id = team.sport_id
ORDER BY player_salary DESC LIMIT 1;
