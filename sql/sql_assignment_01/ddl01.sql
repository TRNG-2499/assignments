CREATE TABLE writer (writer_id INT PRIMARY KEY, 
                     writer_name VARCHAR(50)
)


CREATE TABLE books (book_id INT PRIMARY KEY,
                    title VARCHAR(50),
                    auther VARCHAR(50),
                    publication INT,
                    page_count INT
)