<img src="../../src/wall1.jpg" alt="Image Alt Text"  >
&nbsp;

# 6.1 &nbsp; Static & Final

Static and final are two important keywords in Java that modify the behavior of variables, methods, and classes. Understanding their usage is crucial for writing efficient and maintainable Java code.

## Static Keyword

- The `static` keyword in Java is used for  representing `Meta Data (data about data)` &  memory management primarily.
- It can be applied to variables, methods, blocks, and nested classes. When a member is declared static, it belongs to the class rather than to any specific instance of the class.

### 1. Static Variables

- Also known as class variables, are shared among all instances (objects) of the class.

- Static Variables can be accessed just by using class name.

Example :
```java
class HondaCity {
 
    static long price=1000000; // Same for every instance hence static
}
```
&nbsp;

### 2. Static Methods :

- Can be invoked without creating an instance of the class.
- Static methods `can only access static variable`s and other static methods.
- They are essentially utility methods that can be used without creating an instance of the class.

Example :
```java
class HondaCity { 
    static long price=1000000; // Same for every instance hence static 

    static double OnRoadPrice(String city) {  // only static variables are accessible
        Switch(city) {
            case "Delhi" : return price + 10000; 
            case "Mumbai" : return price + 5000; 
            default : return price; // Else return base price
        }
    } 
} 
```
&nbsp;
### 3. Static Blocks :

- Used to initialize static variables. They are executed only once when the class is loaded into memory.
- They are used to initialize static variables in a class.
- They are executed in the order they appear in the class.

Example :
```java
class HondaCity {
    static long price; // Static variable

    static {
        price = 1000000; // Initialize static variable
    }
}
```
&nbsp;
### 4. Static Nested Class (Static Inner Class) :

- Nested classes are classes defined inside another class.
- Static nested classes are classes that are defined inside another class and are declared static.
- They are `used to group related classes together`.
- They are accessed using the outer class name followed by the inner class name.
- They are not associated with any instance of the outer class.
- Nested classes that are static do not require an instance of the enclosing class.

Example :
```java
class HondaCity {
    
    static class engine { // Static nested class
        double HorsePower ; // Instance variable 
    }
}
```
&nbsp;

## Final Keyword

The `final` keyword in Java is used to restrict the user. It can be applied to variables, methods, and classes.

### 1. Final Variables : 

- Final variables are variables that cannot be modified once they are initialized.
- They are declared using the `final` keyword.
- They are initialized only once.
- They are used to make the code more secure and reliable.
- They are used to make the code more efficient by reducing the number of variables that need to be
initialized.

Example :
```java
class HondaCity {
    final int price = 1000000; // Final variable
}
```
&nbsp;
### 2. Final Methods :

- Final methods are methods that `cannot be overridden` by subclasses.
- They are declared using the `final` keyword.  
- They are used to make the code `more secure and reliable`.

Example :
```java
class HondaCity {
    
    final void CarType() { // Final method
        System.out.println("Honda City is a 5 seater Sedan car");
    }
}
```
&nbsp;
### 3. Final Classes :

- Final classes are classes that `cannot be extended` by subclasses.
- They are declared using the `final` keyword.
- They are used to make the code `more secure and reliable`

Example :
```java
final class HondaCity { // Final class

    void CarType() { 
        System.out.println("Honda City is a 5 seater Sedan car");
    }
}
```
&nbsp;

### Comparison of Static and Final Keywords in Java :

|  Aspect   | Static   | Final    |
| --- | ---| --- |
|  Definition   |Belongs to the class rather than an instance.    | Imposes restrictions (immutability/constant behavior).    |
| Usage with Variables    |Shared among all instances of the class.    | Value cannot be changed once initialized.    |
| Usage with Methods    | Can be called without creating an instance.   |Cannot be overridden by subclasses.     |
| Usage with Classes    | (Subclass only) Don't require an instance to initialized  | Class cannot be subclassed (inherited).    |
| Usage with Blocks	    | Used for static initialization.   |     |
| Memory Management    |Helps in memory management by sharing data.    |   Helps in defining constants or immutable behaviors.  |
| Accessibility    | Accessible via class name.   |  Can be accessed based on access modifiers (public, private, etc.).   |
| Inheritance Impact    |    | Prevents inheritance for final classes and method overriding.    |
| Initialization    | Can be initialized when declared or in a static block.   | Must be initialized at the time of declaration or in the constructor (for variables).    |

&nbsp;
>[!NOTE]
>Top-Level Classes `cannot be declared as static` because they are not members of any other class.









