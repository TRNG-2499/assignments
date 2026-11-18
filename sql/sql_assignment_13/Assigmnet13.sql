select p.player_name from practice.player p join practice.team t on p.team_id = t.team_id
where t.sport_id = 40001 and p.player_salary > 200000; 
-- the 40001 is the id for the football sport from the sport team info