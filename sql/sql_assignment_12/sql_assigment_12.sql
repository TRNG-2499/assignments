select author_name, avg(page_count) as avg_page_count
from Author as a
join Books as b
on a.author_id = b.author
group by a.author_name
order by avg(page_count) asc
limit 1;
