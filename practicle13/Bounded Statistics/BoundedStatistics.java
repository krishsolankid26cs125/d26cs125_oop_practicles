// Demonstrates bounded generics for numeric statistics
public class BoundedStatistics {
 
    // Generic method to calculate average of numeric arrays
    public static <N extends Number> double average(N[] values) {
 
        double sum = 0;
 
        // Calculate the sum of array elements
        for (N value : values) {
            sum += value.doubleValue();
        }
 
        // Return average
        return sum / values.length;
    }
 
    public static void main(String[] args) {
 
        // Integer array
        Integer[] integers = {10, 20, 30, 40, 50};
 
        // Double array
        Double[] decimals = {10.5, 20.5, 30.5, 40.5};
 
        // Long array
        Long[] longValues = {100L, 200L, 300L, 400L};
 
        // Display averages
        System.out.println("Integer Average: "
                + average(integers));
 
        System.out.println("Double Average: "
                + average(decimals));
 
        System.out.println("Long Average: "
                + average(longValues));
    }
}
