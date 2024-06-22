<img src="../src/wall1.jpg" alt="Image Alt Text"  >
&nbsp;

# Abstraction : _Mastering the Art of Hiding Complexity ..._ 🛡️✨

### _What Abstraction_ ?

Abstraction is a key concept in Object-Oriented Programming (OOP) that focuses on hiding the internal complexities of a system and exposing only the necessary parts. It allows developers to work with higher-level concepts without worrying about the underlying details.

### _Why Abstraction_ ?

- _Simplicity_
- _Security_
- _Reusability_

### Achieving Abstraction in Java

_Abstraction in Java can be achieved through:_

- __Abstract Classes__

- __Interfaces__

&nbsp;

## __Abstract Classes__

### _# What is an Abstract Class ?_

- There are two types of classes `Abstract class` and `Concrete class`

- If `abstract` keyword is used before the class then it is an Abstract Class
``` java 
abstract class <name> {.......}
```
- `Object cannot be created` for an Abstract class  

- Reference of abstract class is allowed.

&nbsp;

### _# What is an Abstract Method ?_

- `Method which is not having a body` is known as Abstract method, the method must be declared as abstract
``` java 
abstract class <name> {
    public abstract <Method Name> ();  // Abstract method (does not have a body)
}
```

- The abstract method is `undefined` method.

- ___Even if at least one of the  methods is abstract then the class is Abstract class.___

&nbsp;

### _# How to Inherit Abstract Class ?_

- As Abstract class : If any other class inherits abstract class then that class also becomes
abstract class. A Sub class must override an abstract method or else it will become abstract class
- As Concrete class : `subclass must override the all undefined method and provide body to all undefined method`

- A class becomes useful if it overrides all the methods of abstract class

&nbsp;

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../src/abstractclass.png" alt="Image Alt Text" width="600" >
 

&nbsp;

### Example :

- #### Abstract Class : Animal

```java
abstract class Animal {

    // Abstract method (does not have a body)
    public abstract void makeSound();

    // Concrete method
    public void sleep() {
        System.out.println("Animal is sleeping.");
    }
}
```

- #### Subclass : Dog

```java
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
```

- #### Implementation

```java
public class A_Abstract_class {

    public static void main(String[] args) {
        // Create an instance of Concrete class Dog 
        Dog dog = new Dog();
        
        // Call the methods
        dog.makeSound();  // Outputs: Dog barks.
        dog.sleep();      // Outputs: Animal is sleeping.
        dog.wagTail();    // Outputs: Dog is wagging its tail.
    }
}
```

> [!CAUTION]
> An Abstract class & An Abstract Method `can neither be final nor static` because if it is made final then it cannot be extended whereas abstract class is `meant for inheritance` & cannot be overridden whereas Abstract method is `meant for overriding`.

&nbsp;

### _What is the use of abstract class ?_

- Abstract classes are used for `imposing standards` and `sharing methods`

- Sub classes are `meant for following standards`

&nbsp;