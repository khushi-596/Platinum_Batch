//Age(60): income<=3,00,000 = 0%, 3,00,001 - 5,00,000 = 5%, 5,00,001 - 10,00,000 = 20%, above 10,00,000 = 30%
//age(60-79): income<=3,50,000 = 0%, 3,50,001 - 5,00,000 = 5%, 5,00,001 - 10,00,000 = 20%, above 10,00,000 = 30%
//age(80+): income<=5,00,000 = 0%, 5,00,001-10,00,000 = 20%, above 10,00,000 = 30%
//apply health cess of 4% on calculated tax
//print income, tax, cess, total tax payable
import java.util.Scanner;

public class IncomeTax {

    public int taxCalculator(int age, int income) {

        if (age <= 60) {
            if (income <= 300000)
                return 0;
            else if (income <= 500000)
                return (int)(income * 0.05);
            else if (income <= 1000000)
                return (int)(income * 0.20);
            else
                return (int)(income * 0.30);

        } else if (age >= 61 && age <= 79) {
            if (income <= 350000)
                return 0;
            else if (income <= 500000)
                return (int)(income * 0.05);
            else if (income <= 1000000)
                return (int)(income * 0.20);
            else
                return (int)(income * 0.30);

        } else {  // age >= 80
            if (income <= 500000)
                return 0;
            else if (income <= 1000000)
                return (int)(income * 0.20);
            else
                return (int)(income * 0.30);
        }
    }

    public static void main(String[] args) {

        IncomeTax tax = new IncomeTax();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your Age: ");
        int age = sc.nextInt();

        System.out.print("Enter your income: ");
        int income = sc.nextInt();

        int calculatedTax = tax.taxCalculator(age, income);
        double cess = calculatedTax * 0.04;
        double totalTax = calculatedTax + cess;

        System.out.println("Income: " + income);
        System.out.println("Tax: " + calculatedTax);
        System.out.println("Health Cess: " + cess);
        System.out.println("Total Tax Payable: " + totalTax);

        sc.close();
    }
}