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
import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentManagerSystem {
    Scanner input = new Scanner(System.in);
    private String choice;
    public int identify() { //IDs student
        try {
            System.out.println("");
            System.out.println("Type your AM");
            int am = input.nextInt();
            input.nextLine();
            int AM = -1;
            for (int i = 0; i < Student.studCount; i++) { //Checks if AM exists
                Student student = Student.students[i];
                if (student.getAM() == am) {
                    AM = i;
                }
            }
            return AM; //Returns the AM or -1 
        } catch (InputMismatchException e) { //Handles exception
            input.nextLine();
            return -1;
        }
    }
    public void addSubject(Student stud) {
        System.out.println("Please state which subject you want to get enrolled");
        choice = input.nextLine();
        boolean flag = false;
        int i = 0;
        Subject selection = Subject.subjects[i];
        do { //Runs the Subject array to find Subject
            Subject sub = Subject.subjects[i];
            String name = sub.getSubjectName();
            if (name.equals(choice)) {
                flag = true; // True if Subject exists
                selection = sub;
            } else {
                i = i + 1;
            }
        } while (flag == false & i < Subject.subjectCount);
        if (flag == true) { //If found then enrolls in Subject
            String answer = stud.getEnrolled(choice);
            selection.addStudent();
            System.out.println(answer);
        } else {
            System.out.println("No subject named " + choice);
        }
    }
    public void DisplayInfo(Student stud) {
        System.out.println(stud.displayInfo());
        System.out.println("Courses taken " + stud.displayCourses());
    }
}
