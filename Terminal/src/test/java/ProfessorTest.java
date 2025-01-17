import org.junit.Test;
import static org.junit.Assert.*;

public class ProfessorTest {

    @Test
    public void testConstructor() {
        String[] courses = {"Math (10/11/2024)", "Programming (12/12/2024)"};
        Professor professor = new Professor("Maria", "Papadopoulou", 12345, courses);
        assertEquals("Maria", professor.name);
        assertEquals("Papadopoulou", professor.surname);
        assertEquals(12345, professor.am);
        assertEquals(courses, professor.courses);
        assertEquals(professor, Professor.proffessors[0]);
        assertEquals(1, Professor.profCount);
    }

    @Test
    public void testDisplayInformation() {
        String[] courses = {"Math (10/11/2024)", "Programming (12/12/2024)"};
        Professor professor = new Professor("Maria", "Papadopoulou", 12345, courses);
        professor.displayInformation();
        String expectedOutput = "Name: Maria\n" +
                                "Last name: Papadopoulou\n" +
                                "AM: 12345\n" +
                                "Course and date:\n" +
                                "- Math (10/11/2024)\n" +
                                "- Programming (12/12/2024)\n";
    }

    @Test
    public void testGetAM() {
        String[] courses = {"Math (10/11/2024)", "Programming(12/12/2024)"};
        Professor professor = new Professor("Maria", "Papadopoulou", 12345, courses);
        int am = professor.getAM();
        assertEquals(12345, am);
    }
}