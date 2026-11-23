/*DROP TABLE Author CASCADE;
DROP TABLE Books;

CREATE TABLE Author (
	author_id SERIAL PRIMARY KEY,
	author_name VARCHAR(100)
);

CREATE TABLE Books (
	book_id SERIAL PRIMARY KEY,
	title VARCHAR(100),
	author SERIAL REFERENCES Author(author_id),
	publication INTEGER,
	page_count INTEGER
)

INSERT INTO Author (author_name) VALUES ('Agatha Christie');
INSERT INTO Author (author_name) VALUES ('George Orwell');
INSERT INTO Author (author_name) VALUES ('Kurt Vonnegut');
INSERT INTO Author (author_name) VALUES ('Mark Twain');
INSERT INTO Author (author_name) VALUES ('Stephen King');

INSERT INTO Books (title, author, publication, page_count) VALUES ('Murder on the Orient Express', 		1, 1934, 256);
INSERT INTO Books (title, author, publication, page_count) VALUES ('It', 								5, 1986, 1138);
INSERT INTO Books (title, author, publication, page_count) VALUES ('And Then There Were None', 			1, 1939, 272);
INSERT INTO Books (title, author, publication, page_count) VALUES ('Pet Sematary', 						5, 1983, 373);
INSERT INTO Books (title, author, publication, page_count) VALUES ('Slaughterhouse-Five', 				3, 1969, 215);
INSERT INTO Books (title, author, publication, page_count) VALUES ('Nineteen Eighty-Four', 				2, 1949, 328);
INSERT INTO Books (title, author, publication, page_count) VALUES ('Adventures of Huckleberry Finn', 	4, 1884, 366);
INSERT INTO Books (title, author, publication, page_count) VALUES ('Death of the Nile', 				1, 1937, 288);
INSERT INTO Books (title, author, publication, page_count) VALUES ('Animal Farm', 						2, 1945, 112);
INSERT INTO Books (title, author, publication, page_count) VALUES ('The Adventures of Tom Sawyer', 		4, 1876, 274);
INSERT INTO Books (title, author, publication, page_count) VALUES ('The Shining', 						5, 1977, 447);
INSERT INTO Books (title, author, publication, page_count) VALUES ('Salems Lot', 						5, 1975, 439);
INSERT INTO Books (title, author, publication, page_count) VALUES ('Cats Cradle', 						3, 1963, 304);

SELECT * FROM Author;
SELECT * FROM Books;
*/

SELECT SUM(page_count) FROM Books WHERE author = (SELECT author_id FROM Author WHERE author_name = 'Stephen King');