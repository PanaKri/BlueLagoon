public class Room {
    public static int numberOfRooms = 0;
    private int numberOfSeats;
    private int roomNumber;    
    public boolean availability[][];
    // Constructor
    public Room(int numberOfSeats, int roomNumber, String selectedInstructor) {
        numberOfRooms += 1;
        this.numberOfSeats = numberOfSeats;
        this.roomNumber = numberOfRooms;
        this.availability = new boolean[5][5];
        for (int index = 0; index < availability.length; index++) {
            for (int index1 = 0; index1 < availability.length; index++) {
                availability[index][index1] = true;
            }
        }
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String checkAvailability(int day, int hour,int numOfStudents) {
        if (this.availability[day][hour] == true & numOfStudents <= numberOfSeats) {
            this.availability[day][hour] = false;
            return ("The room is available, set exam in this day on this room");
        } else {
            return ("Not available or not enough seats");
        }
    }
}
