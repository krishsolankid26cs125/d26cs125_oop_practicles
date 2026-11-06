public class Student {

    @Column(name = "StudentName")
    private String name;

    @Column(name = "EnrollmentNo")
    private String enrollmentNo;

    @Column(name = "Branch")
    private String branch;

    public void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Enrollment No: " + enrollmentNo);
        System.out.println("Branch: " + branch);
    }
}
