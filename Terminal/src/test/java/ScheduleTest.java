import org.junit.Test;
import static org.junit.Assert.*;

public class ScheduleTest {

    @Test
    public void testConstructor() {
        Schedule schedule = new Schedule();

        for (int i = 0; i < schedule.days; i++) {
            for (int j = 0; j < schedule.times; j++) {
                for (int k = 0; k < schedule.numOfRooms; k++) {
                    assertEquals("None", schedule.examTimes[i][j][k]);
                }
            }
        }
    }

    @Test
    public void testAddExam_AvailableSlot() {
        Subject subject = new Subject("Math", 20);
        Room[] rooms = {
                new Room(30), new Room(25), new Room(20), new Room(15), new Room(10)
        };
        Room.rooms = rooms; 
        Room.roomCount = rooms.length; 
        Schedule schedule = new Schedule();

        schedule.addExam(subject, 0, 0); 

        assertEquals("Math", schedule.examTimes[0][0][4]); 
    }

    @Test
    public void testAddExam_NoAvailableSlot() {
        Subject subject = new Subject("Math", 20);
        Room[] rooms = {
                new Room(10), new Room(10), new Room(10), new Room(10), new Room(10)
        };
        Room.rooms = rooms;
        Room.roomCount = rooms.length;
        Schedule schedule = new Schedule();
        schedule.addExam(subject, 0, 0);
    }

    @Test
    public void testPrintSchedule() {
        Schedule schedule = new Schedule(); 
        schedule.printSchedule(); 
    }

    @Test
    public void testScheduleArray() {
        Schedule schedule = new Schedule();
        String[][] scheduleArr = schedule.scheduleArray();
    }
}