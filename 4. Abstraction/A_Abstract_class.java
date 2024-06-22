abstract class Animal {

    // Abstract method (does not have a body)
    public abstract void makeSound();

    // Concrete method
    public void sleep() {
        System.out.println("Animal is sleeping.");
    }
}
class Dog extends Animal {
    
    // Implementing the abstract method
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }

    // Additional method specific to Dog
    public void wagTail() {
        System.out.println("Dog is wagging its tail.");
    }
}
public class A_Abstract_class {
    public static void main(String[] args) {

        // Create an instance of Concrete class Dog
        Dog myDog = new Dog();

        // Call the methods
        myDog.makeSound();  // Outputs: Dog barks.
        myDog.sleep();    // Outputs: Animal is sleeping.
        myDog.wagTail();  // Outputs: Dog is wagging its tail.
    }
}
