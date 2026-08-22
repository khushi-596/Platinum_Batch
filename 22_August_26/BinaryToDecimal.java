import java.util.Scanner;

public class BinaryToDecimal {

    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int base = 1; 

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += base;
            }
            base *= 2;
        }
        return decimal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binary = sc.nextLine();
        int decimal = binaryToDecimal(binary);
        System.out.println("Decimal equivalent: " + decimal);
        sc.close();
    }
}