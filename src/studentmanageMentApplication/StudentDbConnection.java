package studentmanageMentApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDbConnection {
    static Connection con;
  static   String url="jdbc:mysql://localhost:3306/student_db";
   static String user="root";
   static String password="Vinay@123";
    public static Connection createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url,user,password);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return con;
    }

}
