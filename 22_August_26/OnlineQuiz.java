//An online quiz platform presents 5 multiple-choice questions to a player. each question has 4 options (A, B, C, D) and onr correct answer.
//The player can answer each question or type 'Q' to quit the quiz early.
//Track the score (+10 for correct, 0 for wrong), show the running score after each question, and display the final percentage. 
//If the player quits early, show how many questions were attempted.
import java.util.Scanner;

public class OnlineQuiz {
    // Method to display questions
    public static void showQuestion(int questionNo) {
        switch (questionNo) {
            case 1:
                System.out.println("\nQ1. Which language is used for Android development?");
                System.out.println("A. Java");
                System.out.println("B. HTML");
                System.out.println("C. SQL");
                System.out.println("D. CSS");
                break;

            case 2:
                System.out.println("\nQ2. Which data structure uses FIFO?");
                System.out.println("A. Stack");
                System.out.println("B. Queue");
                System.out.println("C. Tree");
                System.out.println("D. Graph");
                break;

            case 3:
                System.out.println("\nQ3. Which keyword is used to inherit a class in Java?");
                System.out.println("A. implements");
                System.out.println("B. extends");
                System.out.println("C. inherits");
                System.out.println("D. super");
                break;

            case 4:
                System.out.println("\nQ4. Which of these is not a programming language?");
                System.out.println("A. Python");
                System.out.println("B. Java");
                System.out.println("C. HTML");
                System.out.println("D. C++");
                break;

            case 5:
                System.out.println("\nQ5. Which symbol is used for single-line comments in Java?");
                System.out.println("A. /*");
                System.out.println("B. #");
                System.out.println("C. //");
                System.out.println("D. --");
                break;
        }
    }

    // Method to get correct answer
    public static char getCorrectAnswer(int questionNo) {
        switch (questionNo) {
            case 1:
                return 'A';
            case 2:
                return 'B';
            case 3:
                return 'B';
            case 4:
                return 'C';
            case 5:
                return 'C';
            default:
                return 'X';
        }
    }

    // Method to check answer
    public static boolean checkAnswer(char answer, char correctAnswer) {
        return answer == correctAnswer;
    }

    // Method to calculate percentage
    public static double calculatePercentage(int score, int attempted) {
        if (attempted == 0) {
            return 0;
        }
        return ((double) score / (attempted * 10)) * 100;
    }

    // Method to print final result
    public static void printResult(int score, int attempted, boolean quit) {
        double percentage = calculatePercentage(score, attempted);
        System.out.println("\n========== QUIZ RESULT ==========");
        System.out.println("Questions attempted : " + attempted);
        System.out.println("Score               : " + score + "/50");
        System.out.println("Percentage          : " + percentage + "%");
        if (quit) {
            System.out.println("Status              : Quiz quit early");
        } else {
            System.out.println("Status              : Quiz completed");
        }
        System.out.println("=================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        int attempted = 0;
        boolean quit = false;
        for (int i = 1; i <= 5; i++) {
            showQuestion(i);
            System.out.print("Enter your answer (A/B/C/D) or Q to quit: ");
            char answer = Character.toUpperCase(sc.next().charAt(0));
            // Quit condition
            if (answer == 'Q') {
                quit = true;
                break;
            }
            // Validate answer
            if (answer != 'A' && answer != 'B' &&
                answer != 'C' && answer != 'D') {
                System.out.println("Invalid option. Question not attempted.");
                i--;
                continue;
            }
            attempted++;
            char correctAnswer = getCorrectAnswer(i);
            if (checkAnswer(answer, correctAnswer)) {
                score += 10;
                System.out.println("Correct answer!");
            } else {
                System.out.println("Wrong answer!");
            }
            // Running score
            System.out.println("Running score: " + score);
        }
        // Final result
        printResult(score, attempted, quit);
        sc.close();
    }
}