public class Schedule {
    private int days = 5;
    private int times = 5;//9-7 available times by 2 hour intervals
    private String [][][][] examTimes; //day, time, room, inspector and subject
    public Schedule(int numOfRooms) { 
        examTimes = new String[days][times][numOfRooms][2];
        for (int index = 0; index < days; index++) {
            for (int index1 = 0; index1 < times; index1++) {
                for (int index2 = 0; index2 < numOfRooms; index2++) {
                    this.examTimes[index][index1][index2][0] = "None";
                    this.examTimes[index][index1][index2][1] = "None";
                }
            } 
        }
    }
    public void addExam(int day, int time, int roomCode, String inspectorName, String subjName) {
        if (this.examTimes[day][time][roomCode][0] == "None" & this.examTimes[day][time][roomCode][1] == "None" ) {
            this.examTimes[day][time][roomCode][0] = subjName;
            this.examTimes[day][time][roomCode][1] = inspectorName;
        } else {
            System.out.println("Exam already set");
        }
    }
    public void printSchedule() {
    }
}
