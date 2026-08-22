import java.util.Scanner;

public class ConstructorOver {
    private int num1;
    private int num2;

    public ConstructorOver() {
        this.num1 = 0;
        this.num2 = 0;
    }

    public ConstructorOver(int a, int b) {
        this.num1 = a;
        this.num2 = b;
    }

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

        ConstructorOver obj1 = new ConstructorOver();        
        ConstructorOver obj2 = new ConstructorOver(a, b);    

        System.out.println("Sum (int) = " + add(a, b));
        System.out.println("Sum (double) = " + add((double)a, (double)b));
        System.out.println("Overloaded main output: " + main(a));
        
        sc.close();
    }
}
