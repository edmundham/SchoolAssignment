SET ECHO ON
--
SPOOL D:\WORK\2714\Asn1_LayC_HamS.txt
--
--
--  COMP 2714
--  SET 2E
--  ASSIGNMENT 01
--  Lay, Cameron  A00816870, Ham, Sunguk  A00979841
--  email: cameron.lay1@gmail.com, ham2959@gmail.com
--
ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD';
--
SELECT SYSDATE
FROM DUAL;
--
--
--
-- Questions 1: Write the DDL statement to remove all 4 tables, plus the old booking archive table.
DROP TABLE OldBooking;
DROP TABLE Booking;
DROP TABLE Room;
DROP TABLE Guest;
DROP TABLE Hotel;
--
--
--
-- Question 2: Create the Hotel and Room tables with all relevant integrity constraints, including: 
-- a) type (room table) must be one of Single, Double, or Family
-- b) price (Room table) must be between $10.00 and $100.00
-- c) room number (Room table) must be between 1 and 100
CREATE TABLE Hotel
(hotelNo      CHAR(8)      NOT NULL
,hotelName    VARCHAR(30)  NOT NULL
,city         VARCHAR(20)  NOT NULL
,CONSTRAINT   PKHotel PRIMARY KEY (hotelNo)
);
--
-- SGL represents a Single, DBL represents a Double, and FAM represents a Family
CREATE TABLE Room
(roomNo       DECIMAL(3,0) NOT NULL
,hotelNo      CHAR(8)      NOT NULL
,type         CHAR(3)      NOT NULL
,price        DECIMAL(5,2) NOT NULL
,CONSTRAINT  PKRoom    PRIMARY KEY (roomNo, hotelNo)
,CONSTRAINT  FKhotelNo FOREIGN KEY (hotelNo)
                       REFERENCES Hotel (hotelNo)
,CONSTRAINT chk_type
    CHECK(type IN ('SGL','DBL','FAM'))
,CONSTRAINT chk_price
    CHECK(price BETWEEN 10.00 AND 100.00)
,CONSTRAINT chk_roomNo
    CHECK(roomNo BETWEEN 1 AND 100)
);
--
--
--
-- Question 3: Create the Guest and Booking tables with all relevant integrity constraints.
CREATE TABLE Guest
(guestNo      VARCHAR(30)   NOT NULL
,guestName    VARCHAR(30)   NOT NULL
,guestAddress VARCHAR(30)   NOT NULL
,CONSTRAINT  PKGuest PRIMARY KEY (guestNo)
);
--
--
CREATE TABLE BOOKING
(hotelNo      CHAR(8)       NOT NULL
,guestNo      VARCHAR(30)   NOT NULL
,dateFrom     DATE          NOT NULL
,dateTo       DATE
,roomNo       DECIMAL(3,0)  NOT NULL
,CONSTRAINT PKBooking         PRIMARY KEY (hotelNo, guestNo, dateFrom)
,CONSTRAINT FKBooking_hotelNo FOREIGN KEY (hotelNo)
                              REFERENCES Hotel (hotelNo)
,CONSTRAINT FKguestNo         FOREIGN KEY (guestNo)
                              REFERENCES Guest (guestNo)
,CONSTRAINT FKroomNo          FOREIGN KEY (roomNo, hotelNo)
                              REFERENCES Room (roomNo, hotelNo)
,CONSTRAINT chk_dateTo   
    CHECK(dateTo > dateFrom)
);
--
--
--
-- Question 4: Insert 3 rows of sample data to each of the 4 tables.
INSERT INTO Hotel
    VALUES('A0000001', 'BURNABY01', 'BURNABY');
INSERT INTO Hotel
    VALUES('A0000002', 'VANCOUVER01', 'VANCOUVER');
INSERT INTO Hotel
    VALUES('A0000003', 'SURREY01', 'SURREY');
--
--
INSERT INTO Room
    VALUES(1, 'A0000001', 'FAM', 70.00);
INSERT INTO Room
    VALUES(80, 'A0000002', 'SGL', 75.00);
INSERT INTO Room
    VALUES(99, 'A0000003', 'DBL', 15.00);
--
--
INSERT INTO Guest
    VALUES('BURN001', 'SUNGUKHAM', 'VANCOUVER');
INSERT INTO Guest
    VALUES('VAN001', 'CAMERONLAY', 'VANCOUVER');
INSERT INTO Guest
    VALUES('SURR001', 'KEITHTANG', 'VANCOUVER');
--
--
INSERT INTO Booking
    VALUES('A0000001', 'BURN001', DATE'2017-08-20', DATE'2017-08-25', 1);
INSERT INTO Booking
    VALUES('A0000002', 'VAN001', DATE'2017-09-20', DATE'2017-09-25', 80);
INSERT INTO Booking
    VALUES('A0000003', 'SURR001', DATE'2017-09-20', DATE'2017-09-25', 99);
--
--
--
-- Question 5:
-- a) The hotels now have a new room type 'Deluxe'. Modify the check constraint to allow for this.
-- b) Need to offer discounts. Add column 'discount' to the Room table, with default value of 0 (percent), max. value of 30.
ALTER TABLE Room
    DROP CONSTRAINT chk_type;
--
ALTER TABLE Room
    ADD CONSTRAINT chk_type
    CHECK(type IN ('SGL','DBL','FAM', 'DLX'));
--
--
ALTER TABLE Room
    ADD discount  DECIMAL(3,2) DEFAULT 0
    CONSTRAINT chk_discount
    CHECK (discount BETWEEN 0.00 AND 0.30);
--
--
--
-- Question 6:
-- a) One of the hotels increases the price of its 'Double' room type by 15%. Implement this change.
-- b) One of the booking guest decided to arrive on an earlier date and stay till a later date. Modify the booking accordingly.
UPDATE Room
    SET price = price*1.15
    WHERE    type = 'DBL'
      AND hotelNo = 'A0000003';
--
--
UPDATE BOOKING
    SET dateFrom = DATE'2017-09-19'
       ,dateTo   = DATE'2017-09-27'
    WHERE guestNo = 'VAN001';
--
--
--
-- Question 7:
-- a) Create an OldBooking table to hold archive date rows from the Booking table.
-- b) Using the INSERT statement, copy the rows with dateTo before 2017-09-01 from the booking table to the OldBooking archive table.
-- c) Then delete from Booking all booking rows with dateTo before 2017-09-01.
CREATE TABLE OldBooking
(hotelNo      CHAR(8)        NOT NULL
,guestNo      VARCHAR(30)    NOT NULL
,dateFrom     DATE           NOT NULL
,dateTo       DATE           NOT NULL
,roomNo       DECIMAL(3,0)   NOT NULL
,CONSTRAINT PKOldBooking         PRIMARY KEY (hotelNo, guestNo, dateTo)
,CONSTRAINT FKOldBooking_hotelNo FOREIGN KEY (hotelNo)
                                 REFERENCES Hotel (hotelNo)
,CONSTRAINT FKOldBooking_guestNo FOREIGN KEY (guestNo)
                                 REFERENCES Guest (guestNo)
,CONSTRAINT FKOldBooking_roomNo  FOREIGN KEY (roomNo, hotelNo)
                                 REFERENCES Room (roomNo, hotelNo)
);
--
--
INSERT INTO OldBooking
    SELECT *
    FROM Booking
    WHERE dateTo < DATE'2017-09-01';
--
DELETE FROM Booking
    WHERE dateTo < DATE'2017-09-01';
--
--
--
--
SPOOL OFF
