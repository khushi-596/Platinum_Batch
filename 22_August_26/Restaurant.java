//A restaurant billing system calculates the final bill based on customer type, day, and bill amount. Customer types: Regular (no discount), Member (10% discount), VIP (20% discount). 
//Weekend surcharge: 5% extra on total (after discount). GST: 5% on final amount. If bill > Rs.5000, additional 5% loyalty discount (after all other discounts, before weekend surcharge). 
//Payment mode: Cash (no extra), Card (2% convenience fee on final), UPI (Rs.50 cashback deducted). 
//Use switch for customer type and payment mode, nested if-else for conditional discounts and surcharges.
import java.util.Scanner;

public class Restaurant {

    // Method to calculate customer discount
    public static double getCustomerDiscount(String customerType, double bill) {
        double discount = 0;
        switch (customerType.toLowerCase()) {
            case "regular":
                discount = 0;
                break;
            case "member":
                discount = bill * 0.10;
                break;
            case "vip":
                discount = bill * 0.20;
                break;
            default:
                System.out.println("Invalid customer type.");
                return -1;
        }
        return discount;
    }

    // Method to calculate loyalty discount
    public static double getLoyaltyDiscount(double amount) {
        if (amount > 5000) {
            return amount * 0.05;
        } else {
            return 0;
        }
    }

    // Method to calculate weekend surcharge
    public static double getWeekendSurcharge(double amount, boolean weekend) {
        if (weekend) {
            return amount * 0.05;
        } else {
            return 0;
        }
    }

    // Method to calculate GST
    public static double getGST(double amount) {
        return amount * 0.05;
    }

    // Method to calculate payment adjustment
    public static double getPaymentAdjustment(String paymentMode, double amount) {
        switch (paymentMode.toLowerCase()) {
            case "cash":
                return 0;
            case "card":
                return amount * 0.02;
            case "upi":
                return -50;
            default:
                return Double.NaN;
        }
    }

    // Method to print bill
    public static void printBill(String customerType,
                                 String paymentMode,
                                 double bill,
                                 double customerDiscount,
                                 double loyaltyDiscount,
                                 double weekendSurcharge,
                                 double gst,
                                 double paymentAdjustment,
                                 double finalAmount) {

        System.out.println("\n========== RESTAURANT BILL ==========");

        System.out.println("Customer Type       : " + customerType);
        System.out.println("Payment Mode        : " + paymentMode);
        System.out.println("Original Bill       : Rs." + bill);
        System.out.println("Customer Discount   : Rs." + customerDiscount);
        System.out.println("Loyalty Discount    : Rs." + loyaltyDiscount);
        System.out.println("Weekend Surcharge   : Rs." + weekendSurcharge);
        System.out.println("GST (5%)            : Rs." + gst);

        if (paymentAdjustment > 0) {
            System.out.println("Card Fee            : Rs." + paymentAdjustment);
        } else if (paymentAdjustment < 0) {
            System.out.println("UPI Cashback        : Rs." + (-paymentAdjustment));
        } else {
            System.out.println("Payment Adjustment  : Rs.0");
        }

        System.out.println("--------------------------------------");
        System.out.println("FINAL BILL          : Rs." + finalAmount);
        System.out.println("======================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer type (Regular/Member/VIP): ");
        String customerType = sc.next();

        System.out.print("Enter bill amount: ");
        double bill = sc.nextDouble();

        System.out.print("Is today weekend? (true/false): ");
        boolean weekend = sc.nextBoolean();

        System.out.print("Enter payment mode (Cash/Card/UPI): ");
        String paymentMode = sc.next();

        // Customer discount
        double customerDiscount =
                getCustomerDiscount(customerType, bill);

        if (customerDiscount == -1) {
            sc.close();
            return;
        }

        // Amount after customer discount
        double amountAfterCustomerDiscount =
                bill - customerDiscount;

        // Loyalty discount
        double loyaltyDiscount =
                getLoyaltyDiscount(amountAfterCustomerDiscount);

        // Amount after loyalty discount
        double amountAfterDiscounts =
                amountAfterCustomerDiscount - loyaltyDiscount;

        // Weekend surcharge
        double weekendSurcharge =
                getWeekendSurcharge(
                        amountAfterDiscounts,
                        weekend
                );

        // Amount before GST
        double amountBeforeGST =
                amountAfterDiscounts + weekendSurcharge;

        // GST
        double gst = getGST(amountBeforeGST);

        // Amount after GST
        double amountAfterGST =
                amountBeforeGST + gst;

        // Payment adjustment
        double paymentAdjustment =
                getPaymentAdjustment(
                        paymentMode,
                        amountAfterGST
                );

        if (Double.isNaN(paymentAdjustment)) {
            System.out.println("Invalid payment mode.");
            sc.close();
            return;
        }

        // Final amount
        double finalAmount =
                amountAfterGST + paymentAdjustment;

        // Print itemized bill
        printBill(
                customerType,
                paymentMode,
                bill,
                customerDiscount,
                loyaltyDiscount,
                weekendSurcharge,
                gst,
                paymentAdjustment,
                finalAmount
        );

        sc.close();
    }
}