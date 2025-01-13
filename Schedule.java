public class Schedule {
    private int days = 5;
    private int times = 5;//9-7 available times by 2 hour intervals
    private int numOfRooms = 5;
    private String [][][] examTimes; //day, time, room, subject and inspector
    public Schedule() { //Constructor
        examTimes = new String[days][times][numOfRooms];
        for (int index = 0; index < days; index++) {
            for (int index1 = 0; index1 < times; index1++) {
                for (int index2 = 0; index2 < numOfRooms; index2++) {
                    this.examTimes[index][index1][index2] = "None";
                }
            } 
        }
    }
    public void addExam(int day, int time, int roomCode, String subjName) { //Availability Check
        if (this.examTimes[day][time][roomCode] == "None") {
            this.examTimes[day][time][roomCode] = subjName;
        } else {
            System.out.println("Exam already set");
        }
    }
    public void printSchedule() { //For cmd line
        for (int d = 0; d < 5; d++) {
            System.out.println("Day" + "" + d); // Prints day up top
            for (int t = 0; t < 5; t++) {
                System.out.print("Zone" + "" + t); //Prints time below day
                for (int r = 0; r < 5; r++) {
                    if (examTimes[d][t][r] != "None") {
                        System.out.print("Course:" + examTimes[d][t][r] + ""
                        + "Room:" + r); //Prints Course and room next to zone
                    }
                }
                System.out.println(""); //Line change
            }
        }
    }
    public String[][] scheduleArray() {
        String[][] scheduleArr = new String[30][6];
        int h = 0;//Tracks the hour based on row
        for (int i = 0; i < 30; i++) {
            if (i % 6 == 0) { //Top rows are the days
                scheduleArr[i][0] = "DAY" + i;
                h = 0;
            } else {
                h = h + 1;
                for (int j = 0; j < 6; j++) {
                    if (j % 5 == 0) { //Time on the left
                        scheduleArr[i][j] = "HOUR" + h;
                    } else {
                        if (examTimes[i % 6][h][j] != "None") {
                            scheduleArr[i][j] =  examTimes[i % 6][h][j] + ","
                            + " Room" + (j - 1); //Saves subject and Room
                        } else {
                            scheduleArr[i][j] = ""; //Displays Nothing
                        }
                    }
                }
            }
            
        }
        return scheduleArr; 
    }
}
