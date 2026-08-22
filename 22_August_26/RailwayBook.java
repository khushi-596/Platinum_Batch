//A railway reservation system calculates the fare based on train class, and passenger age. Classes 1=AC First (3000), 2=AC Second(2000), 3=Sleeper(800, 4=General(300
//Children below 5 travel free. Children 5-12 get 50% discount.
//Senior citizens (age 60 and above) get 30% discount.
//If booking is tatkal(emergency), add Rs.200 for sleeper/General and Rs.500 for AC classes.
//print itemized ticket
import java.util.Scanner;

public class RailwayBook {

    public void printTicket(int trainClass, int age, boolean isTatkal) {

        double baseFare = 0;
        double discount = 0;
        double tatkalCharge = 0;

        String className = "";

        // Train class and base fare
        switch (trainClass) {
            case 1:
                className = "AC First";
                baseFare = 3000;
                break;

            case 2:
                className = "AC Second";
                baseFare = 2000;
                break;

            case 3:
                className = "Sleeper";
                baseFare = 800;
                break;

            case 4:
                className = "General";
                baseFare = 300;
                break;

            default:
                System.out.println("Invalid train class.");
                return;
        }

        // Age validation
        if (age < 0) {
            System.out.println("Invalid age.");
            return;
        }

        // Age-based discount
        if (age < 5) {
            discount = baseFare;       // 100% discount
        }
        else if (age <= 12) {
            discount = baseFare * 0.50; // 50% discount
        }
        else if (age >= 60) {
            discount = baseFare * 0.30; // 30% discount
        }

        double fareAfterDiscount = baseFare - discount;

        // Tatkal charge
        if (isTatkal) {
            if (trainClass == 1 || trainClass == 2) {
                tatkalCharge = 500;
            }
            else {
                tatkalCharge = 200;
            }
        }

        double totalFare = fareAfterDiscount + tatkalCharge;

        // Itemized ticket
        System.out.println("\nRAILWAY TICKET ");
        System.out.println("Train Class       : " + className);
        System.out.println("Passenger Age     : " + age);
        System.out.println("Base Fare         : Rs." + baseFare);
        System.out.println("Age Discount      : Rs." + discount);
        System.out.println("Fare After Discount: Rs." + fareAfterDiscount);
        System.out.println("Tatkal            : " + (isTatkal ? "Yes" : "No"));
        System.out.println("Tatkal Charge     : Rs." + tatkalCharge);
        System.out.println("Total Fare        : Rs." + totalFare);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RailwayBook rb = new RailwayBook();

        System.out.print("Enter train class (1-AC First, 2-AC Second, 3-Sleeper, 4-General): ");
        int trainClass = sc.nextInt();

        System.out.print("Enter passenger age: ");
        int age = sc.nextInt();

        System.out.print("Is this Tatkal booking? (true/false): ");
        boolean isTatkal = sc.nextBoolean();

        rb.printTicket(trainClass, age, isTatkal);

        sc.close();
    }
}