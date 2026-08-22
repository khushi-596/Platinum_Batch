//write a method to define month name by taking month number as input
import java.util.Scanner;
public class Month {
    public String getMonthName(int monthNumber) {
        switch (monthNumber) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid month";
        }
    }

    public static void main(String[] args) {
        Month m = new Month();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Month number: ");
        int monthNumber = sc.nextInt();

        System.out.println("get month " + monthNumber + ": " + m.getMonthName(monthNumber));

    }
}