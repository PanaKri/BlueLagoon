public class Subject {
    private int subjectCode;
    private int studentNumber;
    private String subjectName;
    private int professorAM;
    public static Subject[] subjects;
    public static int subjectCount = 0;
    public Subject(int subCode, int studNumber, int proffAM, int roomNum, String name) {
        this.subjectName = name;
        this.subjectCode = subCode;
        this.studentNumber = studNumber;
        this.professorAM = proffAM;
        subjects[subjectCount] = this;
        subjectCount++;
    }
    public String getSubjectName() {
        return this.subjectName;
    }
    public int getSubjectCode() {
        return this.subjectCode;
    }
    public int getStudentNumber() {
        return studentNumber;
    }
    public void getInfo() {
        System.out.println("this is subject " + subjectCode
        + " is taught by " + professorAM + " with enrolled " 
        + studentNumber + " students");
    }
}
