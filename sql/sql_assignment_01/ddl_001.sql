DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS Writer;

CREATE TABLE Writer (
	writer_id SERIAL PRIMARY KEY,
	writer_name VARCHAR(100) NOT NULL
);

CREATE TABLE Books (
	book_id SERIAL PRIMARY KEY,
	title VARCHAR(100) NOT NULL,
	author INTEGER NOT NULL REFERENCES Writer(writer_id),
	publication INTEGER,
	page_count INTEGER CHECK (page_count > 0)
);