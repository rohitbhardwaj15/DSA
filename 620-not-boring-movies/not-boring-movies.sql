select id, movie, description , rating 
from cinema
where id %2 !=0 AND description != 'boring' 
ORDER BY rating DESC, id DESC