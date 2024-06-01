class Rectangle {

    private int length;
    private int width;

    // Parameterized constructor
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void display() {
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
    }
}

public class D_Array_of_objects {
    public static void main(String[] args) {

        // 1. Create an array of Rectangle objects
        Rectangle[] rects = new Rectangle[4];

        // 2. Initialize each element in the array with a Rectangle object
        rects[0] = new Rectangle(10, 5);
        rects[1] = new Rectangle(7, 8);
        rects[2] = new Rectangle(30, 15);
        rects[3] = new Rectangle(4, 4);

        // Display each Rectangle object in the array
        for (int i = 0; i < rects.length; i++) {
            System.out.println("Rectangle " + (i + 1));
            rects[i].display();
            System.out.println();
        }
    }
}
