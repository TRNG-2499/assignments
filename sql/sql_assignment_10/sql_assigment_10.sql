select sum(page_count) as stephen_king_pages
from Books
group by author
having author = 1005;