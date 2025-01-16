import java.util.Scanner;

public class StudentManagerSystem {
    Scanner input = new Scanner(System.in);
    private String choice;
    public int identify() {
        System.out.println("Type your AM");
        int am = input.nextInt();
        int AM = -1;
        for (int i = 0; i < Student.studCount; i++) {
            Student student = Student.students[i];
            if (student.getAM() == am) {
                AM = i;
            }
        }
        return AM;
    }
    public void addSubject(Student stud) {
        System.out.println("Please state which subject you want to get enrolled");
        choice = input.nextLine();
        boolean flag = false;
        int i = 0;
        Subject selection = Subject.subjects[i];
        do {
            Subject sub = Subject.subjects[i];
            String name = sub.getSubjectName();
            if (name == choice) {
                flag = true;
                selection = sub;
            } else {
                i = i + 1;
            }
        } while (flag = false & i < Subject.subjectCount);
        if (flag = true) {
            String answer = stud.getEnrolled(choice);
            selection.addStudent();
            System.out.println(answer);
        }
    }
    public void DisplayInfo(Student stud) {
        System.out.println(stud.displayInfo());
        System.out.println("Courses taken" + stud.displayCourses());
    }
}
