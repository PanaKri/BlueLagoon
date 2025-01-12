import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class Login extends JFrame {
    JTextField username =new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");
    
    public Login() {
        super("Login");
        setSize(400,300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel usernamel = new JLabel("Username:");
        JLabel passwordl = new JLabel("Password:");

        panel.add(usernamel);
        panel.add(username);
        panel.add(passwordl);
        panel.add(password);
        
        JPanel centralp = new JPanel(new BorderLayout());
        centralp.add(panel, BorderLayout.CENTER);
       
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER,10, 10));
        panel2.add(ok);
        panel2.add(cancel);
        centralp.add(panel2, BorderLayout.SOUTH);
       
        
        add(centralp, BorderLayout.CENTER);
       


        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectStudentData();
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
    private void collectStudentData() {
        String name = JOptionPane.showInputDialog(this, "Enter your name:");
        String surname = JOptionPane.showInputDialog(this, "Enter your surname:");
        String studentID = JOptionPane.showInputDialog(this, "Enter your student ID:");
        String year = JOptionPane.showInputDialog(this, "Enter your year of admission:");
        int yearOfAdmission;
        try {
            yearOfAdmission = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid year. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Student student = new Student(name, surname, studentID, yearOfAdmission);
        changePanel(student);
    }

    private void changePanel(Student student) {
        getContentPane().removeAll();
        StudentsPanel.changeTitle(this, "Student Menu");
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        StudentsPanel studentPanel = new StudentsPanel(student);
        pane.add(studentPanel);
        add(pane);
        studentPanel.showStudentMenu(student);
        revalidate();
        repaint();
    }
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Login.setLookAndFeel();
        new Login();
    }
}
