import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {

    @Test
    public void testConstructor() {
        Room room = new Room(30);
        assertEquals(30, room.getNumberOfSeats());
        assertEquals(0, room.getRoomNumber()); 

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertTrue(room.availability[i][j]);
            }
        }
        assertEquals(1, Room.roomCount); 
    }

    @Test
    public void testGettersAndSetters() {
        Room room = new Room(20);

        room.setNumberOfSeats(25);
        assertEquals(25, room.getNumberOfSeats());
    }

    @Test
    public void testCheckAvailability_Available() {
        Room room = new Room(30);
        assertTrue(room.checkAvailability(0, 0, room.getRoomNumber())); 
        assertFalse(room.availability[0][0]); 
    }

    @Test
    public void testCheckAvailability_NotAvailable() {
        Room room = new Room(30);
        room.availability[1][2] = false; 
        assertFalse(room.checkAvailability(1, 2, room.getRoomNumber())); 
    }
}