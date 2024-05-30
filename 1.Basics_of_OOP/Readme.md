# Basics of Object-Oriented Programming (OOP)

## Introduction to Object-Oriented Programming (OOP)

Object-Oriented Programming (OOP) is a programming paradigm that organizes code into objects, which are instances of classes. It focuses on the concepts of abstraction, encapsulation, inheritance, and polymorphism.

OOP allows for modular and reusable code by providing a way to model real-world entities as objects with their own properties (attributes) and behaviors (methods). This approach promotes code organization, maintainability, and scalability.

In OOP, classes serve as blueprints for creating objects. They define the attributes and methods that objects of that class will have. Objects are instances of classes, and each object can have its own unique state while still sharing the same behavior defined by the class.

<span style="color:yellow">Abstraction</span>, <span style="color:yellow">encapsulation</span>, <span style="color:yellow">inheritance</span>, and <span style="color:yellow">polymorphism</span> are the four fundamental principles of OOP. They provide a way to structure and design software systems, making them more flexible, extensible, and easier to understand and maintain.

By using OOP, developers can create modular and reusable code, improve code organization and readability, and build complex systems that are easier to manage and evolve over time.

## Principles Of Object-Oriented Programming

- <span style="color:yellow">Abstraction</span>
- <span style="color:yellow">Encapsulation</span>
- <span style="color:yellow">Inheritance</span>
- <span style="color:yellow">Polymorphism</span>

<img src="../src/piller.jpg" alt="Image Alt Text" width="350" >

## 1. Abstraction

- ```Abstraction means hiding internal details and showing the required things```

Abstraction is the process of simplifying complex systems by breaking them down into smaller, more manageable parts. It allows us to focus on the essential features of an object or system while hiding unnecessary details.

Example: Imagine a car. As a driver, <span style="color:yellow">you don't need to know</span> how the engine works internally. You only need to know how to start the car, accelerate brake, and change gears.

## 2. Encapsulation

- ```Encapsulation is the process of grouping data in a single section.```

Encapsulation is the practice of bundling data and methods that operate on that data into a single unit called an object. It provides data hiding and protects the internal state of an object from external interference.

Example: Complete television is single box where all the mechanism are hidden inside the box all are capsuled

## 3. Inheritance

- ```Inheritance means designing an object or a class by re-using the properties of the existing class and object.```
- ```Inheritance is same as specialization.```

Inheritance is a mechanism that allows a class to inherit properties and behaviors from another class. It promotes code reuse and enables the creation of hierarchical relationships between classes.

Example: A old style television (idiot box) is transformed with extra features into slim and smart television where it re-used the properties of old television

## 4. Polymorphism

- ``` Polymorphism is a concept in which we can execute a single operation in different ways. ```
- ```Polymorphism is same as generalization.```

Polymorphism allows objects of different classes to be treated as objects of a common superclass. It enables the use of a single interface to represent different types of objects, providing flexibility and extensibility.

Example: Consider a Shape superclass with a method called calculateArea(). We can have different subclasses like Circle and Rectangle that override the calculateArea() method to provide their own implementation.

## Class Vs Object

<img src="../src/classvsobject.webp" alt="Image Alt Text" width="750" >

- Object is defined in terms of its `properties` and `behavior`
- Operation of behaviors will affect the properties.
- Anything in the world can be defined in the terms of properties and behavior.

- For a `single class we can have many objects.`

- Multiple number of objects can be created by one single class  

For example :
A house or a car or a television is an object but the design or blueprint of the
object is a class.

### Example Program

```
class Television { 

    private int channel; 
    private int volume; 
 
    public void changechannel() 
    public void changevolume() 
} 

class test 
{ 
    public static void main() { 

        Television t=new Television(); 
        t.changechannel(10); 
    } 
}
```

- In java there is an area inside main memory which is known as
method area which contains all the methods.

- The definitions of the will be present inside the heap, as the objects will be based on the definitions so the objects are also present in heap.

<img src="../src/Objectform.png" alt="Image Alt Text" width="350" >

## How to Write Classes

## 1. Circle

- Radius

<img src="../src/circle.png" alt="Image Alt Text" width="150" >

```
class Circle 
    {
        public double radius;
    
        public double area() {
            return Math.PI*radius*radius;
        }

        public double perimeter() {
            return 2*Math.PI*radius;
        }

        public double circumference() {
            return perimeter();
        } 
    }
```

## 2. Rectangle

- Length
- Breadth

<img src="../src/rectangle.png" alt="Image Alt Text" width="250" >

```
class Rectangle 
    { 
        public int length; 
        public int breadth; 
 
        public int area() { 
            return length*breadth; 
        } 

        public int perimeter () { 
            return 2*(length+breadth); 
        } 
    }
```

## 3. Cylinder

- Length
- Breadth

<img src="../src/cylinder.png" alt="Image Alt Text" width="200" >

```
class Cylinder 
    { 
        public double radius; 
        public double height; 
 
        public double lid_area() { 
            return 2*Math.PI*radius*radius; 
        } 

        public double Surface_area() { 
            return 2*Math.PI*radius*height; 
        } 

        public double Volume() { 
            return Math.PI*radius*radius*height; 
        } 
    }
```

## 4. Account

- Account Number
- Name
- Balance

```
class Account
    { 
        public long account_number; 
        public string name; 
        public double balance;
 
        public void Deposit (double amount) { 
            balance += amount; 
        }

        public void Withdraw (double amount) { 
            balance -= amount; 
        }  
    }
```

# ``Important`` : `tostring()`

## 1. Using the `Overriden` toString() Method

- The `toString()` method in Java is used to return a string representation of an object.
- It's often `overridden` in classes to provide a more meaningful or customized string representation of the object's state.
- Here's how you can use and override the toString() method in a Java class :

```
public class Car {
    String make;
    String model;
    int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    //we can override toString() method to get a string representation of our choice, Modify tostring method as you want.

    public String toString() {
        return year + " " + make + " " + model;
    }

}

class overriden_tostring {

    public static void main(String[] args) {

        Car myCar = new Car("Toyota", "Camry", 2022);

        //when we print an object, toString() method is called implicitly
        
        System.out.println(myCar);  // Output: 2022 Toyota Camry

        System.out.println(myCar.toString()); // Output: 2022 Toyota Camry
        
    }
}

```

[For Demo Try it Here](example2.java)

## 2. Using the Default toString() Method

- If you don't override the toString() method in your class, Java will use the `default implementation` from the Object class. 
- This default implementation returns a string that consists of `the class name, @ symbol, and the object's hash code`

```
public class Car {
    String make;
    String model;
    int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
}

public class default_tostring { 
    
    public static void main(String[] args) {

        Car myCar = new Car("Toyota", "Camry", 2022);

        System.out.println(myCar);  // Output: Car@1f6e597d
        System.out.println(myCar.toString());  // Output: Car@1f6e597d
    }
}
```
