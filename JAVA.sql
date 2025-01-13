CREATE DATABASE JAVA;
USE JAVA;

/*DROP TABLE COURSE
DROP TABLE ROOM;*/
CREATE TABLE COURSE(
course_id INTEGER PRIMARY KEY,
course_name VARCHAR(255) NOT NULL,
professor_am INTEGER NOT NULL,
student_number INTEGER NOT NULL,
);
DROP TABLE ROOM;
CREATE TABLE ROOM(
room_id INTEGER PRIMARY KEY,
room_quantity INTEGER
);

INSERT INTO COURSE (course_id, course_name, professor_am, student_number)
VALUES (1, "CODING", 4569871, 120);
INSERT INTO COURSE (course_id, course_name, professor_am, student_number)
VALUES (2, "MANAGEMENT", 8759546, 100);
INSERT INTO COURSE (course_id, course_name, professor_am, student_number)
VALUES (3, "MARKETING", 7546269, 95);
INSERT INTO COURSE (course_id, course_name, professor_am, student_number)
VALUES (4, "STATISTICS", 6301587, 74);
INSERT INTO COURSE (course_id, course_name, professor_am, student_number)
VALUES (5, "LOGISTICS", 1895762, 89);

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


