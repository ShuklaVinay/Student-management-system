package studentmanageMentApplication;

public interface StudentDaoInterface {
    public void insertStudent(StudentModel s);
    public void showAllStudent();
    public boolean showStudentById(int rollnum);
    public boolean updateStudent(int roll,String update,int ch,StudentModel s);
    public boolean deleteStudent(int rollnum);
}
