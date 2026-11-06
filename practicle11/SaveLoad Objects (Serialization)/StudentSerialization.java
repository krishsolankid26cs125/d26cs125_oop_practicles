// Demonstrates serialization and deserialization of Student objects
import java.io.*;
 
class Student implements Serializable {
 
    // Serialization version identifier
    private static final long serialVersionUID = 1L;
 
    String name;
    int enrollmentNumber;
    double marks;
 
    // Transient field is excluded from serialization
    transient String password;
 
    // Constructor to initialize student details
    Student(String name, int enrollmentNumber, double marks,
            String password) {
        this.name = name;
        this.enrollmentNumber = enrollmentNumber;
        this.marks = marks;
        this.password = password;
    }
 
    // Display student information
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Enrollment Number: " + enrollmentNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Password: " + password);
        System.out.println("---------------------------");
    }
}
 
public class StudentSerialization {
 
    public static void main(String[] args) {
 
        // Create an array of Student objects
        Student[] students = {
            new Student("Mann Patel", 126, 85.5, "mann123"),
            new Student("Rahul Shah", 127, 90.0, "rahul456"),
            new Student("Priya Patel", 128, 88.5, "priya789")
        };
 
        // Save the student array to a file
        try (ObjectOutputStream out =
                new ObjectOutputStream(
                    new FileOutputStream("students.dat"))) {
 
            out.writeObject(students);
            System.out.println("Student objects saved successfully.");
 
        } catch (IOException e) {
            System.out.println("Error saving objects: " + e.getMessage());
        }
 
        // Read the student array back from the file
        try (ObjectInputStream in =
                new ObjectInputStream(
                    new FileInputStream("students.dat"))) {
 
            Student[] restoredStudents =
                    (Student[]) in.readObject();
 
            System.out.println("\\nRestored Student Details:");
 
            // Display restored objects
            for (Student student : restoredStudents) {
                student.display();
            }
 
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading objects: " + e.getMessage());
        }
    }
}
