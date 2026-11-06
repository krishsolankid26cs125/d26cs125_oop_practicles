import java.util.ArrayList;
import java.util.List;

// Custom checked exception for insufficient stock
class OutOfStockException extends Exception {
    private int shortage;

    public OutOfStockException(String message, int shortage) {
        super(message);
        this.shortage = shortage;
    }

    public int getShortage() {
        return shortage;
    }
}

// Custom checked exception for invalid quantity
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

// Warehouse class
class Warehouse {
    private int stock;

    public Warehouse(int stock) {
        this.stock = stock;
    }

    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than zero."
            );
        }

        if (qty > stock) {
            int shortage = qty - stock;

            throw new OutOfStockException(
                "Insufficient stock for " + item +
                ". Available: " + stock +
                ", Requested: " + qty,
                shortage
            );
        }

        stock -= qty;

        System.out.println(
            "Successfully issued " + qty + " units of " + item
        );

        System.out.println("Remaining stock: " + stock);
    }
}

// Main class
public class WarehouseStock {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse(10);

        List<String> items = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();

        items.add("Laptop");
        quantities.add(4);

        items.add("Laptop");
        quantities.add(8);

        items.add("Mouse");
        quantities.add(-2);

        items.add("Laptop");
        quantities.add(2);

        for (int i = 0; i < items.size(); i++) {

            String item = items.get(i);
            int qty = quantities.get(i);

            System.out.println("\\nProcessing request " + (i + 1));

            try {
                warehouse.issue(item, qty);

            } catch (OutOfStockException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Shortfall: " + e.getShortage());

            } catch (InvalidQuantityException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\\nAll requests processed.");
    }
}
