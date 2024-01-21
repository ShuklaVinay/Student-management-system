package studentmanageMentApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao implements StudentDaoInterface{

    @Override
    public void insertStudent(StudentModel s) {
        try {
            Connection con = StudentDbConnection.createConnection();
            PreparedStatement ps=con.prepareStatement(StudentQuery.insertQuery);
            ps.setString(1,s.getName());
            ps.setString(2,s.getCollege());
            ps.setString(3,s.getCity());
            ps.setDouble(4,s.getPercentage());
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Student added in college_db successfully!!!!");
            }
            else {
                System.out.println("Somethings went to wrong! Student addition Failed.");
            }
            ps.close();
            con.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
      //  return false;
    }
    @Override
    public void showAllStudent() {
        try{
            Connection con=StudentDbConnection.createConnection();
            PreparedStatement ps=con.prepareStatement(StudentQuery.selectQuery);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                System.out.println("Rollnum:"+rs.getInt("rollnum"));
                System.out.println("Name:"+rs.getString("name"));
                System.out.println("College:"+rs.getString("college"));
                System.out.println("City:"+rs.getString("city"));
                System.out.println("Percentage:"+rs.getDouble("percentage"));
                System.out.println("++++++++++++++++++++++++++++++++++++++");
            }
            rs.close();
            ps.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean showStudentById(int rollnum) {
        boolean flag=false;
        try{
            Connection con=StudentDbConnection.createConnection();
            String query="select * from student_details where rollnum="+rollnum;
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                System.out.println("Rollnum:"+rs.getInt(1));
                System.out.println("Name:"+rs.getString(2));
                System.out.println("College:"+rs.getString(3));
                System.out.println("City:"+rs.getString(4));
                System.out.println("percentage:"+rs.getDouble(5));
                flag=true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateStudent(int roll, String update, int ch, StudentModel s) {
        int choice=ch;
        boolean flag=false;
        try{
            if(choice==1){
                Connection con=StudentDbConnection.createConnection();
                String query="update student_details set name=? where rollnum=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,update);
                ps.setInt(2,roll);
                ps.executeUpdate();
                flag=true;
            }
            if(choice==2){
                Connection con=StudentDbConnection.createConnection();
                String query="update student_details set college=? where rollnum=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,update);
                ps.setInt(2,roll);
                ps.executeUpdate();
                flag=true;
            }
            if(choice==3){
                Connection con=StudentDbConnection.createConnection();
                String query="update student_details set city=? where rollnum=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,update);
                ps.setInt(2,roll);
                ps.executeUpdate();
                flag=true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteStudent(int rollnum) {
        boolean flag=false;
        try{
            Connection con=StudentDbConnection.createConnection();
            String query="delete from student_details where rollnum="+rollnum;
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
            flag=true;

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }
}
