import java.util.Scanner;
public class Temperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println("Temperature in fahrenheit is: " + fahrenheit);
        System.out.println("After converting to integer: " + (int)(fahrenheit));
        sc.close();
    }

}