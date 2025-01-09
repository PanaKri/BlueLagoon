public class Subject {
    private int subjectCode;
    private int studentNumber;
    private int professorAM;
    public int examRoomNumber;
    public Subject(
        int subCode, int studNumber, int proffAM, int roomNum) {
        this.subjectCode = subCode;
        this.studentNumber = studNumber;
        this.professorAM = proffAM;
        this.examRoomNumber = 0;
    }
    public void setExamRoomNumber(int num) {
        this.examRoomNumber = num;
    }
    public void getInfo() {
        System.out.println("this is subject " + subjectCode
        + " is taught by " + professorAM + " with enrolled " 
        + studentNumber + " students" + " taken in room "
        + examRoomNumber);
    }
}
