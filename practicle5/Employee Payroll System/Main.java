public class Main {
    public static void main(String[] args) {
 
        Employee[] employees = {
            new FullTime("Rahul", 40000),
            new PartTime("Priya", 100, 120),
            new Intern("Amit", 8000)
        };
 
        double totalPayroll = 0;
 
        for (Employee employee : employees) {
 
            double salary = employee.monthlySalary();
 
            System.out.println("Employee Name: " + employee.name);
            System.out.println("Monthly Salary: " + salary);
 
            if (employee instanceof Intern) {
                System.out.println("Note: Intern - Training Period");
            }
 
            System.out.println();
 
            totalPayroll += salary;
        }
 
        System.out.println("Total Payroll: " + totalPayroll);
    }
}
