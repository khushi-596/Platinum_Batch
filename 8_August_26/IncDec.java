import java.util.Scanner;

public class IncDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int a = sc.nextInt();

        System.out.println("post increment: " + (a++));
        System.out.println("post decrement: " + (a--));
        System.out.println("pre increment: " + (++a));
        System.out.println("pre decrement: " + (--a));


        System.out.println("+ operator: " + (a+=5));
        System.out.println("- operator: " + (a-=5));
        System.out.println("* operator: " + (a*=5));
        System.out.println("/ operator: " + (a/=5));

        sc.close();
    }
}