import java.util.Scanner;

// Custom exception for division by zero
class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}

public class GuardedCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean success = false;

        while (!success) {
            try {
                System.out.print("Enter first number: ");
                double num1 = Double.parseDouble(sc.nextLine());

                System.out.print("Enter second number: ");
                double num2 = Double.parseDouble(sc.nextLine());

                System.out.print("Enter operator (+, -, *, /): ");
                String operator = sc.nextLine();

                double result;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;

                    case "*":
                        result = num1 * num2;
                        break;

                    case "/":
                        if (num2 == 0) {
                            throw new DivideByZeroException(
                                "Cannot divide by zero!"
                            );
                        }
                        result = num1 / num2;
                        break;

                    default:
                        throw new IllegalArgumentException(
                            "Invalid operator!"
                        );
                }

                System.out.println("Result: " + result);
                success = true;

            } catch (DivideByZeroException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers.");

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Calculation attempt completed.\\n");
            }
        }

        sc.close();
        System.out.println("Calculator closed.");
    }
}
