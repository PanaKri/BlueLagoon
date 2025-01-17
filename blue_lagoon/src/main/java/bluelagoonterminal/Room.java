package bluelagoonterminal;
public class Room {
    private int numberOfSeats;
    private static int roomNumber;    
        public boolean availability[][] = new boolean[5][5];
        public static Room[] rooms = new Room[10];
        public static int roomCount = 0;
        // Constructor
        public Room(int numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
            this.roomNumber = roomCount;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    this.availability[i][j] = true;
                }
            }
            rooms[roomCount] = this;
            this.roomNumber = roomCount;
            roomCount++;
        }
    
        public int getNumberOfSeats() {
            return numberOfSeats;
        }
    
        public void setNumberOfSeats(int numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
        }
    
        public static int getRoomNumber() {
            return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public boolean checkAvailability(int day, int hour, int r) {
        if (this.availability[day][hour] == true) {
            this.availability[day][hour] = false;
            System.out.println("Room " + r + " is available on Day " + (day + 1) + " "
            + "Hour " + (hour + 1) +  " ,set exam in this day on this room");
            return true;
        } else {
            System.out.println("Not available on day " + day + " Hour" + hour);
            return false;
        }
    }
}
