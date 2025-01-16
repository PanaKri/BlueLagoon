import java.util.Scanner;

public class StudentManagerSystem {
    Scanner input = new Scanner(System.in);
    private String choice;
    public void addSubject(Student stud) {
        System.out.println("Please state which subject you want to get enrolled");
        choice = input.nextLine();
        boolean flag = false;
        int i = 0;
        do {
            Subject sub = Subject.subjects[i];
            String name = sub.getSubjectName();
            if (name == choice) {
                flag = true;
            } else {
                i = i + 1;
            }
        } while (flag = false & i < Subject.subjectCount);
        if (flag = true) {
            String answer = stud.getEnrolled(choice);
            System.out.println(answer);
        }
    }
    public void DisplayInfo(Student stud) {
        System.out.println(stud.displayInfo());
        System.out.println("Courses taken" + stud.displayCourses());
    }
}
