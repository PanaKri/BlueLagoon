package BlueLagoonTerminal;
import java.util.InputMismatchException;
import java.util.Scanner;
//java -jar target/Terminal-1.0-SNAPSHOT.jar
//mvn clean install
public class ProgramMain {
    DB db = new DB();
    static StudentManagerSystem sms = new StudentManagerSystem();
    static ProfessorManagerSystem pms = new ProfessorManagerSystem();
    static Schedule schedule = new Schedule();
    public static void main (String [] args) throws InputMismatchException {
        DB.runDB();
        DB.addSubject();
        int answer = 0;
        Scanner scanner1 = new Scanner(System.in);
        do {
            boolean F = false;
            do {
                System.out.println("");
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
                } catch (InputMismatchException e) {
                    System.out.println("Error: Expected 1, 2 or 3 as an answer.");
                    scanner1.nextLine();
                }
            } while (F == false);
            if (answer == 1) {
                int ans = pms.identify();
                if (ans != -1) {
                    Professor prof = Professor.proffessors[ans];
                    System.out.println("");
                    System.out.println("Hello, what would you like to do?");
                    int choice = 0;
                    do {
                        System.out.println("");
                        System.out.println("Press 1 to add exam");
                        System.out.println("Press 2 to see your info");
                        System.out.println("Press 3 to see Exams");
                        System.out.println("Press 4 or a bigger number to exit to log in");
                        try {
                            choice = scanner1.nextInt();
                            scanner1.nextLine();
                            if (choice == 1) {
                                System.out.println("");
                                pms.addExam(schedule, prof);
                            } else if (choice == 2) {
                                System.out.println("");
                                prof.displayInformation();
                            } else if (choice == 3){
                                System.out.println("");
                                schedule.printSchedule();
                            } else if (choice == 0) {
                                System.out.println("");
                                System.out.println("Invalid choice, try again");
                            }
                        } catch (InputMismatchException e) {
                            scanner1.nextLine();
                            System.out.println("Invalid choice, try again");
                        }
                    } while (choice == 1 || choice == 2 || choice == 3 || choice == 0);
                } else {
                    System.out.println("Not a professor AM, going back to log in...");
                }
            } else if (answer == 2) {
                int ans = sms.identify();
                if (ans != -1) {
                    Student stud = Student.students[ans];
                    System.out.println("");
                    System.out.println("Hello, what would you like to do?");
                    int choice = 0;
                    do {
                        System.out.println("");
                        System.out.println("Press 1 to add Subject");
                        System.out.println("Press 2 to see your info");
                        System.out.println("Press 3 to see Exams");
                        System.out.println("Press 4 or a bigger number to exit to log in");
                        try {
                            choice = scanner1.nextInt();
                            scanner1.nextLine();
                            if (choice == 1) {
                                System.out.println("");
                                sms.addSubject(stud);
                            } else if (choice == 2) {
                                System.out.println("");
                                sms.DisplayInfo(stud);
                            } else if (choice == 3){
                                System.out.println("");
                                schedule.printSchedule();
                            }
                        } catch (InputMismatchException e) {
                            scanner1.nextLine();
                            System.out.println("Invalid choice, try again");
                        }
                    } while (choice == 1 || choice == 2 || choice == 3 || choice == 0);
                } else {
                    System.out.println("Not a student AM, going back to log in...");
                }
            }   
        } while (answer != 3);
        scanner1.close();
    }
}
