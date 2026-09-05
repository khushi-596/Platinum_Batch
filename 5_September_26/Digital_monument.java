//build diamond upper half ascending numbers, lower half desecending numbers, # in border, if row numbers is divisible by 3 print it solid. if size > 15, cap it at 15 using break logic
//      #
//    # 2 #
//  # 3 3 3 #
//# 4 4 4 4 4 #
//  # # # # #
//    # 2 #
//      #
import java.util.Scanner;

public class Digital_monument {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows for the diamond: ");
        int rows = sc.nextInt();
        Diamond(rows);
        sc.close();
    }

    public static void Diamond(int rows) {
        if (rows > 15) {
            rows = 15;
        }

        // Upper half of the diamond
        for (int i = 1; i <= rows; i++) {
            for (int j = rows; j > i; j--) {
                System.out.print("  ");
            }
            System.out.print("# ");
            for (int j = 1; j < i; j++) {
                if (i % 3 == 0) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                }
            }
            if (i > 1) {
                System.out.print("#");
            }
            System.out.println();
        }

        // Lower half of the diamond
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = rows; j > i; j--) {
                System.out.print("  ");
            }
            System.out.print("# ");
            for (int j = 1; j < i; j++) {
                if (i % 3 == 0) {
                    System.out.print("# ");
                } else {
                    System.out.print(i + " ");
                }
            }
            if (i > 1) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    
}