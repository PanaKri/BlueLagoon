import org.junit.Test;
import static org.junit.Assert.*;

public class ProfessorManagerSystemTest {

    @Test
    public void testIdentify_ValidAM() {
        ProfessorManagerSystem manager = new ProfessorManagerSystem();
        Professor.proffessors = new Professor[]{new Professor(1234)};
        Professor.profCount = 1;

        int identifiedProfessorIndex = manager.identify(1234);
        assertEquals(0, identifiedProfessorIndex);
    }

    @Test
    public void testIdentify_InvalidAM() {
        ProfessorManagerSystem manager = new ProfessorManagerSystem();
        Professor.proffessors = new Professor[]{new Professor(5678)};
        Professor.profCount = 1;

        int identifiedProfessorIndex = manager.identify(1234);
        assertEquals(-1, identifiedProfessorIndex);
    }

    @Test
    public void testAddExam_ValidProfessorSubject() {
        ProfessorManagerSystem manager = new ProfessorManagerSystem();
        Professor professor = new Professor(1234);
        Schedule schedule = new Schedule();
        Subject[] subjects = new Subject[]{new Subject("Math", 1234)};
        Subject.subjects = subjects;

        manager.addExam(schedule, professor);

        assertEquals(1, schedule.exams.size());
        assertEquals(subjects[0], schedule.exams.get(0).subject);
    }

    @Test
    public void testAddExam_InvalidProfessorSubject() {
        ProfessorManagerSystem manager = new ProfessorManagerSystem();
        Professor professor = new Professor(1234);
        Schedule schedule = new Schedule();
        Subject[] subjects = new Subject[]{new Subject("Programming", 5678)};
        Subject.subjects = subjects;

        manager.addExam(schedule, professor);

        assertEquals(0, schedule.exams.size());
    }
}