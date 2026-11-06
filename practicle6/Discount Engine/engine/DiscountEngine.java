package engine;
 
import discount.DiscountRule;
import java.util.List;
 
public class DiscountEngine {
 
    public void applyDiscount(List<Double> prices, DiscountRule rule) {
 
        System.out.println("\nDiscounted Prices:");
 
        for (double price : prices) {
 
            double discountedPrice = rule.apply(price);
 
            System.out.printf("Original Price: %.2f | Discounted Price: %.2f%n",
                    price, discountedPrice);
        }
    }
}
