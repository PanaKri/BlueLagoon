CREATE DATABASE JAVA;
USE JAVA;

/*DROP TABLE COURSE
DROP TABLE ROOM;*/
DROP TABLE COURSE;
CREATE TABLE COURSE(
course_id INTEGER PRIMARY KEY,
course_name VARCHAR(255) NOT NULL,
professor_am INTEGER NOT NULL,
exam_room INTEGER NOT NULL,
student_number INTEGER NOT NULL,
exam_date DATETIME NOT NULL,
exam_time TIME NOT NULL
);
DROP TABLE ROOM;
CREATE TABLE ROOM(
room_id INTEGER PRIMARY KEY,
room_quantity INTEGER
);

INSERT INTO COURSE (course_id, course_name, professor_am, exam_room, student_number, exam_date, exam_time)
VALUES (1, "CODING", 4569871, 1, 120, "2025-01-24", "13:00:00");
INSERT INTO COURSE (course_id, course_name, professor_am, exam_room, student_number, exam_date, exam_time)
VALUES (2, "MANAGEMENT", 8759546, 2, 100, "2025-01-27", "15:00:00");
INSERT INTO COURSE (course_id, course_name, professor_am, exam_room, student_number, exam_date, exam_time)
VALUES (3, "MARKETING", 7546269, 3, 95, "2025-01-29", "14:00:00");
INSERT INTO COURSE (course_id, course_name, professor_am, exam_room, student_number, exam_date, exam_time)
VALUES (4, "STATISTICS", 6301587, 4, 74, "2025-02-02", "12:00:00");
INSERT INTO COURSE (course_id, course_name, professor_am, exam_room, student_number, exam_date, exam_time)
VALUES (5, "LOGISTICS", 1895762, 5, 89, "2025-02-05", "10:00:00");

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


