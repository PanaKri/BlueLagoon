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
public class ProfessorManagerSystem {
    Scanner scanner = new Scanner(System.in);
    public int identify() { //Check if the AM exists
        try {
            System.out.println("");
            System.out.println("Type your AM");
            int am = scanner.nextInt();
            scanner.nextLine();
            int AM = -1;
            for (int i = 0; i < Professor.profCount; i++) {
                Professor professor = Professor.proffessors[i];
                if (professor.getAM() == am) {
                    AM = i; //Stores value of AM if it exists
                }
            }
            return AM; //Return the AM or -1
        } catch (InputMismatchException e) { //Handling in case of exception
            scanner.nextLine();
            return -1;
        }
    }
    public void addExam(Schedule sched, Professor prof) {
        Subject selected = Subject.subjects[0]; //initialize subject
        System.out.println("Type the exam subject code:");
        int sub = scanner.nextInt();
        scanner.nextLine();
        boolean f = false;
        for (int i = 0; i < Subject.subjects.length; i++) {
            Subject subject = Subject.subjects[i];
            if (subject.getSubjectCode() == sub) { //Checks if subject code exists
                if (subject.getProfessorAm() == prof.getAM()) {
                    f = true;
                    selected = subject;
                }
            }
        }
        if (f == true) {
            boolean check = selected.checkExam(); //Checks if exam is already set up
            if (check == false) { // if not set up asks for day and time available
                System.out.println("");
                System.out.println("When are you available for an exam? (Type day (1-5), time (1-5) )");
                int d = scanner.nextInt();
                d = d - 1;
                int t = scanner.nextInt();
                t = t - 1;
                scanner.nextLine();
                if (d <= 4 & d >=0 & t <= 4 & t >=0) {
                    sched.addExam(selected, d, t);
                } else {
                    System.out.println("");
                    System.out.println("Day or time not applicable");
                }
            }
        } else {
            System.out.println("You are not the professor of selected subject"); 
            //if am and subject dont match
        }
    }
}
