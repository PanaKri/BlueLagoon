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
//mvn clean install                           After cloning, run this on C:/path/to/BlueLagoon/Terminal
//java -jar target/Terminal-1.0-SNAPSHOT.jar  What to run after the build is successfull
public class ProgramMain {
    DB db = new DB(); //Adds mini Database
    static StudentManagerSystem sms = new StudentManagerSystem();
    static ProfessorManagerSystem pms = new ProfessorManagerSystem();
    static Schedule schedule = new Schedule();
    public static void main (String [] args) throws InputMismatchException {
        DB.runDB();
        DB.addSubject(); //Runs mini database
        int answer = 0;
        Scanner scanner1 = new Scanner(System.in);
        do {
            boolean F = false;
            do {
                System.out.println(""); //Login as Student or Professor, input must be 1, 2 or 3
                System.out.println("Press 1 for Professor");
                System.out.println("Press 2 for Student");
                System.out.println("Press 3 to exit");
                try {
                    answer = scanner1.nextInt();
                    scanner1.nextLine();
                    if (answer == 1 || answer == 2 || answer == 3) {
                        F = true;
                    } else {
                        System.out.println("Error: Expected 1, 2 or 3 as an answer.");
                    }
                } catch (InputMismatchException e) { //Handles exception
                    System.out.println("Error: Expected 1, 2 or 3 as an answer.");
                    scanner1.nextLine();
                }
            } while (F == false); //Runs while answer is not 3
            if (answer == 1) {
                int ans = pms.identify(); //IDs Professor
                if (ans != -1) {
                    Professor prof = Professor.proffessors[ans]; //Selects the professor
                    System.out.println("");
                    System.out.println("Hello, what would you like to do?");
                    int choice = 0;
                    do {
                        System.out.println(""); //Actions, must type 1,2,3 to run something
                        System.out.println("Press 1 to add exam");
                        System.out.println("Press 2 to see your info");
                        System.out.println("Press 3 to see Exams");
                        System.out.println("Press 4 or a bigger number to exit to log in");
                        try {
                            choice = scanner1.nextInt();
                            scanner1.nextLine();
                            if (choice == 1) { //Adds exam
                                System.out.println("");
                                pms.addExam(schedule, prof);
                            } else if (choice == 2) { //Shows info of professor
                                System.out.println("");
                                prof.displayInformation();
                            } else if (choice == 3){ //Shows exam
                                System.out.println("");
                                schedule.printSchedule();
                            } else if (choice == 0) { 
                                //Value if exception and keep it running, kind of a Logic error
                                System.out.println("");
                                System.out.println("Invalid choice, try again");
                            }
                        } catch (InputMismatchException e) { //Handles exception
                            scanner1.nextLine();
                            System.out.println("Invalid choice, try again");
                        }
                    } while (choice == 1 || choice == 2 || choice == 3 || choice == 0);
                } else {
                    System.out.println("Not a professor AM, going back to log in...");
                    //What to do if AM not in DB
                }
            } else if (answer == 2) {
                int ans = sms.identify(); //IDs Student
                if (ans != -1) {
                    Student stud = Student.students[ans];
                    System.out.println("");
                    System.out.println("Hello, what would you like to do?");
                    int choice = 0;
                    do {
                        System.out.println(""); //Actions
                        System.out.println("Press 1 to add Subject");
                        System.out.println("Press 2 to see your info");
                        System.out.println("Press 3 to see Exams");
                        System.out.println("Press 4 or a bigger number to exit to log in");
                        try {
                            choice = scanner1.nextInt();
                            scanner1.nextLine();
                            if (choice == 1) { //Adds subject
                                System.out.println("");
                                sms.addSubject(stud);
                            } else if (choice == 2) { //Shows info of student
                                System.out.println("");
                                sms.DisplayInfo(stud);
                            } else if (choice == 3){ //Shows exam schedule
                                System.out.println("");
                                schedule.printSchedule();
                            }
                        } catch (InputMismatchException e) { //Handles exception
                            scanner1.nextLine();
                            System.out.println("Invalid choice, try again");
                        }
                    } while (choice == 1 || choice == 2 || choice == 3 || choice == 0);
                } else {
                    System.out.println("Not a student AM, going back to log in...");
                    //What to do if AM not in the DB
                }
            }   
        } while (answer != 3);
        scanner1.close();
    }
}
