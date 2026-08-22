//A librarian processes book returns. For each book, the system reads the book ID, due date (day number), and return date (day number). 
//If the return date is after the due date, a fine of Rs.5 per overdue day is charged. The librarian can process multiple books. 
//After each book, ask "Process another book? (Y/N)". If the return date is before the due date, display a thank-you note. 
//At the end, print total books processed, total fine collected, and a list of overdue book IDs.
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryBookReturn {

    // Method to calculate fine
    public double calculateFine(int dueDate, int returnDate) {

        if (returnDate > dueDate) {
            int overdueDays = returnDate - dueDate;
            return overdueDays * 5;
        }

        return 0;
    }

    // Method to display book result
    public void processBook(String bookId, int dueDate, int returnDate) {

        if (returnDate > dueDate) {

            int overdueDays = returnDate - dueDate;
            double fine = calculateFine(dueDate, returnDate);

            System.out.println("Book ID: " + bookId);
            System.out.println("Overdue by: " + overdueDays + " days");
            System.out.println("Fine: Rs." + fine);

        } else if (returnDate < dueDate) {

            System.out.println("Book ID: " + bookId);
            System.out.println("Thank you for returning the book early!");

        } else {

            System.out.println("Book ID: " + bookId);
            System.out.println("Thank you for returning the book on time!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LibraryBookReturn library = new LibraryBookReturn();

        int totalBooks = 0;
        double totalFine = 0;

        ArrayList<String> overdueBookIds = new ArrayList<>();

        while (true) {

            System.out.print("\nEnter Book ID: ");
            String bookId = sc.next();

            System.out.print("Enter due date (day number): ");
            int dueDate = sc.nextInt();

            System.out.print("Enter return date (day number): ");
            int returnDate = sc.nextInt();

            // Calculate fine
            double fine = library.calculateFine(dueDate, returnDate);

            // Process book
            library.processBook(bookId, dueDate, returnDate);

            totalBooks++;
            totalFine += fine;

            // Store overdue book ID
            if (returnDate > dueDate) {
                overdueBookIds.add(bookId);
            }

            System.out.print("\nProcess another book? (Y/N): ");
            char choice = sc.next().charAt(0);

            if (choice == 'N' || choice == 'n') {
                break;
            }
        }

        // Final summary
        System.out.println("\n========== LIBRARY SUMMARY ==========");
        System.out.println("Total books processed : " + totalBooks);
        System.out.println("Total fine collected  : Rs." + totalFine);

        System.out.println("Overdue Book IDs:");

        if (overdueBookIds.isEmpty()) {
            System.out.println("None");
        } else {
            for (String id : overdueBookIds) {
                System.out.println("- " + id);
            }
        }

        System.out.println("=====================================");

        sc.close();
    }
}