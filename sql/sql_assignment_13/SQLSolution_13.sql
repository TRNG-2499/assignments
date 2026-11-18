SELECT p.player_name FROM assignment.player p JOIN assignment.team t ON
p.team_id = t.team_id JOIN assignment.sport s ON t.sport_id = s.sport_id
WHERE s.sport_name = 'Foot Ball' AND p.player_salary > 200000;