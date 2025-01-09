public class Room {
    private int numberOfSeats;
    private int roomNumber;    
    private String selectedInstructor;

    // Constructor
    public Room(int numberOfSeats, int roomNumber, String selectedInstructor) {
        this.numberOfSeats = numberOfSeats;
        this.roomNumber = roomNumber;
        this.selectedInstructor = selectedInstructor;
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

    public String getSelectedInstructor() {
        return selectedInstructor;
    }

    public void setSelectedInstructor(String selectedInstructor) {
        this.selectedInstructor = selectedInstructor;
    }
}
