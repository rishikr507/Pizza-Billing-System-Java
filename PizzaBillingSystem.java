
import java.util.Scanner;

// Class representing an individual item (pizza)
class Item {

    String name;                        // Name of the pizza
    int price;                          // Price per unit
    int quantity = 0;                   // Quantity ordered

    // Constructor to initialize the item
    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // String representation of an item (used while printing the bill)
    @Override
    public String toString() {
        String str = "Item : %16s, Price : %3d, Quantity : %2d".formatted(name, price, quantity);
        return str;
    }

}

// Main class to handle the pizza billing system
public class PizzaBillingSystem {

    // Method to display the pizza menu
    static void displayMenu() {
        System.out.println("===== Welcome to Pizza Store =====");
        System.out.println("Menu:");
        System.out.println("1. Margherita Pizza - ₹250");
        System.out.println("2. Farmhouse Pizza  - ₹350");
        System.out.println("3. Paneer Pizza     - ₹300");
        System.out.println("4. Veggie Delight   - ₹280");
        System.out.println("5. Generate Bill");
        System.out.println("----------------------------------");
    }

    // Method to display the final bill
    static void displayBill(Item[] items) {
        int grandTotal = 0;                                     // Total cost of all items
        int totalItems = 0;                                     // Total quantity of all items

        // Loop through all items and display those which are ordered
        for (Item it : items) {
            if (it != null && it.quantity != 0) {
                System.out.println(it);                         // Print item details
                grandTotal += (it.price * it.quantity);         // Add to grand total
                totalItems += it.quantity;                      // Increment item count
            }

        }

        // Print bill summary
        if (grandTotal != 0) {
            System.out.println("----------------------------------");
            System.out.println("Total items = " + totalItems);
            System.out.println("Grand Total = ₹" + grandTotal);
        } else {
            System.out.println("No items ordered.");
        }

    }

    //Main Method
    public static void main(String[] args) {
        int choice;                                     // To store user choice
        Item[] items = new Item[4];                     // Array to store item objects (4 pizzas)

        // Display menu Bar.
        displayMenu();

        try (Scanner sc = new Scanner(System.in)) {
            // Take orders from the user in a loop
            do {
                System.out.println("Enter your choice :");
                choice = sc.nextInt();
                int quant;

                // Perform action based on user choice
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter quantity");
                        quant = sc.nextInt();
                        items[0] = new Item("Margherita Pizza", 250, quant);
                        System.out.println("Item added to order.");
                    }
                    case 2 -> {
                        System.out.println("Enter quantity");
                        quant = sc.nextInt();
                        items[1] = new Item("Farmhouse Pizza", 350, quant);
                        System.out.println("Item added to order.");
                    }
                    case 3 -> {
                        System.out.println("Enter quantity");
                        quant = sc.nextInt();
                        items[2] = new Item("Paneer Pizza", 300, quant);
                        System.out.println("Item added to order.");
                    }
                    case 4 -> {
                        System.out.println("Enter quantity");
                        quant = sc.nextInt();
                        items[3] = new Item("Veggie Delight", 280, quant);
                        System.out.println("Item added to order.");
                    }
                    case 5 -> {                                 // Exit when user chooses to generate bill
                    }
                    default ->
                        System.out.println("Invalid input....");
                }
                System.out.println("----------------------------------");

            } while (choice != 5);
        }

        // Display final bill after exiting the loop
        displayBill(items);

    }
}
