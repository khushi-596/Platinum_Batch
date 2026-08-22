//A university admits students based on entrance exam scores and category.
//General category: admitted if score >= 85.
//OBC: admitted if score >= 75.
//SC/ST: admitted if score >= 65. If the student has sportsquota, reduce the cutoff by 5 points.
//If the student has NCC certificate, reduce cutoff by 3 points. If admitted, calculate tuition fee: General = Rs 100000, OBC = Rs 75000, SC/ST = Rs 50,000.
//If hostel required, add Rs 40000. Print admission status, category, final cutoff, score, and total fee.
import java.util.Scanner;

public class University {

    // Method to get the basic cutoff based on category
    public static double getCutoff(String category) {

        switch (category.toUpperCase()) {
            case "GENERAL":
                return 85;
            case "OBC":
                return 75;
            case "SC":
            case "ST":
                return 65;
            default:
                return -1;
        }
    }

    // Method to calculate final cutoff
    public static double getFinalCutoff(double cutoff, boolean sportsQuota, boolean ncc) {
        if (sportsQuota) {
            cutoff -= 5;
        }
        if (ncc) {
            cutoff -= 3;
        }
        return cutoff;
    }

    // Method to check admission
    public static boolean checkAdmission(double score, double finalCutoff) {
        return score >= finalCutoff;
    }

    // Method to calculate tuition fee
    public static double getTuitionFee(String category) {

        switch (category.toUpperCase()) {
            case "GENERAL":
                return 100000;
            case "OBC":
                return 75000;
            case "SC":
            case "ST":
                return 50000;
            default:
                return 0;
        }
    }

    // Method to calculate total fee
    public static double getTotalFee(double tuitionFee, boolean hostel) {
        if (hostel) {
            return tuitionFee + 40000;
        }
        return tuitionFee;
    }

    // Method to print admission details
    public static void printResult(String category, double score, double finalCutoff, boolean admitted, double totalFee) {

        System.out.println("\n========== ADMISSION RESULT ==========");

        System.out.println("Category       : " + category);
        System.out.println("Score          : " + score);
        System.out.println("Final Cutoff   : " + finalCutoff);

        if (admitted) {
            System.out.println("Status         : ADMITTED");
            System.out.println("Total Fee      : Rs." + totalFee);
        } else {
            System.out.println("Status         : NOT ADMITTED");
            System.out.println("Total Fee      : Rs.0");
        }

        System.out.println("======================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter category (General/OBC/SC/ST): ");
        String category = sc.next();

        System.out.print("Enter entrance exam score: ");
        double score = sc.nextDouble();

        System.out.print("Sports quota? (true/false): ");
        boolean sportsQuota = sc.nextBoolean();

        System.out.print("NCC certificate? (true/false): ");
        boolean ncc = sc.nextBoolean();

        System.out.print("Hostel required? (true/false): ");
        boolean hostel = sc.nextBoolean();

        // Get basic cutoff
        double cutoff = getCutoff(category);

        // Validate category
        if (cutoff == -1) {
            System.out.println("Invalid category.");
            sc.close();
            return;
        }

        // Calculate final cutoff
        double finalCutoff = getFinalCutoff(cutoff, sportsQuota, ncc);
        // Check admission
        boolean admitted = checkAdmission(score, finalCutoff);
        double totalFee = 0;

        if (admitted) {
            // Calculate tuition fee
            double tuitionFee = getTuitionFee(category);
            // Add hostel fee if required
            totalFee = getTotalFee(tuitionFee, hostel);
        }
        // Print result
        printResult(category, score, finalCutoff, admitted, totalFee);
        sc.close();
    }
}