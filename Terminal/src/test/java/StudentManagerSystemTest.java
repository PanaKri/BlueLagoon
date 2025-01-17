import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class StudentManagerSystemTest {

    @Test
    public void testIdentify_ValidAM() {
        Student[] students = new Student[2];
        students[0] = new Student("Maria", "Papadopoulou", 12345, 2022);
        students[1] = new Student("Giorgos", "Georgiou", 54321, 2021);
        Student.students = students;
        Student.studCount = students.length;

        StudentManagerSystem manager = new StudentManagerSystem();
        Scanner mockScanner = Mockito.mock(Scanner.class);
        Mockito.when(mockScanner.nextInt()).thenReturn(12345); 
        manager.input = mockScanner;

        int studentIndex = manager.identify();

        assertEquals(0, studentIndex); 
    }

    @Test
    public void testIdentify_InvalidAM() {
        Student[] students = new Student[2];
        students[0] = new Student("Maria", "Papadopoulou", 12345, 2022);
        students[1] = new Student("Giorgos", "Georgiou", 54321, 2021);
        Student.students = students;
        Student.studCount = students.length;

        StudentManagerSystem manager = new StudentManagerSystem();
        Scanner mockScanner = Mockito.mock(Scanner.class);
        Mockito.when(mockScanner.nextInt()).thenReturn(99999);
        manager.input = mockScanner;

        int studentIndex = manager.identify();

        assertEquals(-1, studentIndex); 
    }

    @Test
    public void testAddSubject_ValidSubject() {
        Student[] students = new Student[1];
        students[0] = new Student("Maria", "Papadopoulou", 12345, 2022);
        Student.students = students;
        Student.studCount = students.length;

        Subject[] subjects = new Subject[2];
        subjects[0] = new Subject("Math", 20);
        subjects[1] = new Subject("Programming", 30);
        Subject.subjects = subjects;
        Subject.subjectCount = subjects.length;

        StudentManagerSystem manager = new Mockito.mock(StudentManagerSystem.class);
        Student mockStudent = Mockito.mock(Student.class);
        Mockito.when(manager.identify()).thenReturn(0);
        Mockito.when(mockStudent.getEnrolled("Math")).thenReturn("You have enrolled in: Math");
        Mockito.doCallRealMethod().when(manager).addSubject(mockStudent);

        manager.addSubject(mockStudent);

        Mockito.verify(mockStudent).getEnrolled("Math");
        Mockito.verify(subjects[0]).addStudent();
    }

    @Test
    public void testAddSubject_InvalidSubject() {
        Student[] students = new Student[1];
        students[0] = new Student("Maria", "Papadopoulou", 12345, 2022);
        Student.students = students;
        Student.studCount = students.length;

        Subject[] subjects = new Subject[2];
        subjects[0] = new Subject("Math", 20);
        subjects[1] = new Subject("Programming", 30);
        Subject.subjects = subjects;
        Subject.subjectCount = subjects.length;

        StudentManagerSystem manager = new Mockito.mock(StudentManagerSystem.class);
        Student mockStudent = Mockito.mock(Student.class);
        Mockito.when(manager.identify()).thenReturn(0); 
        Mockito.when(mockStudent.getEnrolled("Accounting")).thenReturn("Course not found");
        Mockito.doCallRealMethod().when(manager).addSubject(mockStudent); 
        manager.addSubject(mockStudent);

        Mockito.verify(mockStudent).getEnrolled("Accounting");
    }