select p.player_name from Player as p join Team as t ON p.team_id = t.team_id
where p.'player Salary' > 200000 AND sport_id = 40001