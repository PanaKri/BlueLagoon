/*
 * Copyright 2025 BlueLagoon
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package BlueLagoonTerminal;
public class Student {
    private String name;
    private String surname;
    private int studentID;
    private int yearOfAdmission;
    private int numbOfCourses = 0;
    private String[] courses = new String[5];
    public static Student[] students= new Student[10];
    public static int studCount = 0;
    //Constructor
    public Student(String name, String surname, int studentID, int yearOfAdmission) { 
       this.name = name;
       this.surname = surname;
       this.studentID = studentID;
       this.yearOfAdmission = yearOfAdmission; 
       for (int i = 0; i < 5; i++) {
        courses[i] = "None";
       }
       students[studCount] = this;
       studCount = studCount + 1;
    }
    public String getEnrolled(String s) { //Enroll in a Subject
        if (numbOfCourses < 5) {
            if (numbOfCourses == 0) { //if first subject
                courses[numbOfCourses] = s;
                numbOfCourses = numbOfCourses + 1;
                return "You have enrolled in:" + " " + s;
            } else {
                boolean flag = true;
                for (int i = 0; i < numbOfCourses; i++) {
                    if (s.equals(courses[i])) { //Checks if already enrolled
                    }
                }
                if (flag == true) { //If not, add to course array and add to its length
                    courses[numbOfCourses] = s;
                    numbOfCourses = numbOfCourses + 1;
                    return "You have enrolled in:" + " " + s;
                } else {
                    return "You have already registered in the course";
                }
            }
        } else { //if max amount of courses has been reached
            return "Max amount of courses reached";
        }
    }
    public String displayInfo() {
        return name + " " + surname + " " + "has student ID: " + studentID
        + "and got registered in: " + yearOfAdmission;
    }
    public String displayCourses() {
        String s = courses[0];
        int i = 1;
        boolean f = false;
        if (courses[i] != "None") {
            do {
                s = s + courses[i] + " ";
                i = i + 1;
                if (i == 5) {
                    i = 0;
                    f = true;
                }
            } while (courses[i] != "None" & i < 5 & f == false);
        }
        return s;
    }
    public int getAM() {
        return this.studentID;
    }
}