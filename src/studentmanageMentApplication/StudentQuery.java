package studentmanageMentApplication;

public class StudentQuery {
    static String insertQuery="insert into student_details(name,college,city,percentage) values (?,?,?,?)";
    static String selectQuery="select * from student_details";
    static String selectRollnumQuery="select * from student_details where rollnum=?";
    static String updateQuery="update student_details set name=?,college=?,city where rollnum=?";
    static String deleteQuery="delete student_details where rollnum=?";
}
