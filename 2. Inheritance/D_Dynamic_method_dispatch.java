// Superclass
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
    public void move() {
        System.out.println("Animal is moving");
    }
}

// Subclass - Dog
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}


public class D_Dynamic_method_dispatch {
    public static void main(String[] args) {

        Animal myAnimal = new Dog();  // Superclass reference points to a Dog object

        myAnimal.makeSound();  // Output: Dog barks (Dynamic Method Dispatch)

        myAnimal.move(); // Output: Animal is moving (Static Binding)
    }
}

