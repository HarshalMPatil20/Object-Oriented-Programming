# Lambda Expressions in Java

## 1. What is a Lambda Expression?

A **lambda expression** is a concise way to represent a **function as data**.

> **Lambda = function without a name**

Introduced in **Java 8**, lambdas reduce boilerplate code and are used to implement **functional interfaces**.

---

## 2. Why Lambda Expressions?

Before Java 8, behavior was passed using anonymous classes:

```java
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Hello");
    }
};
```
With lambdas:

```java
Runnable r = () -> System.out.println("Hello");
```
✔ Cleaner  
✔ Shorter  
✔ More readable   

---

## 3. Core Concept: Functional Interface

**A functional interface:**

- Has exactly one abstract method

- Can have default and static methods

- Is required for lambda expressions

```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
```
```java
Calculator calc = (a, b) -> a + b;
```
---
### Lambda Syntax
#### General Form
```java
(parameters) -> expression
```

or

```java
(parameters) -> { statements }
```
### Common Syntax Patterns
#### Single Parameter

```java
x -> x * x
```
#### Multiple Parameters
```java
(a, b) -> a + b
```
#### Multiple Statements
```java
(a, b) -> {
    int sum = a + b;
    return sum;
}
```
#### No Parameters
```java
() -> System.out.println("Hello");
```
--- 


## 4. Variable Capture (Effectively Final)

>[!CAUTION]
>  **Effectively Final**:  
>A variable is effectively final if its value is not changed after it is initialized.
>Lambdas can access variables from the enclosing scope **only if they are not modified**.  
> ✔ This is valid:

```java
int factor = 2;

Function<Integer, Integer> multiply = x -> x * factor;
```

>❌ This is invalid:

```java
factor++; // breaks lambda
```  

### » BUT, Why? What is the reasoning behind this restriction?  

>[!IMPORTANT] 
>Because lambdas Capture values, not variables  
> Java enforces this to keep lambdas safe, predictable, and thread-safe

#### The Example That Java Does NOT Allow

```java
int x = 10;

Runnable r = () -> System.out.println(x);

x = 20;   // ❌ Compile-time error
```
Java says:

> Local variable x must be final or effectively final

#### » Why does Java reject this?

Because lambdas capture the ✔ VALUE  of x, not the ❌ variable  itself.

#### » What Java Internally Tries to Do (Conceptually)

When the lambda is created, Java behaves as if it does this:

```java
int capturedX = x;  // captured at lambda creation time

Runnable r = () -> System.out.println(capturedX);
```

At that moment:
```java
x = 10
capturedX = 10
```

Now you change x later:

```java
x = 20;
```

But the lambda still holds:

```java
capturedX = 10
```

The lambda cannot see the updated value of x because it only captured the original value (10) when it was created.

### ❓ The Ambiguity Problem

Now ask yourself:

```java
r.run();
```

👉 Should it print 10 (captured value)?  
👉 Or 20 (current value)?

### Java refuses ❌ to guess.

-  This confusion = unpredictable behavior = bugs.

So Java says:

- “If you want to capture it, don’t change it.”

### » Why This Becomes Dangerous With Threads ?

Imagine this:

``` java
int x = 10;

Runnable r = () -> {
    try { Thread.sleep(1000); } catch (Exception e) {}
    System.out.println(x);
};

new Thread(r).start();
x = 20;
```

Timeline:

1. Lambda captures x = 10
2. Thread sleeps
3. Main thread changes x to 20  
4. Lambda wakes up and prints… ❓

### Race condition 💥  

- Different runs could print different values.

- Java kills this problem at compile time.

### » Why This IS Allowed (Effectively Final)
```java
int x = 10;

Runnable r = () -> System.out.println(x);
// x never changes

```
✔ No ambiguity  
✔ No race condition   
✔ Safe to capture


### » Why Instance Variables Are Different

```java
class Test {
    int x = 10;

    void run() {
        Runnable r = () -> {
            x = 20;   // ✅ allowed
        };
    }
}
```


### » Why allowed?

- Instance variables live on the heap

- Shared state is explicit

- Programmer takes responsibility

Java trusts you here !

---

### One-Line Mental Model 🧠

>[!NOTE]
>Local variables are copied into lambdas → copies must never change.


---

## 5. Functional Interface Examples

### **1. Predicate** » returns boolean

*Checks a condition*

```java
Predicate<Integer> isEven = n -> n % 2 == 0;

System.out.println(isEven.test(4)); // true
```

---

### **2. Function** » Input → Output

*Transforms data*

```java
Function<Integer, String> toString = n -> "Value: " + n;
System.out.println(toString.apply(5)); // "Value: 5"
```
---

### **3. Consumer** » takes input, no return

 *Performs an action*

```java
Consumer<String> print = s -> System.out.println(s);

print.accept("Hello, World!"); // prints "Hello, World!"
```

---

### **4. Supplier** » no input, returns output

*provides a value*

```java
Supplier<Double> random = () -> Math.random();

System.out.println(random.get()); // prints a random number
```

---

### **5. UnaryOperator** » *Operates on a single value*

```java
UnaryOperator<Integer> square = n -> n * n;

System.out.println(square.apply(4)); // 16
```
---
### **6. BinaryOperator** » *Combines two values*

```java
BinaryOperator<Integer> add = (a, b) -> a + b;

System.out.println(add.apply(3, 5)); // 8
```

---
### Built-in Functional Interface Mapping

| Interface              | Method        | Input | Output  | Typical Use                         |
|------------------------|---------------|-------|---------|-------------------------------------|
| `Predicate<T>`         | `test(T)`     | 1     | boolean | Conditions, filtering               |
| `Function<T, R>`       | `apply(T)`    | 1     | 1       | Data transformation                 |
| `Consumer<T>`          | `accept(T)`   | 1     | void    | Side effects (print, save, log)     |
| `Supplier<T>`          | `get()`       | 0     | 1       | Lazy value generation               |
| `UnaryOperator<T>`     | `apply(T)`    | 1     | 1       | Same-type input/output operations   |
| `BinaryOperator<T>`    | `apply(T, T)` | 2     | 1       | Combine two values                  |

---

---

## 6. Lambdas with Streams

- Lambdas are heavily used with Java Streams for functional-style operations on collections.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> evenNumbers = numbers.stream()
    .filter(n -> n % 2 == 0) // Predicate
    .map(n -> n * n)        // Function
    .collect(Collectors.toList());
System.out.println(evenNumbers); // [4, 16]
```
---

## 7. Lambda vs Method Reference

A **method reference** is a shorthand notation of a lambda expression to call a method.

#### Lambda

```java
x -> System.out.println(x)
```

#### Method Reference

```java
System.out::println
```

--- 

## 8. Lambda Expression vs Anonymous Class

| Aspect             | Lambda Expression | Anonymous Class |
| ------------------ | ----------------- | --------------- |
| Code size          | Very short        | Verbose         |
| Scope              | No new scope      | New scope       |
| `this` keyword     | Enclosing class   | Anonymous class |
| Variable shadowing | ❌ Not allowed     | ✅ Allowed       |
| Interface support  | Functional only   | Any interface   |
| Abstract class     | ❌ No              | ✅ Yes           |
| Object creation    | Lightweight       | Heavier         |
|Can Capture variables| Effectively final | Final only      |
|Serialization       | Not directly     | Yes             |
| Performance        | Better            | Slower          |

### 1. Code Size & Readability

- ####  Anonymous Class (Verbose)
    ```java
    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello");
        }
    };
    ```

- #### Lambda Expression (Concise)
    ```java
    Runnable r = () -> System.out.println("Hello");
    ```

### Why?

- Anonymous classes require:

    - Class creation

    - Method override

- Lambdas represent only behavior, not a class

👉 Lambda removes structural noise

### 2. Scope Difference (VERY IMPORTANT)

- #### Anonymous Class → Creates a NEW scope
    ```java
    class Test {
        int x = 10;

        void method() {
            int y = 20;

            Runnable r = new Runnable() {
                int x = 30;   // ✅ allowed (new scope)

                @Override
                public void run() {
                    System.out.println(x); // 30
                    System.out.println(y); // 20
                }
            };
        }
    }
    ``` 


✔ Anonymous class introduces its own scope  
✔ Can shadow variables (x)

- #### Lambda → NO new scope
    ```java
    class Test {
        int x = 10;

        void method() {
            int y = 20;

            Runnable r = () -> {
                // int x = 30; ❌ NOT allowed
                System.out.println(x); // 10
                System.out.println(y); // 20
            };
        }
    }
    ```


❌ Lambdas cannot shadow variables  
✔ They share the enclosing scope

### 3. Meaning of this (MOST ASKED)
- #### Anonymous Class → this refers to the anonymous object
    ```java
    class Test {
        void method() {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println(this.getClass());
                }
            };
            r.run();
        }
    }
    ```


Output (conceptually):

    ```java
    class Test$1
    ```

👉 this = anonymous class instance (new)

- #### Lambda → this refers to the enclosing class
    ```java
    class Test {
        void method() {
            Runnable r = () -> {
                System.out.println(this.getClass());
            };
            r.run();
        }
    }
    ```


Output:

    ```java
    class Test
    ```

👉 Lambda does not create a new object context

### 4. Functional Interface Restriction
- #### Lambda Expression

✔ Can be used only with functional interfaces

    ```java
    Runnable r = () -> System.out.println("Valid");
    ```

❌ Not allowed:

    ```java
    interface A {
        void m1();
        void m2();
    }

    // () -> {} ❌ Compile-time error
    ```

- #### Anonymous Class

✔ Can implement:

1. Interfaces (any number of methods)

2. Abstract classes

    ```java
    Thread t = new Thread() {
        @Override
        public void run() {
            System.out.println("Thread running");
        }
    };
    ```


👉 Anonymous classes are more flexible, but heavier.

### 5. Variable Capture Rules
- Anonymous Class
    ```java
    int x = 10;

    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println(x); // must be final/effectively final
        }
    };
    ```

- Lambda Expression
    ```java
    int x = 10;

    Runnable r = () -> System.out.println(x);
    ```

✔ Both require effectively final local variables  
✔ Rule is same, but lambdas capture values more transparently

### 6. Object Creation & Performance (Conceptual)

- Anonymous class:

    - Creates a new class

    - Creates a new object

- Lambda Expression:

    - May be optimized

    - Can be stateless and reused

   - Implemented via `invokedynamic`

👉 Lambdas are generally lighter-weight

### 7. When to Use What?

#### Use Lambda When:

- Implementing functional interfaces

- Writing stream operations

- Passing short behavior

- Readability matters

#### Use Anonymous Class When:

- Multiple methods required

- Need internal state

- Extending abstract classes
Complex logic



---
### Summary
#### Key Rules (Interview Ready)   
✔ Works only with functional interfaces  
✔ Parameters are type-inferred  
✔ Local variables must be effectively final  
✔ Enables functional programming in Java 

---

### One-Line Definition

**Lambda expressions allow passing behavior as data using functional interfaces in Java.**

---

## [Frequently Asked Questions & Answers >>>](https://github.com/HarshalMPatil20/Object-Oriented-Programming/blob/main/6.%20Additional%20Concepts/6.4%20Functional%20Programming%20(Java%208%2B)/6.4.1%20Lambda%20Expressions/Q%26A.md)