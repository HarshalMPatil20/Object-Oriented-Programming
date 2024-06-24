// Define the Animal interface
interface Animal {
    void run();
}

// Define the Flyable interface
interface Flyable {
    void fly();
}

// Define the Swimmable interface
interface Swimmable {
    void swim();
}

// Define the Duck class that implements all three interfaces
class Duck implements Animal, Flyable, Swimmable {

    @Override
    public void run() {
        System.out.println("Eating...");
    }

    @Override
    public void fly() {
        System.out.println("Flying...");
    }

    @Override
    public void swim() {
        System.out.println("Swimming...");
    }

    public void quack() {
        System.out.println("Quacking...");
    }
}

// Main class to demonstrate the functionality
public class C_Multiple_Inheritance {
    public static void main(String[] args) {
        Duck donald = new Duck();
        donald.run();    // From Animal
        donald.fly();    // From Flyable
        donald.swim();   // From Swimmable
        donald.quack();  // From Duck
    }
}


