SELECT player_id, player_name 
FROM player p
JOIN
    team t 
    ON p.team_id = t.team_id
    WHERE t.sport_id = 40001 AND p.salary > 200000