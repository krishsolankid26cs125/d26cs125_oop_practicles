import java.util.Objects;
 
public class Fraction {
 
    private int num;
    private int den;
 
    // Constructor
    public Fraction(int num, int den) {
 
        int gcd = gcd(num, den);
 
        this.num = num / gcd;
        this.den = den / gcd;
    }
 
    // Calculate GCD
    private int gcd(int a, int b) {
 
        a = Math.abs(a);
        b = Math.abs(b);
 
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
 
        return a;
    }
 
    // Display fraction
    @Override
    public String toString() {
        return num + "/" + den;
    }
 
    // Compare fractions
    @Override
    public boolean equals(Object obj) {
 
        if (this == obj) {
            return true;
        }
 
        if (!(obj instanceof Fraction)) {
            return false;
        }
 
        Fraction other = (Fraction) obj;
 
        return num == other.num && den == other.den;
    }
 
    // Generate hash code
    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }
}
