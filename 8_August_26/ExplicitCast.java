public class ExplicitCast {
    public static void main(String[] args) {
        double doubleValue = 9.78;
        
        int intValue = (int) doubleValue; 
        
        System.out.println("Original double value: " + doubleValue);
        System.out.println("Explicitly casted integer value: " + intValue);
    }
}
