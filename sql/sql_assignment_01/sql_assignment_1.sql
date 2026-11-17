create table if not exists Writer (
	writer_id integer generated always as identity (start with 1001) primary key,
	writer_name text
);

create table if not exists Books (
	book_id integer generated always as identity (start with 3050) primary key,
	title text,
	author integer,
	publication integer,
	page_count integer,
	foreign key(author) references Writer(writer_id)
);