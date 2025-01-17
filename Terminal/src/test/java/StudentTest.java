import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testConstructor() {
        Student student = new Student("Maria", "Papadopoulou", 12345, 2022);

        assertEquals("Maria", student.name);
        assertEquals("Papadopoulou", student.surname);
        assertEquals(12345, student.studentID);
        assertEquals(2022, student.yearOfAdmission);
        assertEquals(0, student.numbOfCourses);

        for (int i = 0; i < student.courses.length; i++) {
            assertEquals("None", student.courses[i]);
        }
        assertEquals(student, Student.students[0]);
        assertEquals(1, Student.studCount);
    }

    @Test
    public void testGetEnrolled_Success() {
        Student student = new Student("Maria", "Papadopoulou", 12345, 2022);
        String course = "Math";

        String result = student.getEnrolled(course);

        assertEquals("You have enrolled in: Math", result);
        assertEquals(course, student.courses[0]);
        assertEquals(1, student.numbOfCourses);
    }

    @Test
    public void testGetEnrolled_MaxCourses() {
        Student student = new Student("Maria", "Papadopoulou", 12345, 2022);

        for (int i = 0; i < 5; i++) {
            student.getEnrolled("Course" + (i + 1));
        }

        String result = student.getEnrolled("AnotherCourse");

        assertEquals("Max amount of courses reached", result);
    }

    @Test
    public void testDisplayInfo() {
        Student student = new Student("Maria", "Papadopoulou", 12345, 2022);

        String expectedInfo = "Maria Papadopoulou has student ID: 12345 and got registered in: 2022";
        String actualInfo = student.displayInfo();

        assertEquals(expectedInfo, actualInfo);
    }

    @Test
    public void testDisplayCourses_NoCourses() {
        Student student = new Student("Maria", "Papadopoulou", 12345, 2022);

        String enrolledCourses = student.displayCourses();

        assertEquals("", enrolledCourses); 
    }

    @Test
    public void testDisplayCourses_MultipleCourses() {
        Student student = new Student("Maria", "Papadopoulou", 12345, 2022);

        student.getEnrolled("Math");
        student.getEnrolled("Programming");

        String enrolledCourses = student.displayCourses();

        assertEquals("Math,Programming", enrolledCourses);
    }

    @Test
    public void testGetAM() {
        Student student = new Student("Maria", "Papadopoulou", 12345, 2022);

        int studentID = student.getAM();

        assertEquals(12345, studentID);
    }
}