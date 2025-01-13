CREATE DATABASE JAVA;
USE JAVA;

/*DROP TABLE COURSE
DROP TABLE ROOM;*/
DROP TABLE COURSE;
CREATE TABLE COURSE(
course_id INTEGER PRIMARY KEY,
course_name VARCHAR(255) NOT NULL
);
DROP TABLE ROOM;
CREATE TABLE ROOM(
room_id INTEGER PRIMARY KEY,
room_quantity INTEGER
);

INSERT INTO COURSE (course_id, course_name)
VALUES (1, "CODING");
INSERT INTO COURSE (course_id, course_name)
VALUES (2, "MANAGEMENT");
INSERT INTO COURSE (course_id, course_name)
VALUES (3, "MARKETING");
INSERT INTO COURSE (course_id, course_name)
VALUES (4, "STATISTICS");
INSERT INTO COURSE (course_id, course_name)
VALUES (5, "LOGISTICS");

INSERT INTO ROOM (room_id, room_quantity)
VALUES (1,100);
INSERT INTO ROOM (room_id, room_quantity)
VALUES (2,80);
INSERT INTO ROOM (room_id, room_quantity)
VALUES (3,120);
INSERT INTO ROOM (room_id, room_quantity)
VALUES (4,60);
INSERT INTO ROOM (room_id, room_quantity)
VALUES (5,90);


