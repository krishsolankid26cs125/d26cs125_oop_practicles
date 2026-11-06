import java.util.Objects;
 
public class Point {
 
    private int x;
    private int y;
 
    // Constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    // Display point coordinates
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
 
    // Compare two points
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
 
        if (!(obj instanceof Point)) {
            return false;
        }
 
        Point other = (Point) obj;
 
        return x == other.x && y == other.y;
    }
 
    // Generate hash code
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
