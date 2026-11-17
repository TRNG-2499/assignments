DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS writer;

CREATE TABLE writer (
	writer_id SERIAL PRIMARY KEY,
	writer_name VARCHAR(100) NOT NULL
);

CREATE TABLE books (
	book_id SERIAL PRIMARY KEY,
	title VARCHAR(100) NOT NULL,
	author INTEGER NOT NULL,
	publication INTEGER,
	page_count INTEGER,
	FOREIGN KEY (author) REFERENCES writer(writer_id)
);