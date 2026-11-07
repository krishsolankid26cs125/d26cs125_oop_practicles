// Demonstrates generic containers and a generic array method
public class GenericContainers {
 
    // Generic Box class
    static class Box<T> {
 
        private T value;
 
        // Set the value
        public void set(T value) {
            this.value = value;
        }
 
        // Get the value
        public T get() {
            return value;
        }
    }
 
    // Generic Pair class
    static class Pair<A, B> {
 
        private A first;
        private B second;
 
        // Constructor to initialize both values
        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
 
        // Get first value
        public A getFirst() {
            return first;
        }
 
        // Get second value
        public B getSecond() {
            return second;
        }
    }
 
    // Generic method to return the first element of an array
    public static <T> T getFirstElement(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
 
        return array[0];
    }
 
    public static void main(String[] args) {
 
        // Demonstrate Box with Integer
        Box<Integer> integerBox = new Box<>();
        integerBox.set(100);
 
        System.out.println("Integer Box: " + integerBox.get());
 
        // Demonstrate Box with String
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Java");
 
        System.out.println("String Box: " + stringBox.get());
 
        // Demonstrate Pair with different data types
        Pair<String, Integer> student =
                new Pair<>("Mann", 21);
 
        System.out.println("\\nStudent Pair:");
        System.out.println("Name: " + student.getFirst());
        System.out.println("Age: " + student.getSecond());
 
        // Demonstrate generic method with Integer array
        Integer[] numbers = {10, 20, 30};
 
        System.out.println("\\nFirst Integer: "
                + getFirstElement(numbers));
 
        // Demonstrate generic method with String array
        String[] names = {"Krish", "Rajvi", "Priyal"};
 
        System.out.println("First String: "
                + getFirstElement(names));
    }
}
