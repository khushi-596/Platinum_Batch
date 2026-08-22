//Bank Fixed Deposit Maturity Tracker
//A customer opens a Fixed Deposit account with a principal amount, interest rate, and tenure. The bank compounds interest annually.
//prints year by year maturity showing year, opening balance, interest earned, and closing balance
//print the total maturity amount and total interest earned
import java.util.Scanner;
public class BankTracker {
 
    public static void printYearlyMaturity(double principal, double rate, int years) {
        double totalInterest = 0;
        double totalMaturity = principal;

        System.out.printf("%-6s%-18s%-18s%-18s%n", "Year", "Opening Balance ", "Interest Earned ", "Closing Balance");
        for (int i = 1; i <= years; i++) {
            double interest = totalMaturity * (rate / 100);
            double closingBalance = totalMaturity + interest;

            System.out.printf("%-6d%-18.2f%-18.2f%-18.2f%n", i, totalMaturity, interest, closingBalance);

            totalInterest += interest;
            totalMaturity = closingBalance;
        }
        System.out.printf("%nTotal Maturity Amount: %.2f%n", totalMaturity);
        System.out.printf("Total Interest Earned: %.2f%n", totalInterest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter principal amount: ");
        double principal = sc.nextDouble();
        System.out.print("Enter interest rate: ");
        double rate = sc.nextDouble();
        System.out.print("Enter tenure (in years): ");
        int years = sc.nextInt();

        printYearlyMaturity(principal, rate, years);
        sc.close();
    }
}