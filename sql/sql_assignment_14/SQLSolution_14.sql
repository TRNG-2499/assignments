SELECT sport_name FROM assignment.sport WHERE assignment.sport_id =
(SELECT t.sport_id FROM assignment.team t JOIN assignment.player p ON 
t.team_id = p.team_id ORDER BY p.player_salary DESC LIMIT 1 );
