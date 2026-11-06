class FullTime extends Employee {
    double salary;
 
    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }
 
    @Override
    double monthlySalary() {
        return salary;
    }
}
