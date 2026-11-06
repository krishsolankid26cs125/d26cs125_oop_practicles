package app;
 
import discount.DiscountRule;
import engine.DiscountEngine;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
public class DiscountDemo {
 
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
 
        List<Double> prices = Arrays.asList(1000.0, 2000.0, 500.0);
 
        DiscountRule tenPercent = price -> price * 0.90;
        DiscountRule twentyPercent = price -> price * 0.80;
        DiscountRule noDiscount = price -> price;
 
        System.out.println("Discount Engine");
        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.println("3. No Discount");
 
        System.out.print("Choose a discount rule: ");
        int choice = scanner.nextInt();
 
        DiscountRule selectedRule;
 
        switch (choice) {
            case 1:
                selectedRule = tenPercent;
                break;
 
            case 2:
                selectedRule = twentyPercent;
                break;
 
            case 3:
                selectedRule = noDiscount;
                break;
 
            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }
 
        DiscountEngine engine = new DiscountEngine();
 
        engine.applyDiscount(prices, selectedRule);
 
        scanner.close();
    }
}
