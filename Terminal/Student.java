public class Student {
    private String name;
    private String surname;
    private int studentID;
    private int yearOfAdmission;
    private int numbOfCourses = 0;
    private String[] courses = new String[5];
    public static Student[] students= new Student[10];
    public static int studCount = 0;
    public Student(String name, String surname, int studentID, int yearOfAdmission) {
       this.name = name;
       this.surname = surname;
       this.studentID = studentID;
       this.yearOfAdmission = yearOfAdmission; 
       for (int i = 0; i < 5; i++) {
        courses[i] = "None";
       }
       students[studCount] = this;
       studCount = studCount + 1;
    }
    public String getEnrolled(String s) {
        if (numbOfCourses < 5) {
            courses[numbOfCourses] = s;
            numbOfCourses = numbOfCourses + 1;
            return "You have enrolled in:" + " " + s;
        } else {
            return "Max amount of courses reached";
        }
    }
    public String displayInfo() {
        return name + " " + surname + " " + "has student ID: " + studentID
        + "and got registered in: " + yearOfAdmission;
    }
    public String displayCourses() {
        String s = courses[0];
        int i = 1;
        if (courses[i] != "None") {
            do {
                s = s + courses[i];
                i = i + 1;
            } while (courses[i] != "None" & i < 5);
        }
        return s;
    }
    public int getAM() {
        return this.studentID;
    }
}