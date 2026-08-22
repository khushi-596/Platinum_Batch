public class ImplicitCast {
    public static void main(String[] args) {
        int intValue = 100;

        double doubleValue = intValue; 
        
        System.out.println("Original integer value: " + intValue);
        System.out.println("Implicitly casted double value: " + doubleValue);
    }
}
