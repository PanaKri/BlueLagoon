
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;
import java.lang.NumberFormatException;

public class StudentsPanel extends JPanel {
    private ArrayList<String> registeredCourses;
    private JButton add;
    private JButton view;
    private JButton logoutButton;
    private Student  student;
    JFrame frame = new JFrame();

    public StudentsPanel(Student student) {
        this.student = student;
        this.registeredCourses = new ArrayList();
        setLayout(new BorderLayout());
        
        JPanel pane = new JPanel(new GridLayout(3, 1, 10, 10));
        JTextField nameF = new JTextField();
        JLabel nameL = new JLabel("Name: " + student.getName(), JLabel.CENTER);
        JTextField surnameF = new JTextField();
        JLabel surnameL = new JLabel("Surname:" + student.getSurname());
        JTextField idF = new JTextField();
        JLabel idL = new JLabel("Student ID:" + student.getStudentID());
        JTextField yearF = new JTextField();
        JLabel yearL = new JLabel("Year of Admission:" + student.getYearOfAdmission());
        
        add = new JButton("Register Course");
        view = new JButton("View Registered Courses");
        logoutButton = new JButton("Log Out");
        
        add.addActionListener(e -> {
            try {
                String name = nameF.getText();
                String surname = surnameF.getText();
                String studentID = idF.getText();
                int yearOfAdmission = Integer.parseInt(yearF.getText());
                student.setName(name);
                student.setSurname(surname);
                student.setStudentID(studentID);
                student.setYearOfAdmission(yearOfAdmission);
                showStudentMenu(student);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid year of admission.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        pane.add(nameL);
        pane.add(surnameL);
        pane.add(idL);
        pane.add(yearL);
       
        pane.add(add);
        pane.add(logoutButton);
        pane.add(view);
        add(pane, BorderLayout.CENTER);

    }
    public static void changeTitle(JFrame frame, String name) {
        frame.setTitle(name);
    }
    public void showStudentMenu(Student student) {
        view.addActionListener(e -> showRegisteredCourses());
        logoutButton.addActionListener(e -> System.exit(0));
    }
    
    public void showCourseRegistration() {
        frame.getContentPane().removeAll();
        changeTitle(frame, "Register Course");
        
        JLabel courseL = new JLabel("Enter the course you want to get registered in:", JLabel.CENTER);
        JTextField courseF= new JTextField();//mporei na to kanw me choose the course kai na kanw slider kai na dialegei to mathima 
        JButton addCourse = new JButton("Add Course");
        JButton leaveB = new JButton("Get Back to Menu");

        JPanel registrationP = new JPanel();
        registrationP.setLayout(new GridLayout(3, 1, 10, 10));
        registrationP.add(courseL);
        registrationP.add(courseF);
        registrationP.add(addCourse);

        frame.add(registrationP, BorderLayout.CENTER);
        frame.add(leaveB, BorderLayout.SOUTH);

        addCourse.addActionListener(e -> {
            String course = courseF.getText();
            if (course.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Course name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (registeredCourses.size() >= 9) {
                JOptionPane.showMessageDialog(null, "You have reached the maximum number of courses to be registered", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                registeredCourses.add(course);
                JOptionPane.showMessageDialog(null, "Course added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                courseF.setText("");
            }
        });

        leaveB.addActionListener(e -> frame.dispose());

        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    public void showRegisteredCourses() {
        frame.getContentPane().removeAll();

        JLabel coursesL = new JLabel("Registered Courses:", JLabel.CENTER);
        JTextArea coursesA = new JTextArea();
        coursesA.setEditable(false);
        for (String course : registeredCourses) {
            coursesA.append(course + "\n");
        }

        JScrollPane scrollP = new JScrollPane(coursesA);
        JButton backB = new JButton("Back to Menu");

        frame.add(coursesL, BorderLayout.NORTH);
        frame.add(scrollP, BorderLayout.CENTER);
        frame.add(backB, BorderLayout.SOUTH);

        backB.addActionListener(e -> frame.dispose());

        frame.revalidate();
        frame.repaint();
    }
}
