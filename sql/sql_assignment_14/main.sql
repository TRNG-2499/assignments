SELECT s.sport_name, p.player_name, p.player_salary FROM player p
    JOIN team t ON t.team_id = p.team_id
    JOIN sport s ON s.sport_id = t.sport_id
ORDER BY p.player_salary DESC LIMIT 1;
    