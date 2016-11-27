-- Van welke auteurs zijn er boeken uitgeleend?
SELECT BOOK.Author
FROM BOOK
INNER JOIN COPY
ON BOOK.ISBN = COPY.BookISBN
WHERE EXISTS (
        SELECT * FROM LOAN
        WHERE LOAN.CopyID = COPY.CopyID
      );

-- Zonder Inner Join
SELECT BOOK.Author
FROM BOOK
WHERE EXISTS (
        SELECT * FROM LOAN, COPY
        WHERE BOOK.ISBN = COPY.BookISBN AND LOAN.CopyID = COPY.CopyID
      );

-- Maak een view in je database op de database van de bibliotheek. Maak de view
-- op de tabellen book en member. Laat de inhoud van beide tabellen daarin zien.

CREATE VIEW BOOK_MEMBER AS
SELECT * FROM BOOK, MEMBER;

SELECT * FROM BOOK_MEMBER;


-- Maak een view(isbn, titel) van de boeken die zijn gereserveerd.

CREATE VIEW ISBN_TITLE AS
SELECT ISBN, Title
FROM BOOK
WHERE EXISTS (
        SELECT * FROM RESERVATION, BOOK
        WHERE BOOK.ISBN = RESERVATION.BookISBN
      );

SELECT * FROM ISBN_TITLE;
