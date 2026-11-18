SELECT P.*
FROM Player P
JOIN Team T
  ON P.team_id = T.team_id
JOIN Sport S
  ON T.sport_id = S.sport_id
WHERE S.sport_name = 'Foot Ball'
  AND P.player_Salary > 200000;