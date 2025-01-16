import java.util.Scanner;
public class ProgramMain {
    static StudentManagerSystem sms = new StudentManagerSystem();
    static ProfessorManagerSystem pms = new ProfessorManagerSystem();
    static Schedule schedule = new Schedule();
    public static void main (String [] args) {
        int answer = 0;
        Scanner scanner1 = new Scanner(System.in);
        do {
            boolean F = false;
            do {
                System.out.println("Press 1 for Professor");
                System.out.println("Press 2 for Student");
                System.out.println("Press 3 to exit");
                answer = scanner1.nextInt();
                if (answer == 1 || answer == 2 || answer == 3) {
                    F = true;
                } else {
                    System.out.println("Error: Expected 1, 2 or 3 as an answer.");
                }
            } while (F == false);
            if (answer == 1) {
                int ans = pms.identify();
                if (ans != -1) {
                    Professor prof = Professor.proffessors[ans];
                    System.out.println("Hello, what would you like to do?");
                    System.out.println("Press 1 to add exam");
                    System.out.println("Press 2 to see yout info");
                    System.out.println("Press 3 to see Exams");
                    System.out.println("Press anything else to exit to log in");
                    int choice = scanner1.nextInt();
                    if (choice == 1) {
                        pms.addExam(schedule, prof);
                    } else if (choice == 2) {
                        prof.displayInformation();
                    } else if (choice == 3){
                        schedule.printSchedule();
                    }
                } else {
                    System.out.println("Not a professor AM, going back to log in...");
                }
            } else if (answer == 2) {
                int ans = sms.identify();
                if (ans != -1) {
                    Student stud = Student.students[ans];
                    System.out.println("Hello, what would you like to do?");
                    System.out.println("Press 1 to add Subject");
                    System.out.println("Press 2 to see yout info");
                    System.out.println("Press 3 to see Exams");
                    System.out.println("Press anything else to exit to log in");
                    int choice = scanner1.nextInt();
                    if (choice == 1) {
                        sms.addSubject(stud);
                    } else if (choice == 2) {
                        sms.DisplayInfo(stud);
                    } else if (choice == 3){
                        schedule.printSchedule();
                    }
                } else {
                    System.out.println("Not a student AM, going back to log in...");
                }
            }   
        } while (answer != 3);
        scanner1.close();
    }
}
