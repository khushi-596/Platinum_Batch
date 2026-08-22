//simple interest, compound interest for given principal amount, rate of interest and time (years) .
//SI = (P*R*T)/100 (double)
//CI = P * (1 + R/100)^T - P  (double)
//Total Amount = P * (1 + R/100)^T
//1.principle(double)
//2.rate(double)
//3.time(int)
//use inbuild math functions
//print the value round to 2 decimals and then typecast it to int value
//P > 0, R >= 0, T >= 0
//use only variables , operators and casting concepts don't use any if else or loops

import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter principal amount (P): ");
        double principal = sc.nextDouble();

        System.out.print("Enter rate of interest (R): ");
        double rate = sc.nextDouble();

        System.out.print("Enter time (T) in years: ");
        int time = sc.nextInt();

        double simpleInterest = (principal * rate * time) / 100;

        double compoundInterest = principal * Math.pow((1 + rate / 100), time) - principal;

        double totalAmount = principal * Math.pow((1 + rate / 100), time);

        System.out.println("Simple Interest (SI) = " + Math.round(simpleInterest * 100.0) / 100.0);
        System.out.println("Compound Interest (CI) = " + Math.round(compoundInterest * 100.0) / 100.0);
        System.out.println("Total Amount = " + Math.round(totalAmount * 100.0) / 100.0);

        sc.close();
    }
}
