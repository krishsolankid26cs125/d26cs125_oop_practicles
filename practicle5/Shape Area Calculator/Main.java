public class Main {
    public static void main(String[] args) {
 
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(10, 5),
            new Triangle(10, 6)
        };
 
        double totalArea = 0;
        double largestArea = 0;
        String largestShape = "";
 
        for (Shape shape : shapes) {
 
            double currentArea = shape.area();
 
            if (shape instanceof Circle) {
                System.out.println("Circle Area: " + currentArea);
            } else if (shape instanceof Rectangle) {
                System.out.println("Rectangle Area: " + currentArea);
            } else if (shape instanceof Triangle) {
                System.out.println("Triangle Area: " + currentArea);
            }
 
            totalArea += currentArea;
 
            if (currentArea > largestArea) {
                largestArea = currentArea;
                largestShape = shape.getClass().getSimpleName();
            }
        }
 
        System.out.println("\nTotal Area: " + totalArea);
        System.out.println("Largest Shape: " + largestShape);
        System.out.println("Largest Area: " + largestArea);
    }
}
