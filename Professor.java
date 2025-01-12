import java.time.LocalDate;
public class Professor {
    private String name;
    private String surname;
    private int am;
    private String[] courses;
    private LocalDate[] examDates;
    public static Professor[] proffessors;
    public static int profCount = 0;
    public Professor(String name, String surname, int am, String[] courses) {
        this.name=name;
        this.surname=surname;
        this.am=am;
        this.courses=courses;
        this.examDates = new LocalDate[courses.length];
        proffessors[profCount] = this;
        profCount++;
    }
    public void assignExamDate(int index, LocalDate date) {
        if (index >= 0 && index < courses.length) {
            examDates[index] = date;
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
}
