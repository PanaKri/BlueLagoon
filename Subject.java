public class Subject {
    private int subjectCode;
    private int studentNumber;
    private int professorAM;
    public int examRoomNumber;
    private int examDate;
    private int examHour;
    public static Subject[] subjects;
    public static int subjectCount = 0;
    public Subject(int subCode, int studNumber, int proffAM, int roomNum) {
        this.subjectCode = subCode;
        this.studentNumber = studNumber;
        this.professorAM = proffAM;
        this.examRoomNumber = 0;
        subjects[subjectCount] = this;
        subjectCount++;
    }
    public void setExamRoomNumber(int num) {
        this.examRoomNumber = num;
    }
    public void setExamHour(int num) {
        this.examHour = num;
    }public void setExamDate(int num) {
        this.examDate = num;
    }
    public int getExamHour() {
        return examHour;
    }
    public int getExamDate() {
        return examDate;
    }    public int getExamRoomNumber() {
        return examRoomNumber;
    }
    public void getInfo() {
        System.out.println("this is subject " + subjectCode
        + " is taught by " + professorAM + " with enrolled " 
        + studentNumber + " students" + " taken in room "
        + examRoomNumber);
    }
}
