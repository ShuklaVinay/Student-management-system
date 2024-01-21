package studentmanageMentApplication;

public class StudentModel {
    private int rollnum;
    private String name;
    private String college;
    private String city;
    private double percentage;
    StudentModel(){

    }
    StudentModel(String name,String college,String city,double percentage){
        this.name=name;
        this.college=college;
        this.city=city;
        this.percentage=percentage;
    }
    StudentModel(String name,String college,String city){
        this.name=name;
        this.college=college;
        this.city=city;
    }
    StudentModel(int rollnum,String name,String college,String city,double percentage){
        this.rollnum=rollnum;
        this.name=name;
        this.college=college;
        this.city=city;
        this.percentage=percentage;
    }

    public int getRollnum() {
        return rollnum;
    }

    public void setRollnum(int rollnum) {
        this.rollnum = rollnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "rollnum=" + rollnum +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", city='" + city + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
