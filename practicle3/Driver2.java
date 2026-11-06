public class Driver2 {
 
    public static void main(String[] args) {
 
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 6);
 
        System.out.println("Fraction 1: " + f1);
        System.out.println("Fraction 2: " + f2);
        System.out.println("Fraction 3: " + f3);
 
        System.out.println("Are all fractions equal? "
                + (f1.equals(f2) && f2.equals(f3)));
 
        Fraction f4 = new Fraction(2, 4);
 
        System.out.println("new Fraction(2,4) prints \"" + f4
                + "\" and equals new Fraction(1,2): "
                + f4.equals(f1));
    }
}
