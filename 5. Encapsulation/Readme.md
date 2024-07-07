<img src="../src/wall1.jpg" alt="Image Alt Text"  >
&nbsp;

# 5. Encapsulation : _The Secret Keeper of Code..._ 🤐🔐

### Introduction

_In the world of programming, encapsulation is the gatekeeper that ensures the safety and integrity of our data. It bundles the data (variables) and the methods (functions) that operate on the data into a single unit called a class. Encapsulation also restricts direct access to some of an object's components, which is a means of preventing unintended interference and misuse._

### Key Concepts of Encapsulation

1. **Data Hiding**: The ability to hide the implementation details of an object from the outside world, and only expose the necessary information through public methods.

2. **Abstraction**: The concept of showing only the necessary information to the outside world while hiding the internal implementation details.
3. **Encapsulation**: The bundling of data and methods that operate on that data within a single unit (class).

4. **Access Modifiers**: Keywords like public, private, and protected that control access to the
members of a class.

&nbsp;

## Encapsulation

``` mathematica
|
├── 1. Access Modifiers 
│           ├── Private 
│           │       ├── Fields
│           │       ├── Methods
│           │       └── Nested Classes
│           ├── Protected
│           ├── Public
│           └── Default (Package-private)
│
├── 2. Getter and Setter Methods
│
├── 3. Data Hiding
│           ├── Encapsulation of Fields
│           ├── Access through Methods
│           └── Immutable Objects
│
├── 4. Information Hiding
│           ├── Abstraction
│           ├── Interface Contracts
│           ├── Inner Workings Concealment
│           └── Modularization
│
└── 5. Encapsulation in Classes
            ├── Properties (Fields)
            │       ├── Instance Variables
            │       ├── Constants
            │       └── Static Variables
            ├── Methods
            │       ├── Instance Methods
            │       ├── Constructors
            │       └── Static Methods
            ├── Constructors
            │       ├── Default Constructor
            │       ├── Parameterized Constructor
            │       ├── Constructor Overloading
            │       ├── Copy Constructor 
            │       ├── Constructor Chaining
            │       ├── Private Constructor
            │       │       ├── Singleton Pattern in Java
            │       │       └── Utility Class in java
            │       ├── Static Initialization Blocks 
            │       └── Copy Assignment Operator
            └── Nested Classes
                    ├── Nested Inner Classes
                    ├── Local Inner Classes
                    ├── Anonymous Inner Classes 
                    └── Static Inner Classes 
```

&nbsp;

## 1. Access Modifiers

Access modifiers determine the accessibility of classes, methods, and fields. There are four access modifiers in Java

| Modifier |Visibility | Accessibility |
| --- | --- | --- |
| Public | Everywhere | Accessible from anywhere |
| Protected | Same package and subclasses | Accessible within the same package and subclasses |
| Default (Package-private) | Same package | Accessible within the same package |
| Private | Same class | Accessible only within the same class |

&nbsp;

## 2. Getter and Setter Methods

Getter and setter methods are used to control access to an object's properties. They are also known as
accessor methods.

- Getter methods are used to retrieve the value of a property.
- Setter methods are used to set the value of a property.

&nbsp;

## 3. Data Hiding

Data hiding is a fundamental principle in object-oriented programming (OOP) that involves concealing the internal state (data) of an object and restricting direct access to it.

- #### Encapsulation of Fields : 
    Declare fields as private to hide them from external access.

    ```java
        public class Person {
            private String name; // Private field
        }
    ```

- #### Access through Methods : 
    Provide getter and setter methods to control access to the fields.

     ```java
    public class Person {
        private String name; // Private field
    
        // Public getter method for the name field
        public String getName() {
            return name;
        }
    
        // Public setter method for the name field
        public void setName(String newName) {
            name = newName;
        }
    }
    ```

- #### Immutable Objects : 
    Create immutable objects by making fields final and providing only getter methods.

    ```java
    public final class ImmutablePerson {
        private final String name; // Private final field
        
        // Constructor to initialize the immutable object
        public ImmutablePerson(String newName) {
            name = newName;
        }
        
        // Public getter method for the name field (no setter method)
        public String getName() {
            return name;
        }
    }
    ```

&nbsp;

## 4. Encapsulation in Classes

- #### **Properties (Fields)** : Encapsulation involves declaring class properties (fields) to store data. These fields can have different access levels (e.g., private, protected, public) to control access.

  - #### **Instance Variables** : 
    These are variables declared inside a class but outside any method. They are specific to each instance of the class.

    ```java
        private int age;
    ```

  - #### **Constants** : 
    These are variables declared as `final` and typically `static`, meaning their values cannot be changed once initialized.

    ```java
        private static final int MAX_AGE = 100;
    ```

  - #### **Static Variables** : 
    These are variables shared by all instances of the class. They are declared with the static keyword.

    ```java
        private static int numberOfInstances;
    ```

&nbsp;

- #### **Methods (Behavior)** : Encapsulation also involves defining methods that operate on the properties, providing a way to interact with the object without directly accessing its internal state.

  - #### **Instance Methods**: 
    Methods that operate on instance variables and can access instance-specific data.

    ```java
        public int getAge() {
            return age;
        }
    ```

  - #### **Constructors**: 
    Special methods used to initialize objects. They have the same name as the class and do not have a return type.

    ```java
        public Person(int initialAge) {
            age = initialAge;
        }
    ```

  - #### **Static Methods**:  
    Can be called without creating an instance of the class. They belong to the class rather than instances of the class. They are declared with the `static` keyword.

    ```java
        public static int getNumberOfInstances() {
            return numberOfInstances;
        }
    ```

&nbsp;

- #### **Constructors**
  - #### **Default Constructor**: 
    A constructor with no parameters, used to initialize objects with default values.

    ```java
        public Person() {
            age = 0;
        }
    ```

  - #### **Parameterized Constructor**: 
    A constructor with parameters, used to initialize objects with specific values.

    ```java
        public Person(int initialAge) {
            age = initialAge;
        }
    ```

  - #### **Constructor Overloading** : 
    Multiple constructors with different parameter lists, allowing for flexibility in object initialization.

    ```java
        public Person() {
            age = 0;
        }
        public Person(int initialAge) {
            age = initialAge;
        }
    ```

  - #### **Copy Constructor**: 
    A constructor that creates a copy of an existing object.

    ```java
        public Rectangle(Rectangle other) {
            this.length = other.length;
            this.width = other.width;
        }
    ```

  - #### **Constructor Chaining** : 
    Calling one constructor from another, allowing for code reuse and simplifying object initialization.

    ```java
        public Person() {
            this(15);
        }
        private Person(int initialAge) {
            age = initialAge;
        }
    ```

    &nbsp;
  - #### **Private Constructors** : 
    Used to prevent external instantiation of a class, often in `singleton or utility classes`.
    - Singleton Pattern in Java : The singleton pattern ensures that a class has only one instance and provides a global point of access to it.

        ```java
            public class Singleton {
            
            private static Singleton instance;   // Single instance of the class

            
            private Singleton() {} // Private constructor to prevent instantiation

            
            public static Singleton getInstance() { // Public method to provide access to the instance
                if (instance == null) {
                    instance = new Singleton();
                }
                return instance;
            }

            // Example method
            public void showMessage() {
                System.out.println("Hello, I am a singleton!");
            }

            public static void main(String[] args) {
                Singleton singleton = Singleton.getInstance();
                singleton.showMessage(); // Output: Hello, I am a singleton!
            }
        }

        ```

    - Utility Class in Java : Utility classes are classes that contain only static methods and/or fields and are not meant to be instantiated.

        ```java
        public class MathUtils {
            // Private constructor to prevent instantiation
            private MathUtils() {}

            // Static utility method
            public static int add(int a, int b) {
                return a + b;
            }

            public static void main(String[] args) {
                int result = MathUtils.add(5, 3);
                System.out.println("Result: " + result); // Output: Result: 8
            }
        }
        ```

        &nbsp;

  - #### **Static Initialization Blocks** : 
    Used to initialize static variables or perform static initialization tasks.

    ```java
        public class StaticBlockExample {
        // Static fields
            private static int count;
            private static final List<String> names = new ArrayList<>();

            // Static initialization block
            static {
                count = 10;
                names.add("Alice");
                names.add("Bob");
                names.add("Charlie");
                System.out.println("Static block executed. Count initialized to " + count);
            }

            // Another static initialization block
            static {
                System.out.println("Another static block executed. Names list initialized with " + names.size() + " elements.");
            }

            // Static method to display values
            public static void displayValues() {
                System.out.println("Count: " + count);
                System.out.println("Names: " + names);
            }

            public static void main(String[] args) {
                // Display values
                StaticBlockExample.displayValues();
            }
        }
    ```

    ```vbnet
        Static block executed. Count initialized to 10
        Another static block executed. Names list initialized with 3 elements.
        Count: 10
        Names: [Alice, Bob, Charlie]
    ```

  - #### **Copy Assignment Operator** : 
    Overloading the assignment operator to create a deep copy of an object. (c++)

    &nbsp;

- ### _**Nested Classes**_ :
    In Java, nested classes are classes defined within another class. Java supports four types of nested classes: static nested classes, inner classes, local classes, and anonymous classes. Each type serves different purposes and has different characteristics.

    - ### **1. Nested Inner Class** :
        - Definition: Non-static classes defined within another class.
        - Access: Can access all members of the outer class, including private members.

        - **Instantiation** : Requires an instance of the outer class to be created.

            ```java
            OuterClass.InnerClass i = OuterClass().new InnerClass();
            ```

        - Usage: Used when instances of the inner class need to be associated with an instance of the outer class.

            Example :
                &nbsp;

            ```java
            public class OuterClass {
                private int outerValue;

                public class InnerClass {
                    public void printOuterValue() {
                        System.out.println("Outer value: " + outerValue);
                    }
                }
            }        
            ```
        &nbsp;

    - ### **2. Local Inner Class** :
        - Definition: Classes defined within a method.
        - Access: Can access all members of the outer class, including private members.

        - **Instantiation** : Can be instantiated only within the method where it is defined.

        - Usage: Used when a class is needed only within a specific method.

        Example :

        ```java
            public class OuterClass {

                public void method() {

                    class LocalInnerClass {
                        public void printMessage() {
                            System.out.println("Hello from local inner class!");
                        }
                    }
                            LocalInnerClass localInner = new LocalInnerClass();
                            localInner.printMessage();
                }
            }
        ```
        &nbsp;

    - ### **3. Anonymous Inner Class** :
        - Definition: Classes defined without a name.
        - Access: Can access all members of the outer class, including private members.

        - **Instantiation** : Can be instantiated only once, when it is defined.

        ```java
            new Object() {  // This part creates an anonymous class that extends the Object class
                public void printMessage() {
                    System.out.println("Inside anonymous class");
                }
            }.printMessage();
        ```
        - Usage: Used when a class is needed only once, and its implementation is simple.

        Example :

        ```java
            abstract class abstractClass {  // can use Interface also 
                abstract void printMessage();
            }

            public class OuterClass {

                void display() {

                    abstractClass anonymousInner = new abstractClass() {
                        @Override
                        public void printMessage(){
                            System.out.println("Hello from anonymous inner class!");
                        }
                    };
                    anonymousInner.printMessage();
                }
            }
        ```
        &nbsp;

    - ### **4. Static Inner Class** :
        - Definition: Static classes defined within another class.
        - Access: `Can access only static members` of the outer class.

        - Instantiation: Can be instantiated without an instance of the outer class.

        ```java
        OuterClass.StaticInnerClass i = new OuterClassStaticInnerClass();
        ```

        - Usage: Used when instances of the nested class do not need to be associated with an instance

            Example :

        ```java
            public class OuterClass {
                static class StaticInnerClass {
                    void display() {
                        System.out.println("Inside static nested class");
                    }
                }
            }

            public class Main {
                public static void main(String[] args) {
                    OuterClass.StaticInnerClass i = new OuterClass.StaticInnerClass();
                    i.display();
                }
            }
        ```
        &nbsp;
