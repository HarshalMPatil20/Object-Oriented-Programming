class AreaCalculator {

    // Method to calculate area of a square
    public double Area(double side) {
        return side * side;
    }

    // Overloaded method to calculate area of a rectangle
    public double Area(double length, double width) {
        return length * width;
    }

    // Overloaded method to calculate area of a circle
    public double Area(double radius, boolean isCircle) {
        return Math.PI * radius * radius;
    }
}

public class A_Method_Overloading {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        // Calls Area(double) for a square
        System.out.println("Area of square with side 4: " + calculator.Area(4.0));

        // Calls Area(double, double) for a rectangle
        System.out.println("Area of rectangle with length 5 and width 3: " + calculator.Area(5.0, 3.0));

        // Calls Area(double, boolean) for a circle
        System.out.println("Area of circle with radius 2.5: " + calculator.Area(2.5, true));
    }
}
