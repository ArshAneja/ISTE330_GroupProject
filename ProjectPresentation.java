import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class ProjectPresentation {

   projectSQLDatabase dl = new projectSQLDatabase();
   //private int columns;
   //private int rows;

   public static Font myFontForOutput = new Font("Courier", Font.BOLD, 20);


   public ProjectPresentation(){
      
      
      
      
      JPanel Inputbox = new JPanel(new GridLayout(3,2));
      JLabel lblUser     = new JLabel("Username -> ");
      JLabel lblPassword = new JLabel("Password -> ");
      JTextField tfUser     = new JTextField("root");
             //JTextField tfPassword = new JTextField("");
      JTextField tfPassword = new JPasswordField("");
      JLabel lblDatabase    = new JLabel("Database ->");
      JTextField tfDatabase = new JTextField("academicSkills");
     
      Inputbox.add(lblUser);
      Inputbox.add(tfUser);
      Inputbox.add(lblPassword);
      Inputbox.add(tfPassword);
      Inputbox.add(lblDatabase);
      Inputbox.add(tfDatabase);
     
      lblUser.setFont(myFontForOutput);
      tfUser.setFont(myFontForOutput);
      tfUser.setForeground(Color.BLUE);
      lblPassword.setFont(myFontForOutput);
      tfPassword.setFont(myFontForOutput);
      tfPassword.setForeground(Color.BLUE);
      lblDatabase.setFont(myFontForOutput);
      tfDatabase.setFont(myFontForOutput);
      tfDatabase.setForeground(Color.BLUE);
     
     
      JOptionPane.showMessageDialog(null, Inputbox,
          "Input    Default password is \"student\"", JOptionPane.QUESTION_MESSAGE);
     
     
      String userName = tfUser.getText();
      String database = tfDatabase.getText();  

          
          
      String password = new String();
      String passwordInput = new String();
              
      passwordInput = tfPassword.getText();
              
      // set the default password to   "student"
      if (passwordInput.equalsIgnoreCase("")) {
         password = "student";                  //CHANGE TO STUDENT
      } 
      else 
      {
         password = passwordInput;
      }
      
      dl.connect(userName,password,database);  //Call DataLayer
      System.out.println("You have connected to the database!");
      String fs = ""; //faculty or student checker
      
      dl.seeFaculty();
      dl.searchFacultySkills(1);
      
      
      
      
      
      
      
      
      
      
      
      
                       
      
   } // End of Constructor

   public static void main(String [] args){
         

      java.util.Date today = new java.util.Date();
      System.out.println("Program ran @ " + today + "\nProject \n");
   
      new ProjectPresentation();  // Create a new object. An Instantiation
   } // End of main method
} // End of Class
