import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Student {
    private String name;
    private String surname;
    private String studentID;
    private int yearOfAdmission;
    private int numbOfCourses;
    private String course;
    private String currentSemester;
    private List<String> courses;
    
    String answer;
    Scanner input = new Scanner(System.in);
    public Student(String name, String surname, String studentID, int yearOfAdmission) {
       this.name = name;
       this.surname = surname;
       this.studentID = studentID;
       this.yearOfAdmission = yearOfAdmission; 
       this.courses = new ArrayList<>();
    }
    public Object getName() {
        return name;
    }
    public Object getSurname() {
        return surname;
    }
    public Object getStudentID() {
        return studentID;
    }
    public Object getYearOfAdmission() {
        return yearOfAdmission;
    }
    public void setName(String name) {
        this.name = name; 
    }
    public void setSurname(String surname) {
        this.surname = surname; 
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID; 
    }
    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission; 
    }
    public List<String> getCourses() {
        return courses;
    }

    public void getEnrolled() {
        do {
            System.out.println("Enter the semester you are currently traversing (Winter, Spring):");
            currentSemester = input.nextLine();
            if (!currentSemester.equals("Winter") && !currentSemester.equals("Spring")) {
                System.out.println("Invalid semester.Please enter 'Winter' or 'Spring'.");
            }
        } while (!currentSemester.equals("Winter") && !currentSemester.equals("Spring"));
        do {
            System.out.println("Enter the course you want to get enrolled in:");
            course = input.nextLine();
            numbOfCourses = numbOfCourses + 1;
            System.out.println("You have enrolled in:" + " " + course); 
            System.out.println("Do you want to enroll in another course?(Yes,No)");
            answer = input.nextLine();
        } while(numbOfCourses < 15 && answer.equals("Yes") );
        System.out.println("You have enrolled in:" + " " + numbOfCourses + " " + "courses.");
    }
    @Override public String toString() {
        return name + " " + surname + " " + "has student ID: " + studentID + "and got registered in: " + yearOfAdmission;
    }
}
