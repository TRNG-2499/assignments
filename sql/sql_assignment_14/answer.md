
select s.sport_name, MAX(p.'player salary') as highest_pay from 
    Sport as s join Team as t On s.sport_id = t.sport_id 
    join Player as p on p.team_id = t.team_id
    group by s.sport_id, s.sport_name
    ORDER BY highest_salary DESC
    limit 1;