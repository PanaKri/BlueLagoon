import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DBTest {

    @Test
    void testAddInfo() {
        DB.addInfo();

        assertEquals(5, Room.getRoomCount(), "There should be 5 rooms added."); 
    }
}
