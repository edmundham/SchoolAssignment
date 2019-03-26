SET ECHO ON
--
SPOOL Asn2_LayCHamS.txt
--
--
--  COMP 2714
--  SET 2E
--  ASSIGNMENT 02
--  Lay, Cameron  A00816870, Ham, Sunguk  A00979841
--  email: cameron.lay1@gmail.com, ham2959@gmail.com
--
-- Question 1: For all hotels in London, list hotel name, hotelAddress,
-- roomtype and price of all Single, Double, or Family rooms with a price
-- below 100.00 per night, in descending order of hotelName, ascending 
-- order of price and descending order of type. List each result entry
-- only once.
SELECT hotelName, city, type, price
    FROM Hotel h
        LEFT JOIN Room r
            ON h.hotelNo = r.hotelNo
    WHERE city LIKE '%, London%'
        AND price < 100.00
        AND type IN ('Single', 'Double', 'Family')
    ORDER BY hotelName DESC,
             price     ASC,
             type      DESC;
--
--
-- Question 2: List the Vancouver hotel bookings for which no dateTo has
-- been specified. List the hotelName, hotleAddress, room number, dateFrom
-- and dateTo. Note: Hotels in West and North Vancouver should be excluded.
SELECT hotelName, city, roomNo, dateFrom, dateTo
    FROM Hotel h
        LEFT JOIN Booking b
            ON h.hotelNo = b.hotelNo
    WHERE DateTo IS NULL
        AND city LIKE '%, Vancouver';
--
--
-- Question 3: What is the average price of a room for each hotel? List it
-- with the hotelName and in hotelName order.
SELECT hotelName, AVG(price)
    FROM Hotel h
        LEFT JOIN Room r
            ON h.hotelNo = r.hotelNo
    GROUP BY hotelName
    ORDER BY hotelName;
--
--
-- Question 4: Do this for each hotel and in one single query. List the
-- total revenue with the hotelName, and only if the total revenue is
-- between $500 to $1000. List in hotelName order.
-- Assuming all the rooms are booked
SELECT hotelName, SUM(price)
    FROM Hotel h
        LEFT JOIN Booking b
            ON h.hotelNo = b.hotelNo
        LEFT JOIN Room r
            ON b.roomNo = r.roomNo
    HAVING 500.00 < SUM(price)
        AND SUM(price) < 1000.00
    GROUP BY hotelName;
--
--
-- Question 5: List the type and price of all rooms at the hotels with
-- "Grosvenor" in name, including the number of rooms for each combination
-- of type and price. List only if the number of rooms for each type and
-- price combination is greater than 3.
SELECT type, price, COUNT(type), COUNT(price)
    FROM Room r
        LEFT JOIN Hotel h
            ON r.hotelNo = h.hotelNo
    WHERE hotelName LIKE '%Grosvenor%'
    HAVING COUNT(price) > 3
        AND COUNT(type) > 3
    GROUP BY type, price;
--
--
-- Question 6: Include the roomNo in the output. Use 2017-09-29 as the
-- current date.
SELECT r.roomNo, g.guestName
    FROM Room r
        LEFT JOIN Booking b
            ON r.roomNo = b.roomNo
        LEFT JOIN Guest g
            ON b.guestNo = g.guestNo
    WHERE dateFrom <= DATE'2017-09-29' 
        AND (dateTo IS NULL OR dateTo >= DATE'2017-09-29')
    ORDER BY r.roomNo ASC;
--
--
-- Question 7: Do this question for each of the hotels with 'Grosvenor' in
-- name. Use 2017-09-29 as current date
SELECT h.hotelName, SUM(price)
    FROM Hotel h
        LEFT JOIN Room r
            ON h.hotelNo = r.hotelNo
        LEFT JOIN Booking b
            ON r.roomNo = b.roomNo
    WHERE dateFrom <= DATE'2017-09-29' 
        AND (dateTo IS NULL OR dateTo >= DATE'2017-09-29')
        AND h.hotelName LIKE '%Grosvenor%'
    GROUP BY h.hotelName
    ORDER BY h.hotelName ASC;
--
--
-- Question 8: What is the total income for each room type from bookings for
-- each hotel (listing hotel names) today? Use 2017-09-29 as today's date.
-- List in ascending order of hotel name and room type.
SELECT hotelName, type, SUM(price)
    FROM Hotel h
        LEFT JOIN Room r
            ON h.hotelNo = r.hotelNo
        LEFT JOIN Booking b
            ON r.roomNo = b.roomNo
    WHERE dateFrom <= DATE'2017-09-29'
        AND (dateTo IS NULL OR dateTo >= DATE'2017-09-29')
    GROUP BY hotelName, type
    ORDER BY h.hotelName ASC,
             r.type ASC;
--
--
-- Question 9: List the new hotels that are still under construction, i.e.
-- no room data in the database as yet for these hotels.
SELECT hotelName
    FROM Hotel h
        LEFT JOIN Room r
            ON h.hotelNo = r.hotelNo
    WHERE r.roomNo IS NULL;
--
--
-- Question 10: What is the percentage of hotels still under construction?
-- List the total number of hotels, number of hotels completed, the number
-- of hotels under construction, and the percentage of hotels under
-- construction. NO SUBQUERY; use OUTER JOIN.
SELECT COUNT(DISTINCT h.hotelName) AS "Total Hotels",
       COUNT(DISTINCT r.hotelNo)   AS "Completed Hotels",
       (COUNT(DISTINCT h.hotelName) - COUNT(DISTINCT b.hotelNo)) 
                                   AS "Under Construction",
       (((COUNT(DISTINCT h.hotelName) - COUNT(DISTINCT b.hotelNo))
                                      / COUNT(DISTINCT h.hotelName))
                                      * 100)
                                   AS "% under construction"
    FROM Hotel h
        LEFT JOIN Room r
            ON h.hotelNo = r.hotelNo
        LEFT JOIN Booking b
            ON r.roomNo = b.roomNo;
--
--
SPOOL OFF
-- start Asn2_LayCHamS.sql
