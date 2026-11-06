import java.util.Scanner;

public class VendingMachine 
{
    enum Coin 
    {
        ONE, TWO, FIVE, TEN
    }

    public static void main(String[] args) 
    {
        int price = 15;
        int total = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Snack price is " + price + ". Enter coins (ONE, TWO, FIVE, TEN):");

        while (total < price) 
            {
            String input = scanner.next().toUpperCase();
            try 
            {
                Coin coin = Coin.valueOf(input);
                
                int value = switch (coin) 
                {
                    case ONE -> 1;
                    case TWO -> 2;
                    case FIVE -> 5;
                    case TEN -> 10;
                };
                
                total += value;
                System.out.println("Total so far: " + total);
            } 
            catch (IllegalArgumentException e) 
            {
                System.out.println("Invalid coin. Please enter ONE, TWO, FIVE, or TEN.");
            }
        }

        int change = total - price;
        System.out.println("Paid. Change: " + change);
        
        scanner.close();
    }
}