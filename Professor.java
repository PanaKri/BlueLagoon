import java.time.LocalDate;
import java.util.Arrays;

public class Professor {

    private String name;
    private String surname;
    private int am;
    private String[] courses;
    private LocalDate[] examDates;
<<<<<<< HEAD
    public static Professor[] proffessors;
    public static int profCount = 0;
    public Professor(String name, String surname, int am, String[] courses) {
        this.name=name;
        this.surname=surname;
        this.am=am;
        this.courses=courses;
=======

    public Professor(String name, String surname, int am, String... courses) {
        this.name = name;
        this.surname = surname;
        this.am = am;
        this.courses = courses;
>>>>>>> 2d5af314780f8a7bbadac41eec4584fec3f22f0e
        this.examDates = new LocalDate[courses.length];
        proffessors[profCount] = this;
        profCount++;
    }

    public void assignExamDate(int index, LocalDate date) {
        if (index >= 0 && index < courses.length) {
            examDates[index] = date;
        } else {
            System.err.println("Error: Invalid index for exam date assignment.");
        }
    }

    public void displayInformation() {
        System.out.println("Όνομα καθηγητή:" + name);
        System.out.println("Επίθετο καθηγητή:" + surname);
        System.out.println("Αριθμός Μητρώου Καθηγητή:" + am);
        System.out.println("Μαθήματα και ημερομηνίες εξέτασης:");
        for (int i=0; i < courses.length; i++) {
            System.out.println("-" + courses[i] + ":" + (examDates[i]!= null ? examDates[i] : "Not set"));
        }
    }    

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAm() {
        return am;
    }

    public String[] getCourses() {
        return courses.clone();
    }

    public LocalDate[] getExamDates() {
        return examDates.clone();
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", am=" + am +
                ", courses=" + Arrays.toString(courses) +
                ", examDates=" + Arrays.toString(examDates) +
                '}';
    }
}
