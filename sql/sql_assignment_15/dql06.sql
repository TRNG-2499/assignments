--first statement, names like "Jo%%"
SELECT player_name 
FROM player
WHERE LOWER(player_name)
LIKE 'jo%'


--second statement, names containing a and then eventually an e
SELECT player_name
from player
WHERE LOWER(player_name)
LIKE '%a%e%'