interface Animal {

    int legs = 4;      // Variables (implicitly public, static, and final)

    void makeSound();  // Abstract method

    void eat();        // Abstract method
}

class Dog implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats kibble.");
    }

    public void wagTail() {
        System.out.println("Dog is wagging its tail.");
    }
}

public class B_Interface {
    public static void main(String[] args) {

        // Create an instance of Concrete class Dog
        Dog myDog = new Dog();

        // Call the methods
        myDog.makeSound();  // Outputs: Dog barks.
        myDog.eat();    // Outputs: Dog eats kibble.
        myDog.wagTail();  // Outputs: Dog is wagging its tail.
    }
}