public class Subject {
    private int subjectCode;
    private int studentNumber;
    private String courseName;
    private int professorAM;
    public static Subject[] subjects;
    public static int subjectCount = 0;
    public Subject(int subjectCode, int studNumber, int professorAM, int examrRoomNum, String courseName, String examDate, String examTime) {
        this.courseName = courseName;
        this.subjectCode = subjectCode;
        this.studentNumber = studNumber;
        this.professorAM = professorAM;
        subjects[subjectCount] = this;
        subjectCount++;
    }
    public String getSubjectName() {
        return this.courseName;
    }
    public int getSubjectCode() {
        return this.subjectCode;
    }
    public int getStudentNumber() {
        return studentNumber;
    }
    public int getProfessorAm() {
        return professorAM;
    }
    public void getInfo() {
        System.out.println("this is subject " + subjectCode
        + " is taught by " + professorAM + " with enrolled " 
        + studentNumber + " students");
    }
}