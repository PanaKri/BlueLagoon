CREATE DATABASE JAVA;
USE JAVA;

CREATE TABLE STUDENT(
student_id INT PRIMARY KEY,
student_name VARCHAR(30),
student_surname VARCHAR(30),,
course_id INT REFERENCES COURSE(course_id), /*this needs to be added after the table is created with ALTER TABLE STUDENT ADD course_id INT REFERENCES COURSE(course_id);*/
);

CREATE TABLE PROFESSOR(
professor_am INT PRIMARY KEY,
professor_name VARCHAR(30),
professor_surname VARCHAR(30),
);


/*DROP TABLE COURSE
DROP TABLE ROOM;*/
CREATE TABLE COURSE(
course_id INTEGER PRIMARY KEY,
course_name VARCHAR(255) NOT NULL,
professor_am INT REFERENCES PROFESSOR(professor_am),
student_id INT REFERENCES STUDENT(student_id),
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

INSERT INTO STUDENT (student_id, student_name, student_surname, course_id)
VALUES (12345, "GIORGOS", "PAPADOPOULOS", "CODING");
INSERT INTO STUDENT (student_id, student_name, student_surname, course_id)
VALUES (67890, "MARIA", "ALEXIOU", "MANAGEMENT");

INSERT INTO PROFESSOR (professor_am, professor_name, professor_surname)
VALUES (4569871, "SAKIS", "ROUBAS");