public class Schedule {
    private int days = 5;
    private int times = 11;//9-7 available times
    private boolean [][] examTimes;
    public Schedule() {
        examTimes = new boolean[days][times];
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < times; j++) {
                examTimes[i][j] = true;
            }
        }
    }
    public boolean CheckAvailableTime(int day, int time) {
        if (day < 0 || day >= days || time < 0 || time >= times) {
            System.out.println("no rooms available for this day and time");
            return false;
        }
        return examTimes[day][time];
    }
}