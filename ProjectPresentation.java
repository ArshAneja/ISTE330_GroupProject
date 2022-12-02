import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.security.MessageDigest;

public class ProjectPresentation {

   ProjectSQLDatabase dl = new ProjectSQLDatabase();
   //private int columns;
   //private int rows;

   public static Font myFontForOutput = new Font("Courier", Font.BOLD, 20);
   
   
   //Encrypt password
   public static String encrypt(String secret){//Endcypt password
      String sha1 = "";
      String value = new String(secret);
      try {
         MessageDigest digest = MessageDigest.getInstance("SHA-1");
         digest.reset();
         digest.update(value.getBytes("utf8"));
         sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
      } catch (Exception e){
         e.printStackTrace();
      }// end of catch
   
      //System.out.println( "The sha1 of \""+ value + "\" is:");
      //System.out.println("--->" + sha1 );
      //System.out.println();
      return sha1;
   }//end of encrypt
   
  


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
      String emailCheck = ""; // Email checker
      String passwordCheck = ""; //Password checker
      String Faculty = "Faculty"; //Used for database.
      String Student = "Student"; // Used for database.
      int op; // Faculty options
      int fid; //Faculty id
      String one = "";
      String two = "";
      String three = "";
   
      System.out.print("Are you a (f)aculty, (s)tudent, (n)ew user, or  a (g)uest? ");
      fs = GetInput.readLine();
      
      
      
      
      //Faculty
      if(fs.equals("f")){
         //Gets login credentials
         System.out.print("Please enter your email: ");
         emailCheck = GetInput.readLine();
         System.out.print("Please enter your password: ");
         passwordCheck = GetInput.readLine();
         //Encrypt the password
         String encrypted = encrypt(passwordCheck);
         
         //Checks database and login in.
         if (encrypted.equals(dl.FacultyLogin(emailCheck))){
            
            System.out.print("\nHello, "+ dl.FacultyName(emailCheck));
            
            //menu when logged in
            while(true){
               System.out.println("\n1. Update your information\n2. Update your abstract\n3. Add an abstract \n4. Add a skill\n5. Delete abstract \n6. See other faculty's skills \n7. Logout \nYour option: ");
               op = GetInput.readLineInt();
               
               if(op==1){
                  String fname = "";
                  String lname = "";
                  String email = "";
                  String office = "";
                  int id = dl.FacultyID(emailCheck);
                  System.out.print("Please enter your first name:");
                  fname = GetInput.readLine();
                  System.out.print("Please enter your last name:");
                  lname = GetInput.readLine();
                  System.out.print("Please enter your email:");
                  email = GetInput.readLine();
                  System.out.print("Please enter your office Location:");
                  office = GetInput.readLine();
                  dl.updateFaculty(fname,lname,email,office,id);
               }
               
               if(op==2){
                  String name = "";
                  String summary = "";
                  int id = dl.FacultyID(emailCheck);
                  System.out.print("Please enter the name of the abstract:");
                  name = GetInput.readLine();
                  System.out.print("Please enter the summary:");
                  summary = GetInput.readLine();
                  dl.updateAbstract(name,summary,id);
               
               }
               
               if(op==3){
                  int aid = dl.FacultyID(emailCheck);
                  int id = dl.FacultyID(emailCheck);
                  String name = "";
                  String summary = "";
                  System.out.print("Please enter the name of the abstract:");
                  name = GetInput.readLine();
                  System.out.print("Please enter the summary:");
                  summary = GetInput.readLine();
                  dl.addAbstract(aid,id,name,summary);
                  
               
               }
               if(op==4){
                  int id = dl.FacultyID(emailCheck); 
                  String skill = "";
                  System.out.print("Please enter the number that you would like to add: ");
                  dl.seeSkillsTable();
                  skill = GetInput.readLine();
                  dl.addSkill(id,skill);
               
               }
               
               if(op==5){
                  String yn = "";
                  int id = dl.FacultyID(emailCheck);
                  System.out.print("Are you sure you want to delete all of your abstracts? (y or n)");
                  yn = GetInput.readLine();
                  if(yn.equals("y")){
                     dl.deleteAbstract(id);
                     
                  }
                  else{
                     continue;
                  }
               }
               if(op==6){
                  System.out.print("Enter a skill 1: ");
                  one = GetInput.readLine();
                  System.out.print("Enter a skill 2: ");
                  two = GetInput.readLine();
                  System.out.print("Enter a skill 3: ");
                  three = GetInput.readLine();
                  
                  dl.searchSkills(one);
                  dl.searchSkills(two);
                  dl.searchSkills(three);
               
               }
               
               if(op==7){ // Exit
                  System.exit(0);
               }
            }
         }
         else{
            System.out.print("\nSomething went wrong, try again!");
         }
      }
      
      
      
      
      
      
      //Student
      if(fs.equals("s")){
         //Gets login credentials
         System.out.print("Please enter your email: ");
         emailCheck = GetInput.readLine();
         System.out.print("Please enter your password: ");
         passwordCheck = GetInput.readLine();
         
         //Checks database and login in.
         if (passwordCheck.equals(dl.StudentLogin(emailCheck))){
            System.out.print("\nHello, "+ dl.StudentName(emailCheck));
            
            //menu
            while(true){
               System.out.println("\n1. Update your information?\n2. Search for a faculty and see his skills\n3. Search faculty based on skills\n4. Logout\n\nYour option: ");
               op = GetInput.readLineInt();
               
               if(op == 1){
                  String fname = "";
                  String lname = "";
                  String email = "";
                  String gpa = "";
                  int id = dl.StudentID(emailCheck);
                  System.out.print("Please enter your first name:");
                  fname = GetInput.readLine();
                  System.out.print("Please enter your last name:");
                  lname = GetInput.readLine();
                  System.out.print("Please enter your email:");
                  email = GetInput.readLine();
                  System.out.print("Please enter your gpa:");
                  gpa = GetInput.readLine();
                  dl.updateStudent(fname,lname,email,gpa,id);
               
               }
            
               if(op ==2){
                  //Shows faculty in the database
                  dl.seeFaculty();
                  System.out.print("Please enter the professor's ID: ");
                  fid = GetInput.readLineInt();
                  //shows his skills
                  dl.searchFacultySkills(fid);
               }
               if(op==3){
                  System.out.print("Enter a skill 1: ");
                  one = GetInput.readLine();
                  System.out.print("Enter a skill 2: ");
                  two = GetInput.readLine();
                  System.out.print("Enter a skill 3: ");
                  three = GetInput.readLine();
                  
                  dl.searchSkills(one);
                  dl.searchSkills(two);
                  dl.searchSkills(three);
               }
            
               if(op==4){ // Exit
                  System.exit(0);
               }
            }
         
            
            
            
            
            
            
         }
         else{
            System.out.print("\nSomething went wrong, try again!");
         }
      }
      if(fs.equals("g")){
         System.out.print("\nHello Guest!\nPlease select an option:\n1. Search for student skills\n2. Search faculty based n skills\n");
         op = GetInput.readLineInt();
         if(op == 1){
            System.out.print("Enter a skill 1: ");
            one = GetInput.readLine();
            System.out.print("Enter a skill 2: ");
            two = GetInput.readLine();
            System.out.print("Enter a skill 3: ");
            three = GetInput.readLine();
            
         }
         if(op == 2){
            System.out.print("Enter a skill 1: ");
            one = GetInput.readLine();
            System.out.print("Enter a skill 2: ");
            two = GetInput.readLine();
            System.out.print("Enter a skill 3: ");
            three = GetInput.readLine();
                  
            dl.searchSkills(one);
            dl.searchSkills(two);
            dl.searchSkills(three);
         }

      }
      
      
      
      
      
      
      
      
      
      
      
      
                       
      
   } // End of Constructor

   public static void main(String [] args){
         
   
      java.util.Date today = new java.util.Date();
      System.out.println("Program ran @ " + today + "\nProject \n");
   
      new ProjectPresentation();  // Create a new object. An Instantiation
   } // End of main method
} // End of Class
