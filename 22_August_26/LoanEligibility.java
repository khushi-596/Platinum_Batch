//Applicant must be between 21 and 60 years of age. If salaried: monthly income >= 25,000 and credit score >= 650. 
//If self-employed: annual income >= 5,00,000 and credit score >= 700.
//If business: annual turnover >= 10,00,000 and credit score >= 750.
//the loan amount requested must not exceed 10x monthly income (for salaried) or 5x annual income (for self-employed/business).
//print approved with sanctioned amount or rejected with reason
import java.util.Scanner;

public class LoanEligibility {

    public int checkEligibility(int age, String employmentType, double income, int creditScore, double loanAmountRequested) {

        // Age validation
        if (age < 21 || age > 60) {
            System.out.println("Rejected: Age must be between 21 and 60.");
            return 0;
        }

        // Income and loan amount validation
        if (income <= 0) {
            System.out.println("Rejected: Income must be greater than 0.");
            return 0;
        }

        if (loanAmountRequested <= 0) {
            System.out.println("Rejected: Loan amount must be greater than 0.");
            return 0;
        }

        // Credit score validation
        if (creditScore < 0 || creditScore > 900) {
            System.out.println("Rejected: Credit score must be between 0 and 900.");
            return 0;
        }

        double maxLoanAmount = 0;

        switch (employmentType.toLowerCase()) {

            // SALARIED
            case "salaried":

                if (income < 25000 && creditScore < 650) {
                    System.out.println(
                        "Rejected: Monthly income must be at least ₹25,000 " +
                        "and credit score must be at least 650."
                    );
                    return 0;
                }

                if (income < 25000) {
                    System.out.println(
                        "Rejected: Monthly income must be at least ₹25,000."
                    );
                    return 0;
                }

                if (creditScore < 650) {
                    System.out.println(
                        "Rejected: Credit score must be at least 650."
                    );
                    return 0;
                }

                maxLoanAmount = income * 10;
                break;

            // SELF-EMPLOYED
            case "self-employed":

                if (income < 500000 && creditScore < 700) {
                    System.out.println(
                        "Rejected: Annual income must be at least ₹5,00,000 " +
                        "and credit score must be at least 700."
                    );
                    return 0;
                }

                if (income < 500000) {
                    System.out.println(
                        "Rejected: Annual income must be at least ₹5,00,000."
                    );
                    return 0;
                }

                if (creditScore < 700) {
                    System.out.println(
                        "Rejected: Credit score must be at least 700."
                    );
                    return 0;
                }

                maxLoanAmount = income * 5;
                break;

            // BUSINESS
            case "business":

                if (income < 1000000 && creditScore < 750) {
                    System.out.println(
                        "Rejected: Annual turnover must be at least ₹10,00,000 " +
                        "and credit score must be at least 750."
                    );
                    return 0;
                }

                if (income < 1000000) {
                    System.out.println(
                        "Rejected: Annual turnover must be at least ₹10,00,000."
                    );
                    return 0;
                }

                if (creditScore < 750) {
                    System.out.println(
                        "Rejected: Credit score must be at least 750."
                    );
                    return 0;
                }

                maxLoanAmount = income * 5;
                break;

            default:
                System.out.println(
                    "Rejected: Invalid employment type. " +
                    "Use salaried, self-employed, or business."
                );
                return 0;
        }

        // Loan amount validation
        if (loanAmountRequested > maxLoanAmount) {
            System.out.println(
                "Rejected: Requested loan amount exceeds the maximum allowed amount of ₹"
                + maxLoanAmount
            );
            return 0;
        }

        // Approval
        System.out.println(
            "Approved: Loan amount sanctioned is ₹" + loanAmountRequested
        );

        return 1;
    }

    public static void main(String[] args) {

        LoanEligibility loanEligibility = new LoanEligibility();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print(
            "Enter employment type (salaried/self-employed/business): "
        );
        String employmentType = sc.next();

        System.out.print("Enter income/annual turnover: ");
        double income = sc.nextDouble();

        System.out.print("Enter credit score: ");
        int creditScore = sc.nextInt();

        System.out.print("Enter loan amount requested: ");
        double loanAmountRequested = sc.nextDouble();

        loanEligibility.checkEligibility(age, employmentType, income, creditScore, loanAmountRequested);
        sc.close();
    }
}