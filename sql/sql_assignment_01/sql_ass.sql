Create Table part.writer (
	writer_id Serial primary key, 
	writer_name varchar(100)
);

Create Table part.books (
	book_id Serial primary key, 
	title varchar(200),
	author integer, 
	publication integer, 
	page_count integer, 
	constraint books_fk foreign key (author) references part.writer(writer_id)
);