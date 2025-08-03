
import java.util.Scanner;

class Item {

    String name;
    int price;
    int quantity = 0;

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        String str = "Item : %16s, Price : %3d, Quantity : %2d".formatted(name, price, quantity);
        return str;
    }

}

public class PizzaBillingSystem {

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

    static void displayBill(Item[] items) {
        int grandTotal = 0;
        int totalItems = 0;

        // Display ordered Items
        for (Item it : items) {
            if (it != null && it.quantity != 0) {
                System.out.println(it);
                grandTotal += (it.price * it.quantity);
                totalItems += it.quantity;
            }

        }

        // Displaying Bill
        if (grandTotal != 0) {
            System.out.println("----------------------------------");
            System.out.println("Total items = " + totalItems);
            System.out.println("Grand Total = ₹" + grandTotal);
        } else {
            System.out.println("No items ordered.");
        }

    }

    public static void main(String[] args) {
        int choice;
        Item[] items = new Item[4];

        // Display menu Bar.
        displayMenu();

        try (Scanner sc = new Scanner(System.in)) {
            // Taking order
            do {
                System.out.println("Enter your choice :");
                choice = sc.nextInt();
                int quant;
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
                    case 5 -> {
                    }
                    default ->
                        System.out.println("Invalid input....");
                }
                System.out.println("----------------------------------");

            } while (choice != 5);
        }

        // Display bill to user
        displayBill(items);

    }
}
