import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SubjectTest {

    @Test
    void testConstructorAndGetters() {
        Subject subject = new Subject(1, 30, 123, 1, "Math", 20250110, 1500);

        assertEquals(1, subject.getSubjectCode());
        assertEquals(30, subject.getStudentNumber());
        assertEquals(123, subject.getProfessorAm());
        assertEquals("Math", subject.getSubjectName());
    }

    @Test
    void testAddStudent() {
        Subject subject = new Subject(1, 30, 123, 1, "Math", 20250110, 1500);

        subject.addStudent();  // Add one student

        assertEquals(31, subject.getStudentNumber());
    }

    @Test
    void testGetInfo() {
        Subject subject = new Subject(1, 30, 123, 1, "Math", 20250110, 1500);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        subject.getInfo();

        String expectedOutput = "this is subject 1 is taught by 123 with enrolled 30 students\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testStaticVariables() {
        Subject subject1 = new Subject(1, 30, 123, 1, "Math", 20250110, 1500);
        Subject subject2 = new Subject(2, 25, 456, 102, "Programming", 20250220, 1400);

        assertEquals(2, Subject.subjectCount);
        assertEquals("Math", Subject.subjects[0].getSubjectName());
        assertEquals("Programming", Subject.subjects[1].getSubjectName());
    }
}
