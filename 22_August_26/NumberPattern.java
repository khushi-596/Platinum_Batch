//5 4 3 2 1
//  5 4 3 2
//    5 4 3
//      5 4
//        5
import java.util.Scanner;
public class NumberPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows for the pattern: ");
        int rows = sc.nextInt();
        
        for (int i = 1; i <= rows; i++) {
            for (int k=0; k<i-1; k++) {
                System.out.print("  ");
            }
            for (int j = rows; j >= i; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}