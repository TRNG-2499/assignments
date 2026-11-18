SELECT p.player_name
FROM Player p 
LEFT JOIN Team t  
    ON p.team_id = t.team_id
LEFT JOIN Sport s 
    ON t.sport_id = s.sport_id
WHERE s.sport_name = 'Foot Ball' AND p.player_salary > 200000;

# player salary is spelled player Salary in example, changed it for readability