import java.sql.*;

public class projectSQLDatabase{
   private Connection conn;
   private ResultSet rs;
   private Statement stmt;
   private String sql;
   private int col;

   final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

   public projectSQLDatabase(){
   }//end of constructor

   
   public boolean connect(String user, String password, String database){
      conn = null;
     
      String url = "jdbc:mysql://localhost/" + database;
   
      try{
         Class.forName(DEFAULT_DRIVER);
         System.out.println("CLASSPATH is set correctly!");
         
         conn = DriverManager.getConnection(url, user, password);
         System.out.println("\nCreated Connection!\n");
      }// end of try block
      catch(ClassNotFoundException cnfe){
         System.out.println("ERROR, CAN NOT CONNECT!!");
         System.out.println("Class");
         System.out.println("ERROR MESSAGE-> "+cnfe);
         System.exit(0);
      }// end of the first catch block
      catch(SQLException sqle){
         System.out.println("ERROR SQLExcepiton in connect()");
         System.out.println("ERROR MESSAGE -> "+sqle);
         // sqle.printStackTrace();
         System.exit(0);
      }//end of  Second catch block
   
      return (conn!=null);
   } // End of connect method
   
   
   // Arsh --  Faculty login
   public String FacultyLogin(String email){
      String password = "";
      try {
         PreparedStatement stmt2;
      
         stmt2 = conn.prepareStatement("select password from Faculty where email = (?)");
         stmt2.setString(1,email);
      
         ResultSet info = stmt2.executeQuery();
         while(info.next()) {
         
         // 6) Retrieve resultset data
         
            password = info.getString(1);
           
           
         
         }//end of while loop
      
      }// end of try
      catch(SQLException sqle)
      {
         System.out.println("Error message is --> "+sqle+"\n");
         sqle.printStackTrace();
      }//end of catch
      
      return password;
   
   }
      // Arsh --  Faculty name shows up when logging in
   public String FacultyName(String email){
      String firstName = "";
      try {
         PreparedStatement stmt2;
      
         stmt2 = conn.prepareStatement("select firstName from Faculty where email = (?)");
         stmt2.setString(1,email);
      
         ResultSet info = stmt2.executeQuery();
         while(info.next()) {
         
         // 6) Retrieve resultset data
         
            firstName = info.getString(1);
           
           
         
         }//end of while loop
      
      }// end of try
      catch(SQLException sqle)
      {
         System.out.println("Error message is --> "+sqle+"\n");
         sqle.printStackTrace();
      }//end of catch
      
      return firstName;
   
   }
   // Arsh --  student name shows up when logging in
   public String StudentName(String email){
      String firstName = "";
      try {
         PreparedStatement stmt2;
      
         stmt2 = conn.prepareStatement("select firstName from Student where email = (?)");
         stmt2.setString(1,email);
      
         ResultSet info = stmt2.executeQuery();
         while(info.next()) {
         
         // 6) Retrieve resultset data
         
            firstName = info.getString(1);
           
           
         
         }//end of while loop
      
      }// end of try
      catch(SQLException sqle)
      {
         System.out.println("Error message is --> "+sqle+"\n");
         sqle.printStackTrace();
      }//end of catch
      
      return firstName;
   
   }
   
   

   
    // Arsh --  Student login
   public String StudentLogin(String email){
      String password = "";
      try {
         PreparedStatement stmt2;
      
         stmt2 = conn.prepareStatement("select password from Student where email = (?)");
         stmt2.setString(1,email);
      
         ResultSet info = stmt2.executeQuery();
         while(info.next()) {
         
         // 6) Retrieve resultset data
         
            password = info.getString(1);
           
           
         
         }//end of while loop
      
      }// end of try
      catch(SQLException sqle)
      {
         System.out.println("Error message is --> "+sqle+"\n");
         sqle.printStackTrace();
      }//end of catch
      
      return password;
   
   }







   //Yunhao
   public int search(){
      return 3;
   }
   
   
       
   //Arsh -- Student's can search based on the faculty's id
   public void searchFacultySkills(int id){
      try {
         PreparedStatement stmt2;
      
         stmt2 = conn.prepareStatement("SELECT Faculty.firstName, group_concat(Skill.skill_name separator' | ') AS 'Skill' From Skill inner join Faculty_Skill on Faculty_Skill.skill_id = Skill.skill_id inner join Faculty on Faculty_Skill.faculty_id = Faculty.faculty_id where Faculty.faculty_id = (?);");
         stmt2.setInt(1,id);
      
         ResultSet info = stmt2.executeQuery();
         while(info.next()) {
         
         // 6) Retrieve resultset data
         
            String name = info.getString(1);
            String skill = info.getString(2);
           
            System.out.print("\nNAME\t\t\tSKILLS" );
            System.out.print("\n"+name+"\t\t\t" + skill+ "\n");
         
         }//end of while loop
      
      }// end of try
      catch(SQLException sqle)
      {
         System.out.println("Error message is --> "+sqle+"\n");
         sqle.printStackTrace();
      }//end of catch
   
   }
   
   //Arsh -- Student's can see professor's names and see their id's so they can search.
   public void seeFaculty(){
      try {
         PreparedStatement stmt2;
         stmt2 = conn.prepareStatement("select faculty_id,firstName,lastName from faculty;");
         ResultSet info = stmt2.executeQuery();
         while(info.next()) {
         
         // 6) Retrieve resultset data
         
            String id = info.getString(1);
            String fname = info.getString(2);
            String lname = info.getString(3);
           
            System.out.print("ID: "+ id + "\t\t" + fname + " " + lname+ "\n");
         
         }//end of while loop
      
      }// end of try
      catch(SQLException sqle)
      {
         System.out.println("Error message is --> "+sqle+"\n");
         sqle.printStackTrace();
      }//end of catch
   
   }


   
   
   //Zaher
   public int delete(){
      return 3;
   }
   //Zaher
   public int add(){
      return 3;
   } // End of getResultSet
   
   
   
   
   
   //Josh
   public int updateFaculty(String fName, String lName, String email, String officeNum, int id) {
      int returnInt = -1;
      try{
         String updateString = "UPDATE Faculty SET firstname=?, lastname=?, email=?, officeNum=? WHERE faculty_id = ?";
         PreparedStatement ps = conn.prepareStatement(updateString);
         ps.setString(1, fName);
         ps.setString(2, lName);
         ps.setString(3, email);
         ps.setString(4, officeNum);
         ps.setInt(5, id);
         returnInt = ps.executeUpdate();
      }catch(Exception e){
         System.out.println("Update Faculty Failed: "+e);
      }
      return returnInt;
   }// end of method to update a faculty
   
   //Josh
   public int updateStudent(String fName, String lName, String email, String grade, int id) {
      int returnInt = -1;
      try{
         String updateString = "UPDATE Student SET firstname=?, lastname=?, email=?, grade=? WHERE student_id = ?";
         PreparedStatement ps = conn.prepareStatement(updateString);
         ps.setString(1, fName);
         ps.setString(2, lName);
         ps.setString(3, email);
         ps.setString(4, grade);
         ps.setInt(5, id);
         returnInt = ps.executeUpdate();
      }catch(Exception e){
         System.out.println("Update Student Failed: "+e);
      }
      return returnInt;
   }// end of method to update student
   
   //Josh
   public int updateAbstract(String name, String summary, int id) {
      int returnInt = -1;
      try{
         String updateString = "UPDATE Student SET abstractName=?, abstractSummary=? WHERE abstract_id = ?";
         PreparedStatement ps = conn.prepareStatement(updateString);
         ps.setString(1, name);
         ps.setString(2, summary);
         ps.setInt(3, id);
         returnInt = ps.executeUpdate();
      }catch(Exception e){
         System.out.println("Update Abstract Failed: "+e);
      }
      return returnInt;
   }// end of method to update abstract
   
   
   

   //CLOSE
   public void close(){
      try {
         rs.close();
         stmt.close();
         conn.close();
         
      }
      catch(SQLException sqle){
         System.out.println("ERROR IN METHOD close()");
         System.out.println("ERROR MESSAGE -> "+sqle);
         
      }// end of catch
      
   }//end of method close
  
} // End of Class
