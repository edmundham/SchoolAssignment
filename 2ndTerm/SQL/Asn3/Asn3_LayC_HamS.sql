SET ECHO ON
--
SPOOL Asn3_LayC_HamS.txt
--
--
--  COMP 2714
--  SET 2E
--  ASSIGNMENT 03
--  Lay, Cameron  A00816870, Ham, Sunguk  A00979841
--  email: cameron.lay1@gmail.com, ham2959@gmail.com
--
-- Question 1: What is the average price of a room in London?
-- a) Do this using JOIN
SELECT AVG(price)
    FROM Hotel h
        JOIN Room r
            ON h.hotelNo = r.hotelNo
    WHERE hotelAddress LIKE '%London%';
-- b) Do this using IN subquery.
SELECT AVG(price)
    FROM Room r
    WHERE hotelNo IN
            (SELECT hotelNo
                FROM Hotel h
                WHERE hotelAddress LIKE '%London%');
--
--
-- Quesiton 2: Use the month of 2017-10 instead of August, and do the query
-- for each hotel, listing in hotelName order:
-- i.e. How many different guests have made bookings for 2017-10 for each
-- hotel?
SELECT hotelName, 
       hotelNo, 
       (SELECT COUNT(DISTINCT guestNo)
            FROM Booking b
            WHERE b.hotelNo = h.hotelNo
                AND (dateTo IS NULL OR dateTo >= DATE'2017-10-01')
                AND dateFrom < DATE'2017-11-01')
       AS "Number of Guests"
    FROM Hotel h
    GROUP BY hotelNo, hotelName
    ORDER BY hotelName;
--
--
-- Question 3: Use 2017-10-05 as today's date. Include all 'Grosvenor' hotels.
-- List in hotelNo, roomNo order.
-- List the details of all rooms at the grosvenor hotel including the name
-- of the guest staying in the room if the room is ocupied.
SELECT hotelNo,
       (SELECT roomNo
            FROM Room r
            WHERE r.roomNo = b.roomNo
                AND r.hotelNo = b.hotelNo)
       AS "roomNo",
       (SELECT type
            FROM Room r
            WHERE r.roomNo = b.roomNo
                AND r.hotelNo = b.hotelNo)
       AS "type",
       (SELECT price
            FROM Room r
            WHERE r.roomNo = b.roomNo
                AND r.hotelNo = b.hotelNo)
       AS "price",
       (SELECT guestName
            FROM Guest g
            WHERE g.guestNo = b.guestNo)
       AS "guestName"
    FROM Booking b
    WHERE dateFrom <= DATE'2017-10-05'
        AND (dateTo IS NULL OR dateTo >= DATE'2017-10-05')
        AND hotelNo IN
            (SELECT hotelNo
                FROM Hotel
                WHERE hotelName LIKE '%Grosvenor%')
    ORDER BY hotelNo, roomNo;
--
--
-- Question 4: use NOT IN
-- List the rooms that are currently unoccupied.
SELECT hotelNo,
       roomNo
    FROM Room r
    WHERE roomNo NOT IN
        (SELECT roomNo
            FROM Booking b
            WHERE b.hotelNo = r.hotelNo
                AND dateFrom <= DATE'2017-10-05'
                AND (dateTo IS NULL OR dateTo >= DATE'2017-10-05'))
        AND hotelNo IN
            (SELECT hotelNo
                FROM Hotel h
                WHERE hotelName LIKE '%Grosvenor%')
    ORDER BY hotelNo, roomNo;
--
--
-- Question 5: use NOT EXISTS question 4
-- List the rooms that are currently unoccupied.
SELECT hotelNo,
       roomNo
    FROM Room r
    WHERE NOT EXISTS
        (SELECT 1
            FROM Booking b
            WHERE r.roomNo = b.roomNo
                AND r.hotelNo = b.hotelNo
                AND dateFrom <= DATE'2017-10-05'
                AND (dateTo IS NULL OR dateTo >= DATE'2017-10-05'))
        AND hotelNo IN 
            (SELECT hotelNo
                FROM Hotel h
                WHERE hotelName LIKE '%Grosvenor%')
    ORDER BY hotelNo, roomNo;
--
--
-- Question 6: use LEFT JOIN question 4
-- List the rooms taht are currently unoccupied.
SELECT r.hotelNo,
       r.roomNo
    FROM Room r
        LEFT JOIN Booking b
            ON r.roomNo = b.roomNo
            AND r.hotelNo = b.hotelNo
        LEFT JOIN Hotel h
            ON b.hotelNo = h.hotelNo
            AND r.hotelNo = h.hotelNo
    WHERE hotelName LIKE '%Grosvenor%'
        AND dateFrom <= DATE'2017-10-05' 
        AND (dateTo IS NULL OR dateTo >= DATE'2017-10-05')
        AND b.roomNo IS NOT NULL
    GROUP BY r.hotelNo, r.roomNo
    ORDER BY hotelNo, roomNo;
--
--
-- Question 7: use MINUS question 4
-- list the rooms taht are currently unoccupied.
SELECT hotelNo,
       roomNo
    FROM Room r
    WHERE hotelNo IN 
        (SELECT hotelNo
            FROM Hotel h
            WHERE hotelName LIKE '%Grosvenor%')
MINUS
SELECT hotelNo,
       roomNo
    FROM Booking b
    WHERE dateFrom <= DATE'2017-10-05' 
        AND (dateTo IS NULL OR dateTo >= DATE'2017-10-05')
    ORDER BY hotelNo, roomNo;
--
--
-- Question 8: Use the month of 2017-10 instead of August.
-- What is the average number of bookings for each hotels in august?
SELECT AVG(hotelNoCount) AS "Bookings in October"
    FROM (SELECT hotelNo, 
                 COUNT(hotelNo) AS hotelNoCount 
              FROM Booking 
                  WHERE dateTo IS NULL OR dateTo >= DATE'2017-10-01'
                      AND dateFrom < DATE'2017-11-01'
              GROUP BY hotelNo);
--
--
-- Question 9: Use 2017-10-05 as today, list hotelNo, hotelName,
-- and lostIncome, in hotelNo order
-- what is the lost income from unoccupied rooms at each hotel today?
SELECT r.hotelNo, 
       (SELECT hotelName
            FROM Hotel H
             WHERE h.hotelNo = r.hotelNo), 
       SUM(r.price) AS "Lost Income"
    FROM Room r
    WHERE NOT EXISTS
        (SELECT 1
            FROM Booking b
            WHERE r.roomNo = b.roomNo
                AND r.hotelNo = b.hotelNo
                AND dateFrom <= DATE'2017-10-05'
                AND (dateTo IS NULL OR dateTo >= DATE'2017-10-05'))
    GROUP BY hotelNo
    ORDER BY hotelNo;
--
--
-- Question 10: use 10-05 as today, and guestAccount as view name.
-- The account info for each guest means: room(roomno),
-- name(guestname), check-in(datefrom), check-out(dateTo = today),
-- rate(price), #days(calculate from dateTo and dateFrom),
-- and total(calculate from dateto, adatefrom and price).
-- Add query to test the view.
DROP VIEW guestAccount;
--
CREATE VIEW guestAccount
    AS
    SELECT r.roomNo AS "Room", 
    g.guestName AS "Guest", 
    b.dateFrom AS "Check-in", 
    b.dateTo AS "Check-out", 
    r.price AS "Rate", 
    (b.dateTo-b.dateFrom) AS "# Days", 
    ((b.dateTo-b.dateFrom)*r.price) AS "Total"
    FROM Guest g
        LEFT JOIN Booking b
            ON b.guestNo = g.guestNo
        LEFT JOIN Room r
            ON r.roomNo = b.roomNo
        LEFT JOIN Hotel h
            ON h.hotelNo = r.hotelNo
    WHERE h.hotelName LIKE '%Grosvenor Hotel%'
        AND b.dateFrom <= DATE'2017-10-05'
        AND (b.dateTo IS NULL OR b.dateTo >= DATE'2017-10-05')
    GROUP BY r.roomNo, g.guestName, b.dateFrom, b.dateTo, r.price;
--
SELECT *
    FROM guestAccount;
--
-- Question 11: Find the guests (name and address) who stayed before
-- at one of the 'Grosvenor' hotels, and also at the Part Royal Hotel,
-- but never stayed at the Meridian Hotel.
SELECT guestName,
       guestAddress
    FROM Guest g 
    WHERE guestNo IN
        (SELECT guestNo
            FROM Booking b 
                LEFT JOIN Hotel h 
                    ON h.hotelNo = b.hotelNo
                        WHERE h.hotelName = 'Grosvenor Hotel'
                        OR h.hotelName = 'Grosvenor Inn')
    AND guestNo IN
        (SELECT guestNo
            FROM Booking b 
                LEFT JOIN Hotel h 
                    ON h.hotelNo = b.hotelNo
                        WHERE h.hotelName = 'Park Royal Hotel')
    AND guestNo NOT IN
        (SELECT guestNo
            FROM Booking b 
                LEFT JOIN Hotel h 
                    ON h.hotelNo = b.hotelNo
                        WHERE h.hotelName = 'Meridian Hotel');
--
--testing
-- SELECT guestNo from booking where hotelNo is (1 or 8) and 6 and not 2
SELECT guestNo
    FROM Booking
    WHERE (hotelNo = 1 OR hotelNo = 8)
        AND hotelNo = 6
        AND hotelNo != 2
;
--
SELECT guestNo
    FROM Booking
    WHERE hotelNo = 1 OR hotelNo = 8
INTERSECT
SELECT guestNo
    FROM Booking
    WHERE hotelNo = 6
MINUS
SELECT guestNo
    FROM Booking
    WHERE hotelNo = 2
;
--
SPOOL OFF
-- start Asn3_LayC_HamS.sql
