package studentmanageMentApplication;

import java.util.Scanner;
public class StudentMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StudentDaoInterface dao=new StudentDao();
        System.out.println("!!!!Welcome To Student Management System!!!!");
        while (true){
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Get Student based on rollnum");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit From Application\n");
            System.out.print("Enter your choice :");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Add Students :->");
                    System.out.print("enter student name:");
                    String name=sc.next();
                    System.out.print("enter college name:");
                    String college=sc.next();
                    System.out.print("enter city name:");
                    String city=sc.next();
                    System.out.print("enter student percentage:");
                    double percentage=sc.nextDouble();
                   StudentModel sm=new StudentModel(name,college,city,percentage);
                     dao.insertStudent(sm);
                    break;
                case 2:
                    System.out.println("\nShow All Students:->");
                    dao.showAllStudent();
                    break;
                case 3:
                    System.out.println("Get Student based on Rollnum:->");
                    System.out.print("enter Rollnum:");
                    int rollnum=sc.nextInt();
                   boolean f= dao.showStudentById(rollnum);
                   if(!f){
                       System.out.println("entered rollnum is not exists in the system.");
                   }
                    break;
                 case 4:
                     System.out.println("Update Student:->");
                     System.out.println("\n1.Update name"+"\n2.Update college"+"\n3.update city");
                     System.out.print("enter your choice:");
                     int choice=sc.nextInt();
                     switch (choice){
                         case 1:
                         System.out.println("enter roll number");
                         int rnum=sc.nextInt();
                         System.out.println("Enter new name");
                         String name1=sc.next();
                         StudentModel std=new StudentModel();
                         std.setName(name1);
                         boolean flag=  dao.updateStudent(rnum,name1,choice,std);
                         if(flag)
                             System.out.println("Name updated successfully");
                         else
                             System.out.println("Something went wrong...");
                         break;
                         case 2:
                             System.out.println("enter roll number");
                             int rolln=sc.nextInt();
                             System.out.println("enter new college:");
                             String coll=sc.next();
                             StudentModel sm1=new StudentModel();
                             sm1.setCollege(coll);
                             boolean flag1=  dao.updateStudent(rolln,coll,choice,sm1);
                             if(flag1)
                                 System.out.println("college updated successfully");
                             else
                                 System.out.println("Something went wrong...");
                             break;
                              case 3:
                                  System.out.println("enter rollno.");
                                  int rolln1=sc.nextInt();
                                  System.out.println("enter new city:");
                                  String city1=sc.next();
                                  StudentModel sm2=new StudentModel();
                                 sm2.setCity(city1);
                             boolean flag2=  dao.updateStudent(rolln1,city1,choice,sm2);
                             if(flag2)
                                 System.out.println("city updated successfully");
                             else
                                 System.out.println("Something went wrong...");
                             break;
                         default:
                             System.out.println("wrong choice.");

                     }
                     break;
                case 5:
                    System.out.println("Delete Student:->");
                    System.out.println("enter roll number to delete:");
                    int rollnum2=sc.nextInt();
                    boolean ff=dao.deleteStudent(rollnum2);
                    if(ff)
                        System.out.println("Record deleted successfully...");
                    else
                        System.out.println("Something went wrong");
                    break;
                case 0:

                    System.out.println("Thank you for using Student Management System!!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your entered choice is wrong ! Enter valid choice.");
            }
        }
    }
}
