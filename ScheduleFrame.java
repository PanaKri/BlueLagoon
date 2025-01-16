import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScheduleFrame extends JFrame {
    private static JButton ok;
    private static JButton exit;
    
    Connection connection = null;
    Statement statement = null ;
    ResultSet resultS = null;

    public ScheduleFrame() {
        //create frame 
        super("Course Selection");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel(new FlowLayout());
    
        //create components
        JLabel label = new JLabel("Select the name of the course you want to see the exam process info:");
        
        //load courses into the dropdown
        JComboBox<String> courseDropdown = chooseCourse();

        ok = new JButton("OK");
        exit = new JButton("Exit");

         //add action to the buttons 
         ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosenCourse = (String) courseDropdown.getSelectedItem();

                if (chosenCourse != null) {
                    //new frame to display the details for the course examination
                    courseDetails(chosenCourse);
                } else {
                    JOptionPane.showMessageDialog(courseDropdown, "No details found for the selected course.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pane.add(label);
        pane.add(courseDropdown);
        pane.add(ok);
        pane.add(exit);
        this.add(pane);

        this.setVisible(true);
    }

     //jdcb url, username and password of MySQL database//
     private static final String dbUser= "root";
     private static final String dbPassword= "sevasti_LAMPROS!23";
     private static final String url = "jdbc:mysql://localhost:3306/JAVA";

    private static List<Subject> subjectList = new ArrayList<>();
   
     //a method to establish a connection with the database and initializes the connection object
    public  JComboBox<String> chooseCourse() {

        JComboBox<String> courseDropdown = new JComboBox<>();
        //Dynamically load the driver's class file into memory //
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(java.lang.ClassNotFoundException e) { 
            System.out.println("ClassNotFoundException: " + e.getMessage());
            System.exit(0);
        }

        try {
            connection = DriverManager.getConnection(url, dbUser, dbPassword);		
		} catch (SQLException e) {			
			System.out.println("SQLException: " + e.getMessage());
		}
        //execute SQL statements 
        try {           
            statement = connection.createStatement();
            resultS = statement.executeQuery("SELECT course_name FROM COURSE" );
            
            while (resultS.next()) {
                //adding the available courses to the dropdown
                courseDropdown.addItem(resultS.getString("course_name"));
            }

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage());
        } finally {
            // close resources
            try {
                if (resultS != null) resultS.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
        return courseDropdown;
    }
    private void courseDetails(String subjectName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("ClassNotFoundException" + e.getMessage());
            System.exit(0);
        }
        try {
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            statement = connection.createStatement();
    
            resultS = statement.executeQuery("SELECT * FROM COURSE WHERE course_name = '" + subjectName + "';");
    
            if (resultS.next()) {
                String examTime = resultS.getString("exam_time");
                String examDate = resultS.getString("exam_date");
                int subjectCode = resultS.getInt("course_id");
                int studentNumber = resultS.getInt("student_number");
                int professorAM = resultS.getInt("professor_am");
                int examRoomNumber = resultS.getInt("exam_room");
                String courseName = resultS.getString("course_name");
                
                Subject subject = new Subject(subjectCode, studentNumber, professorAM, examRoomNumber, courseName, examDate, examTime);
                subjectList.add(subject);
                DB info = new DB();
                info.addInfo();
                int d = 0;
                int t = 0;
                showSchedule(subject, d, t);

            } else {
                JOptionPane.showMessageDialog(null, "No details found for the selected course.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close resources
            try {
                if (resultS != null) resultS.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

   
    private void showSchedule(Subject subject, int d, int t) {
        Schedule s = new Schedule();
        s.addExam(subject, d, t);
        String[][] scheduleArray = s.scheduleArray();
        
        JFrame scheduleF = new JFrame("Exam Schedule");
        scheduleF.setSize(600, 400);

        String[] columnNames = {"Day", "Time", "Room 1", "Room 2", "Room 3", "Room 4", "Room 5"};
        JTable scheduleT = new JTable(scheduleArray, columnNames);
        JScrollPane scrollP= new JScrollPane(scheduleT);

        scheduleF.add(scrollP);
        scheduleF.setVisible(true);
    }

    public static void main(String[] args) {
        new ScheduleFrame();
    }
}
