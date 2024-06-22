class Shape {

    // Method to calculate area of a square
    public double Area(double side) {
        return side * side;
    }

    // Overloaded method to calculate area of a rectangle
    public double Area(double length, double width) {
        return length * width;
    }
}

class Circle extends Shape {
    
    // Overloaded method to calculate area of a Circle
    public double Area(double radius) {
        return Math.PI * radius * radius;
    }
}

public class B_Method_Overloading {

    public static void main(String[] args) {
        
        Shape shape = new Shape();

        // Calls Area(double) for a square
        System.out.println("Area of square with side 4: " + shape.Area(4.0));

        // Calls Area(double, double) for a rectangle
        System.out.println("Area of rectangle with length 5 and width 3: " + shape.Area(5.0, 3.0));

        Circle circle = new Circle();
        // Calls Area(double) for a circle
        System.out.println("Area of circle with radius 2.5: " + circle.Area(2.5));
    }
}