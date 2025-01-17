package bluelagoonterminal;
public class Professor {
    private String name;
    private String surname;
    private int am;
    private String[] courses = new String[5];
    public static Professor[] proffessors = new Professor[5];
    public static int profCount = 0;
    public Professor(String name, String surname, int am, String[] courses) {
        this.name=name;
        this.surname=surname;
        this.am=am;
        this.courses=courses;
        proffessors[profCount] = this;
        profCount++;
    }
    public void displayInformation() {
        System.out.println("Name:" + name);
        System.out.println("Surename:" + surname);
        System.out.println("ID:" + am);
        System.out.println("Courses:");
        for (int i=0; i < courses.length; i++) {
            System.out.println("-" + courses[i]);
        }
    }
    public int getAM() {
        return this.am;
    }
}
