CREATE OR REPLACE VIEW highest_paid_player AS
SELECT player_id, team_id, player_salary FROM Player ORDER BY player_salary DESC LIMIT 1;

SELECT s.sport_name FROM Sport s, Team t, Player p WHERE s.sport_id = t.sport_id AND t.team_id = p.team_id AND p.player_salary = (SELECT player_salary FROM highest_paid_player);