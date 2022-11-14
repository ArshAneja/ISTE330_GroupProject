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


   //Yunhao
   public int search(){
      return 3;
   }
   //Zaher
   public int delete(){
      return 3;
   }
   //Zaher
   public int add(){
      return 3;
         } // End of getResultSet
   
   //Arsh
   public int update() {
   return 3;
        }// end of method to add a student

   
   
   
   
   
   
   
   
   
   



 
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
  
} // End of Class   DataLayer2.java