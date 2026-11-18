select a.author_name, avg(b.page_count) As average_pages
from part.books b 
join part.author a on b.author = a.author_id
group by a.author_id, a.author_name
order by average_pages asc
limit 1;
