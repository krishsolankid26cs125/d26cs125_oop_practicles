public class Main {
    public static void main(String[] args) {
        try {
            Student student = CSVMapper.map("students.csv", Student.class);
            System.out.println("CSV Data Mapped Successfully!\n");
            student.display();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
