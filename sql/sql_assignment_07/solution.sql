CREATE TABLE Books (
	book_id SERIAL PRIMARY KEY,
	title VARCHAR(100),
	author INT REFERENCES Author (author_id),
	publication INT,
	page_count INT
);

INSERT INTO Books (title, author, publication, page_count) VALUES ('Odyssey of Shipman', (SELECT (author_id) FROM Author WHERE author_name = 'George Orwell'), 1930, 350);