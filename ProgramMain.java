import java.util.Scanner;
public class ProgramMain {
    public static void main (String [] args) {
        Scanner scanner1 = new Scanner(System.in);
        boolean F = false;
        do {
            System.out.println("Press 1 for Professor");
            System.out.println("Press 2 for Student");
            System.out.println("Press 3 to exit");
            int Answer = scanner1.nextInt();
            if (Answer == 1 || Answer == 2 || Answer == 3) {
                F = true;
            } else {
                System.out.println("Error: Expected 1, 2 or 3 as an answer.");
            }
        } while (F == false);
        scanner1.close();
    }
}
