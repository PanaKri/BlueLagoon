# BlueLagoon Java Project

Welcome to the **BlueLagoon** Java project! This repository contains a simple tool to
optimize the exam rooms of a schedules exam period per the student number of each exam.

## Table of Contents
1. [How to Compile](#how-to-compile)
2. [How to Run](#how-to-run)
3. [How to Use](#how-to-use)
4. [File Distribution](#file-distribution)
5. [Data Structures & Algorithms](#data-structures--algorithms)
6. [UML Diagram](#uml-diagram)


### How to Compile
 First, **clone** this git repository.
Once the project is cloned in your copmuter:

1. **Go** to the folder  C:\example\path\to\BlueLagoon\Terminal on your terminal.
2. **Run** the "mvn clean install" command. 

This provides a **compiled** .jar file on the target file.

### How to Run

When you are done with the "How to Compile" section:
**Run** java -jar target/Terminal-1.0-SNAPSHOT.jar on the C:\example\path\to\BlueLagoon\Terminal file.
This should provide a **functional application** running on the terminal.

### How to Use

The **Terminal** file contains a mini Database that contains **2 Students with AM 0 and 1 respectively** and a
**Professor with AM 0**. When running, **please** use these numbers, as it wont work otherwise. Like the real
life exams and student enrollment periods, you are **advised** to first log in as **Students**, but the
application works perfectly even if you log in as the **Professor**. **Exiting** the programm will revert all your changes. 

### File Distribution

In the repo you can find files and java code not in the **Terminal** file. These are projects such as a User
Interface, ans SQL database and an Inspector class. These are **NOT FUNCIONAL** or partly at least and **won't be needed** for the
execution of the application. They are kept for historic purposes and a possible update on funcionality and
addition of a UI.

### Data Structures & Algorithms

1. Though originally planned with an SQL database in mind, the app runs on a mini Database on the **DB.java** file.
**DO NOT** alter it if you won't be altering the other classes as well, because this might cause malfunction.

2. The optimization algorithm is pretty simple, it finds the **best Room** for each **Subject**, by finding which 
Room has more seats than the Students enrolled in the Subject **while also** ensuring its the Room with the 
**least amount of seats** from the Rooms **that fit the first criterion**, **maximixing** the number of 
Students in each Room.

### UML diagram

Here is the UML diagram of the project:
![UML Diagram](https://drive.google.com/uc?export=view&id=1WoZUT5LvPoDattWIVWB-6tiakztcL-Kg)
  
