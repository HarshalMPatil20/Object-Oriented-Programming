// Superclass
class Animal {

    // Method to be overridden
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
    public void move() {
        System.out.println("Animal is moving");
    }

}

// Subclass
class Dog extends Animal {

    // Overriding the makeSound() method
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

}

public class C_Method_overriding {
    public static void main(String[] args) {

        // Creating an instance of Animal
        Animal myAnimal = new Animal();
        myAnimal.makeSound();           // Output: Animal makes a sound

        // Creating an instance of Dog
        Dog myDog = new Dog();
        myDog.makeSound();              // Output: Dog barks
    }

}
