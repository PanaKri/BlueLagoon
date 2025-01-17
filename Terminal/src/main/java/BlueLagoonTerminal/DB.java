package BlueLagoonTerminal;
public class DB {
    public static void addInfo() {
        Room room1 = new Room(128);
        Room room2 = new Room(134);
        Room room3 = new Room(100);
        Room room4 = new Room(96);
        Room room5 = new Room(90);
    }
    public static void addProfessor() {
        String[] s = {"Math", "Coding", "Statistics", "Logistics", "Management"};
        Professor professor = new Professor("Kostas", "Papadopoulos", 0, s );
    } 
    public static void addStudent() {
        Student student1 = new Student("Kostas", "Giannoulis", 0, 2023);
        Student student2 = new Student("Giannis", "Kostoulas", 1, 2023);
    }
    public static void addSubject() {
        Subject sub1 = new Subject(0, 114, 0, 0, "Math", 0, 0);
        Subject sub2 = new Subject(1, 130, 0, 0, "Coding", 0, 0);
        Subject sub3 = new Subject(2, 97, 0, 0, "Statistics", 0, 0);
        Subject sub4 = new Subject(3, 91, 0, 0, "Logistics", 0, 0);
        Subject sub5 = new Subject(4, 84, 0, 0, "Management", 0, 0);
    }
    public static void runDB(){
        addInfo();
        addProfessor();
        addStudent();
        addSubject();
    }
}
