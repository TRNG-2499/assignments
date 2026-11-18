SELECT S.sport_name 
FROM Sport S
JOIN Team T
  ON S.sport_id = T.sport_id
JOIN Player P
  ON T.team_id = P.team_id
ORDER BY P.player_salary DESC LIMIT 1;