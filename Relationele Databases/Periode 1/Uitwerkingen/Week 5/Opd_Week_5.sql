-- Vraag op van welke verschillende auteurs boeken zijn uitgeleend. Sorteer ze omgekeerd op alfabet.

SELECT BOOK.Author
FROM BOOK
WHERE EXISTS (
        SELECT * FROM LOAN, COPY
        WHERE LOAN.CopyID = COPY.CopyID AND BOOK.ISBN = COPY.BookISBN
      )
ORDER BY Author DESC;

-- Welke boektitels zijn gereserveerd, en door wie?

SELECT BOOK.Title, MEMBER.FirstName
FROM RESERVATION
INNER JOIN BOOK
  ON RESERVATION.BookISBN = BOOK.ISBN
INNER JOIN MEMBER
  ON MEMBER.MembershipNumber = RESERVATION.MembershipNumber;

-- Wat zijn de telefoonnummers van de leden die zowel boeken gereserveerd als geleend hebben?

SELECT MEMBER.PhoneNumber
FROM MEMBER
WHERE EXISTS (
        SELECT * FROM LOAN, RESERVATION
        WHERE LOAN.MembershipNr = MEMBER.MembershipNumber AND RESERVATION.MembershipNumber = MEMBER.MembershipNumber
      );

-- Geef de titels van de boeken die zowel gereserveerd als uitgeleend zijn.

SELECT BOOK.Title
FROM BOOK
WHERE EXISTS (
        SELECT * FROM LOAN, RESERVATION, COPY
        WHERE BOOK.ISBN = COPY.BookISBN AND LOAN.CopyID = COPY.CopyID AND BOOK.ISBN = RESERVATION.BookISBN
      );

-- Geef de voornamen van de leden die vandaag een boek hebben geleend.

SELECT MEMBER.FirstName
FROM LOAN
INNER JOIN MEMBER
  ON MEMBER.MembershipNumber = LOAN.MembershipNr
INNER JOIN COPY
  ON LOAN.CopyID = Copy.CopyID
WHERE DATE_SUB(Loan.ReturnDate, INTERVAL Copy.LendingPeriod DAY) = CURDATE();

-- Geef een alfabetische lijst van de leden met daarbij het aantal boeken dat ze hebben geleend.

SELECT DISTINCT MEMBER.FirstName, COUNT(LOAN.MembershipNr) AS Amout
FROM  MEMBER
INNER JOIN LOAN
  ON LOAN.MembershipNr = MEMBER.MembershipNumber;


-- Wat is het gemiddelde huisnummer?
