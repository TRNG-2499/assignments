SELECT p.player_name, s.sport_name, p.player_salary
FROM player p
    JOIN team t ON t.team_id = p.team_id
    JOIN sport s ON s.sport_id = t.sport_id
WHERE s.sport_name = 'Foot Ball'
    AND p.player_salary > 200000;
