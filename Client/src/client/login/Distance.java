package client.login;
public class Distance {
    // Private variables
    private int feet;
    private double inches;

    // Constructor
    public Distance(int feet, double inches) {
        this.feet = feet;
        this.inches = inches;
        normalize(); // Ensure inches are within range [0, 12)
    }

    // Method to normalize inches
    private void normalize() {
        if (inches >= 12) {
            feet += (int) inches / 12;
            inches = inches % 12;
        } else if (inches < 0) {
            feet -= (int) Math.ceil(-inches / 12);
            inches = 12 + (inches % 12);
        }
    }

    // Method to add two Distance objects
    public Distance add(Distance other) {
        int totalFeet = this.feet + other.feet;
        double totalInches = this.inches + other.inches;
        return new Distance(totalFeet, totalInches);
    }

    // Method to compare two Distance objects
    public int compareTo(Distance other) {
        // Convert both distances to inches for comparison
        double thisTotalInches = this.feet * 12 + this.inches;
        double otherTotalInches = other.feet * 12 + other.inches;

        return Double.compare(thisTotalInches, otherTotalInches);
    }

    // Method to display the distance
    @Override
    public String toString() {
        return feet + " feet " + inches + " inches";
    }

    // Main method for testing
    public static void main(String[] args) {
        Distance d1 = new Distance(5, 8.5);
        Distance d2 = new Distance(3, 10.0);
        
        Distance sum = d1.add(d2);
        System.out.println("Sum of distances: " + sum);

        int comparison = d1.compareTo(d2);
        if (comparison > 0) {
            System.out.println(d1 + " is greater than " + d2);
        } else if (comparison < 0) {
            System.out.println(d1 + " is less than " + d2);
        } else {
            System.out.println(d1 + " is equal to " + d2);
        }
    }
}