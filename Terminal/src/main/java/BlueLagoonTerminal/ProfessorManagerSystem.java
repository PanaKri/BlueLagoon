package BlueLagoonTerminal;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ProfessorManagerSystem {
    Scanner scanner = new Scanner(System.in);
    public int identify() {
        try {
            System.out.println("");
            System.out.println("Type your AM");
            int am = scanner.nextInt();
            scanner.nextLine();
            int AM = -1;
            for (int i = 0; i < Professor.profCount; i++) {
                Professor professor = Professor.proffessors[i];
                if (professor.getAM() == am) {
                    AM = i;
                }
            }
            return AM;
        } catch (InputMismatchException e) {
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
            if (subject.getSubjectCode() == sub) {
                if (subject.getProfessorAm() == prof.getAM()) {
                    f = true;
                    selected = subject;
                }
            }
        }
        if (f == true) {
            boolean check = selected.checkExam();
            if (check == false) {
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
        }
    }
}
