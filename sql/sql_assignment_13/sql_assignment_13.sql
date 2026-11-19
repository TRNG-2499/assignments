select player_name, player_salary
from player as p
join team as t
on p.team_id = t.team_id
join sport as s
on s.sport_id = t.sport_id
where s.sport_name = 'Foot Ball' and player_salary > 200000;