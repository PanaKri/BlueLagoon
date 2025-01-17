import org.junit.Test;
import static org.junit.Assert.*;

public class MockProfessorManagerSystem {
    public int identify() {
        return 1; 
    }
    public void addExam(Schedule schedule, Professor prof) {
    }
}
public class MockStudentManagerSystem {
    public int identify() {
        return 2; 
    }
    public void addSubject(Student stud) {
    }
    public void DisplayInfo(Student stud) {
    }
}
public class MockSchedule {
    public void printSchedule() {
    }
}
public class ProgramMainTest {

    @Test
    public void testProfessorLoginAndExit() {
        ProgramMain.pms = new MockProfessorManagerSystem();
        
        Scanner scanner = new Scanner(System.in);
        System.setIn(new ByteArrayInputStream("1\n3\n".getBytes()));

        ProgramMain.main(new String[]{});

        scanner.close();
    }

    @Test
    public void testStudentLoginAndAddSubject() {
        ProgramMain.sms = new MockStudentManagerSystem();
        
        Scanner scanner = new Scanner(System.in);
        System.setIn(new ByteArrayInputStream("2\n1\n3\n".getBytes()));

        ProgramMain.main(new String[]{});

        scanner.close();
    }

    @Test
    public void testInvalidLogin() {
        Scanner scanner = new Scanner(System.in);
        System.setIn(new ByteArrayInputStream("4\n3\n".getBytes()));

        ProgramMain.main(new String[]{});
		
        scanner.close();
    }
}