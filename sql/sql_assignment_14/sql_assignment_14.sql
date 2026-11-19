select s.sport_name, max(p.player_salary) as highest_paid_player
from player as p
join team as t
on p.team_id = t.team_id
join sport as s
on s.sport_id = t.sport_id
group by sport_name
order by highest_paid_player desc
limit 1;
