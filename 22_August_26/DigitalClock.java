//A digital display shows numbers using a 5-row, 3-column grid. Write a program that takes a digit (0-9) as input and prints it in a digital pattern using stars and spaces. 
//The pattern uses nested loops and conditional logic to decide whether each cell should have a star or a space based on the digit's shape.
import java.util.Scanner;
public class DigitalClock {
    // Method to check whether a cell should contain *
    public static boolean isStar(int digit, int row, int col) {
        switch (digit) {
            case 0:
                return row == 0 || row == 4 || col == 0 || col == 2;
            case 1:
                return col == 2;
            case 2:
                return row == 0 || row == 2 || row == 4
                        || (row == 1 && col == 2)
                        || (row == 3 && col == 0);
            case 3:
                return row == 0 || row == 2 || row == 4
                        || col == 2;
            case 4:
                return row == 2 || col == 2
                        || (row < 2 && col == 0);
            case 5:
                return row == 0 || row == 2 || row == 4
                        || (row == 1 && col == 0)
                        || (row == 3 && col == 2);
            case 6:
                return row == 0 || row == 2 || row == 4
                        || col == 0
                        || (row == 3 && col == 2);
            case 7:
                return row == 0 || col == 2;
            case 8:
                return row == 0 || row == 2 || row == 4
                        || col == 0 || col == 2;
            case 9:
                return row == 0 || row == 2
                        || row == 4 || col == 2
                        || (row == 1 && col == 0);
            default:
                return false;
        }
    }

    public static void printDigit(int digit) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 3; col++) {
                if (isStar(digit, row, col)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a digit (0-9): ");
        int digit = sc.nextInt();
        if (digit < 0 || digit > 9) {
            System.out.println("Invalid digit.");
        } else {
            printDigit(digit);
        }
        sc.close();
    }
}