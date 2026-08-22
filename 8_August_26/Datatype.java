import java.util.Scanner;
public class Datatype {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int intValue = sc.nextInt();

        System.out.print("Enter a double: ");
        double doubleValue = sc.nextDouble();

        System.out.print("Enter a string: ");
        String stringValue = sc.next();

        System.out.print("Enter a boolean: ");
        boolean booleanValue = sc.nextBoolean();

        System.out.println("You entered:");
        System.out.println("Integer: " + intValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("String: " + stringValue);
        System.out.println("Boolean: " + booleanValue);

        sc.close();
    }
}