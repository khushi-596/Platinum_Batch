import java.util.Scanner;

public class RelLogiOp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

        boolean result = (a > b) && (a < 100);
        System.out.println("Result of (a > b) && (a < 100): " + result);

        boolean result2 = (a < b) || (a > 50);
        System.out.println("Result of (a < b) || (a > 50): " + result2);

        sc.close();
    }
}