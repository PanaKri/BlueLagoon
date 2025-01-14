import java.util.Scanner;
public class Student {
    private String name;
    private String surname;
    private int studentID;
    private String course;
    private Scanner input = new Scanner(System.in);
    public int studentCount = 0;
    public static Student[] students; //Tracks all of the Students
    private String[] courses = new String[5]; //Keeps courses up to a max of 5
    int courseCount = 0;
    public Student(String name, String surname, int studentID) {
       this.name = name;
       this.surname = surname;
       this.studentID = studentID;
       students[studentCount] = this;
       studentCount = studentCount + 1;
    }
    public String getEnrolled() { //Adds student to a subject
        if (courseCount < 5) {
            System.out.println("Enter the course you want to get enrolled in:");
            course = input.nextLine();
            System.out.println("You have enrolled in:" + " " + course); 
            courses[courseCount] = course;
            courseCount = courseCount + 1;
            return course;
        } else {
            return "You have reached the maximum amount of courses";
        }
    }
    @Override public String toString() {
        return name + " " + surname + " " + "has student ID: " + studentID;
    }
}
