import java.util.Scanner;
public class ProfessorManagerSystem {
    Scanner scanner = new Scanner(System.in);
    public int identify() {
        System.out.println("Type your AM");
        int am = scanner.nextInt();
        int AM = -1;
        for (int i = 0; i < Professor.profCount; i++) {
            Professor professor = Professor.proffessors[i];
            if (professor.getAM() == am) {
                AM = i;
            }
        }
        return AM;
    }
    public void addExam(Schedule sched, Professor prof) {
        Subject selected = Subject.subjects[0];
        System.out.println("Type the exam subject:");
        String sub = scanner.nextLine();
        boolean f = false;
        for (int i = 0; i < Subject.subjects.length; i++) {
            Subject subject = Subject.subjects[i];
            if (subject.getSubjectName() == sub) {
                if (subject.getProfessorAm() == prof.getAM()) {
                    f = true;
                    selected = subject;
                }
            }
        }
        if (f == true) {
            System.out.println("When are you available for an exam? (Type day, time)");
            int d = scanner.nextInt();
            int t = scanner.nextInt();
            sched.addExam(selected, d, t);
        } else {
            System.out.println("You are not the professor of selected subject");
        }
    }
}
