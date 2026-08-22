import java.util.Scanner;

public class Overload {

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int main(int args) {
        return args + 10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Sum (int) = " + add(a, b));
        System.out.println("Sum (double) = " + add((double)a, (double)b));

        System.out.println("main: " + main(a));
        sc.close();
    }
}