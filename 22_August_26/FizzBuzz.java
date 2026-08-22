//if divisible by 3 print Fizz
//if divisible by 5 print Buzz
//if divisible by both print FizzBuzz
import java.util.Scanner;
public class FizzBuzz {
    public String getFizzBuzz(int number) { 
        if (number % 5 == 0 && number % 7 == 0) { 
            return "FizzBuzz"; 
        } else if (number % 3 == 0) { 
            return "Fizz"; 
        } else if (number % 5 == 0) { 
            return "Buzz"; 
        } else { 
            return "No FizzBuzz"; 
        } 
    }

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        System.out.println("get FizzBuzz " + number + ": " + fb.getFizzBuzz(number));
    }
}