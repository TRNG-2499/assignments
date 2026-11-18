select s.sport_name from practice.sport s 
join practice.team t on s.sport_id = t.sport_id 
join practice.player p on t.team_id = p.team_id
order by p.player_salary desc
limit 1; 

-- Needed 2 joins for the sports and teams to player and ordered it by sal. 