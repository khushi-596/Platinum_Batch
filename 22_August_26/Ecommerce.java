//Outer loop for customers (stop at 'DONE')
//Inner loop for items per customer
//skip invalid items, apply discount, add delivery
import java.util.Scanner;
public class Ecommerce {
    // Method to process one customer's order
    public double processOrder(Scanner sc, String customerId) {
        double total = 0;
        System.out.println("\nOrder for Customer ID: " + customerId);
        while (true) {
            System.out.print("Enter product price (0 to finish customer): ");
            double price = sc.nextDouble();
            // End items for current customer
            if (price == 0) {
                break;
            }
            System.out.print("Enter product quantity: ");
            int quantity = sc.nextInt();
            // Skip invalid items
            if (price < 0 || quantity <= 0) {
                System.out.println("Invalid item. Skipping...");
                continue;
            }
            double itemTotal = price * quantity;
            total += itemTotal;
            System.out.println("Item total: " + itemTotal);
        }
        // Discount
        double discount = 0;
        if (total > 100) {
            discount = total * 0.10;
        }
        double afterDiscount = total - discount;
        // Delivery charge
        double delivery = getDeliveryCharge(afterDiscount);
        double finalAmount = afterDiscount + delivery;
        System.out.println("\n----- CUSTOMER BILL -----");
        System.out.println("Customer ID  : " + customerId);
        System.out.println("Item Total   : Rs." + total);
        System.out.println("Discount     : Rs." + discount);
        System.out.println("Delivery     : Rs." + delivery);
        System.out.println("Final Amount : Rs." + finalAmount);
        return finalAmount;
    }

    // Method to calculate delivery charge
    public double getDeliveryCharge(double amount) {
        if (amount >= 500) {
            return 0;
        } else {
            return 50;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ecommerce ecommerce = new Ecommerce();
        double grandTotal = 0;
        // Outer loop for customers
        while (true) {
            System.out.print("\nEnter customer ID (DONE to stop): ");
            String customerId = sc.next();
            if (customerId.equalsIgnoreCase("DONE")) {
                break;
            }
            // Inner loop is inside processOrder()
            double customerTotal = ecommerce.processOrder(sc, customerId);
            grandTotal += customerTotal;
        }
        System.out.println("\n==========================");
        System.out.println("GRAND TOTAL: Rs." + grandTotal);
        System.out.println("==========================");
        sc.close();
    }
}
        