public class Bag {
    int redball = 0;
    int greenball = 0;
    int yellowball = 0;

    // Method to add a ball
    public void add(String color) {
        int totalBalls = redball + greenball + yellowball;
        // Capacity check
        if (totalBalls >= 12) {
            System.out.println("Bag is full.");
            return;
        }
        if (color.equalsIgnoreCase("red")) {
            // Red cannot be more than green
            if (redball < greenball) {
                redball++;
                System.out.println("Red ball added.");
            } else {
                System.out.println(
                    "Cannot add red: Red balls cannot be more than green balls."
                );
            }
        } else if (color.equalsIgnoreCase("yellow")) {
            // Yellow cannot be more than 40%
            if ((yellowball + 1) <= ((totalBalls + 1) * 0.40)) {
                yellowball++;
                System.out.println("Yellow ball added.");
            } else {
                System.out.println(
                    "Cannot add yellow: Yellow balls cannot exceed 40%."
                );
            }
        } else if (color.equalsIgnoreCase("green")) {
            greenball++;
            System.out.println("Green ball added.");
        } else {

            System.out.println("Invalid color.");
        }
    }

    public static void main(String[] args) {
        Bag bag = new Bag();
        bag.add("green");
        bag.add("red");
        bag.add("yellow");
        System.out.println("\nTotal balls: " + (bag.redball + bag.greenball + bag.yellowball));
        System.out.println("Red balls: " + bag.redball);
        System.out.println("Green balls: " + bag.greenball);
        System.out.println("Yellow balls: " + bag.yellowball);
    }
}