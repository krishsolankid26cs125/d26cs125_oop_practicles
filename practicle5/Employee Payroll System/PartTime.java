class PartTime extends Employee {
    double hours;
    double rate;
 
    PartTime(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
 
    @Override
    double monthlySalary() {
        return hours * rate;
    }
}
