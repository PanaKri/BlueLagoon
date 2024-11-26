public class Inspector {
    int AM;
    int [][] availableHours = new int [10][10];
    int [][] roomNumbers = new int [10][10];
    public Inspector(int inputAM) {
        this.AM = inputAM;
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                availableHours[i][j] = 0;
            }
        }
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                roomNumbers[i][j] = 0;
            }
        }
    }
    public void setAvailableHours(int [][] inputMatrix) {
        this.availableHours = inputMatrix;
    }
    public void setRoomNumbers(int [][] inputMatrix2) {
        this.roomNumbers = inputMatrix2;
    }
    public void setAM(int inputAM2) {
        this.AM = inputAM2;
    }
    public int[][] getAvailableHours() {
        return this.availableHours;
    }
    public int[][] getRoomNumbers() {
        return this.roomNumbers;
    }
    public int getAM() {
        return this.AM;
    }
    public void addRoomAndHour(int roomNumber, int examHour, int examDate) {
        if (this.availableHours[examDate][examHour] == 0) {
            this.availableHours[examDate][examHour] = 1;
            this.roomNumbers[examDate][examHour] = roomNumber;
        } else {
            System.out.print("Inspector" + this.AM + "not available");
        }
    }
}
