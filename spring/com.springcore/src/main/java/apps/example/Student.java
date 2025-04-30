package apps.example;

// this is my first spring project

public class Student {
    private String studentId;
    private String studentName;
    private String studentAddress;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        System.out.println("setting studentId");
        this.studentId = studentId;


    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
       System.out.println("setting studentName");
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        System.out.println("setting studentAddress");
        this.studentAddress = studentAddress;
    }

    public Student(String studentId, String studentName, String studentAddress) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
    }

    public Student() {
        super();;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                '}';
    }
}





