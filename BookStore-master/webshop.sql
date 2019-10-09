DROP TABLE if exists orders;
DROP TABLE if exists books;

CREATE TABLE books (
	title VARCHAR(45),
    author VARCHAR(45),
    stock INT,
    price INT,
    id INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(id)
);

CREATE TABLE orders  (
	firstName VARCHAR(45),
    lastName VARCHAR(45),
    email varchar(25),
    orderID INT NOT NULL AUTO_INCREMENT,
    bookID INT NOT NULL,
    PRIMARY KEY(orderID),
    FOREIGN KEY(bookID) REFERENCES books(id)
);


INSERT INTO books (title, author, stock, price) VALUES ('In search of lost time', 'Marcel Proust', 6, 150);
INSERT INTO books (title, author, stock, price) VALUES ('Ulysses', 'James Joyce', 8,200);
INSERT INTO books (title, author, stock, price) VALUES ('Don Quixote', 'Miguel de Cervantes', 2, 155);
INSERT INTO books (title, author, stock, price) VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 5, 180);
INSERT INTO books (title, author, stock, price) VALUES ('Moby Dick', 'Herman Melville', 1, 50);
INSERT INTO books (title, author, stock, price) VALUES ('War and Peace', 'Leo Tolstoy', 6, 500);

INSERT INTO orders (firstName, lastName, email, bookID) VALUES("Batman", "Batman", "batman@gmail.com", 1);

