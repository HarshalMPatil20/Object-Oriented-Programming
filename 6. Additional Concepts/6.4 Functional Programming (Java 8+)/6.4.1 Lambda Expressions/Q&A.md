## Q&A on Lambda Expressions

### 1. What is a lambda expression?
A lambda expression is a **concise way to represent an anonymous function** that can be passed as data.  
It is mainly used to implement **functional interfaces**.

---

### 2. What problem do lambda expressions solve?
They eliminate **boilerplate code** created by anonymous inner classes and enable **functional programming style** in Java.

---

### 3. Can a lambda expression access local variables from the enclosing scope?

✔ Yes,  
but only if those variables are **effectively final** (i.e., not modified after initialization).

---
### 4. Can lambda expressions exist without functional interfaces?
❌ No.  
Lambdas only work with functional interfaces.

---

### 5. What are effectively final variables?

» Effectively final variables are those whose values are not changed after they are initialized.  
» Lambdas can access these variables from the enclosing scope.  
» Local variables used inside a lambda must not be modified after initialization.

✔ Valid:
```java
int x = 10;
() -> System.out.println(x);
```

❌ Invalid:
```java
int x = 10;
x++;
() -> System.out.println(x);
```
---

### 6. Can lambda expressions throw exceptions?

✔ Yes,  
but the functional interface method signature must declare it.
```java
Runnable r = () -> {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
};
```
---

### 7.What is the meaning of this inside a lambda?

Inside a lambda, this refers to the enclosing class, not the lambda itself.
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
---

### 8. Can lambda expressions be generic?

Yes, when used with generic functional interfaces.

```java
Function<Integer, String> f = x -> "Value: " + x;
```
---

### 9. What are common built-in functional interfaces?
Common built-in functional interfaces include:
- `Predicate<T>`: takes one argument, returns boolean
- `Function<T, R>`: takes one argument, returns a value
- `Consumer<T>`: takes one argument, returns void
- `Supplier<T>`: takes no arguments, returns a value
- `UnaryOperator<T>`: takes one argument, returns a value of the same type
- `BinaryOperator<T>`: takes two arguments, returns a value of the same type
---

### 10. Can lambda expressions be serialized?

❌ Not directly.  
Only possible if the functional interface extends `Serializable`.

>[!NOTE] 
>Because lambdas are not real objects or classes like anonymous classes     
>They are runtime-generated behavior, and Java avoids serializing unstable runtime details.

### » What does serialization mean?

Serialization = converting an object into a byte stream so it can be:

- Saved to disk
- Sent over a network
- Reconstructed later

For this, Java needs:

- A stable class definition
- Predictable object state

### » What happens if you try to serialize a lambda?
```java
Runnable r = () -> System.out.println("Hello");
```

❌ Compile-time error:

```csharp
Serializable is not a functional interface
Because Runnable does not extend Serializable.
```

### » How serialization can work with lambdas (the ONLY way)

Step 1: Functional interface must extend Serializable
```java
@FunctionalInterface
interface MyTask extends Runnable, Serializable {
}
```

Step 2: Use lambda with that interface
```java
MyTask task = () -> System.out.println("Hello");
```

✔ Now serialization is allowed

### » Why does this work?

By extending Serializable, you are telling Java:

>“I accept the risk. I know this lambda may be fragile across JVMs or versions.”


Java then:
- Stores a serialized lambda descriptor
- Not raw bytecode
- Reconstructs behavior via `LambdaMetafactory`

>[!IMPORTANT]
>Serialized lambdas are:  
>❌ Not portable across JVM versions  
>❌ Not safe for long-term storage   
>❌ Fragile if code changes     
>❌ Not guaranteed backward compatible

That’s why Java forces you to opt-in explicitly.

### » One-Line Mental Model 🧠

>**Lambdas are behavior, not data — and Java serializes data, not behavior.**

---

### 11. Where are lambda expressions most commonly used?

- Stream API
- Collection processing
- Callbacks
- Event handling
- Multithreading
- Functional-style pipelines
---

### 12. Can lambda expressions be recursive?
❌ No,  
because they do not have a name to refer to themselves.

---


### 13. can lambda expressions have state?
❌ No,
lambdas are stateless.

---

### 14. Can lambda expressions be nested?
✔ Yes,
lambdas can be defined inside other lambdas or methods.

---

### 15. Lambda Expression vs Anonymous Class
| Aspect             | Lambda Expression | Anonymous Class |
| ------------------ | ----------------- | --------------- |
| Code size          | Very short        | Verbose         |
| Scope              | No new scope      | New scope       |
| `this` keyword     | Enclosing class   | Anonymous class |
| Variable shadowing | ❌ Not allowed     | ✅ Allowed       |

---

### 16. Can lambda expressions be used with method references?
✔ Yes,
lambdas can be replaced with method references for cleaner code when applicable.
```java
Function<String, Integer> toLength = String::length;
```
---
### 17. Are lambda expressions thread-safe?
✔ Yes,
as long as they do not capture mutable shared state.

---
### 18. Can lambda expressions be used in place of traditional loops?
✔ Yes,
lambdas are often used with streams to replace traditional loops for collection processing.
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
    .filter(n -> n % 2 == 0)
    .forEach(System.out::println);
```
### 19. Can lambda expressions be assigned to variables?
✔ Yes,
lambdas can be assigned to variables of functional interface types.
```java
Predicate<Integer> isEven = n -> n % 2 == 0;
```
---
### 20. Can lambda expressions be passed as method arguments?
✔ Yes,
lambdas can be passed as arguments to methods that accept functional interfaces.
```java
void processNumbers(List<Integer> numbers, Predicate<Integer> condition) {
    for (Integer n : numbers) {
        if (condition.test(n)) {
            System.out.println(n);
        }
    }
}
processNumbers(Arrays.asList(1, 2, 3, 4, 5), n -> n % 2 == 0);
```
---
### 21. Can lambda expressions return values?
✔ Yes,
lambdas can return values based on the functional interface method signature.
```java
Function<Integer, Integer> square = n -> n * n;
System.out.println(square.apply(4)); // 16
```
---
### 22. Can lambda expressions be composed?
✔ Yes,
lambdas can be composed using default methods in functional interfaces.
```java
Function<Integer, Integer> add2 = n -> n + 2;
Function<Integer, Integer> multiply3 = n -> n * 3;
Function<Integer, Integer> addThenMultiply = add2.andThen(multiply3);
System.out.println(addThenMultiply.apply(4)); // (4 + 2) * 3 = 18
```
---
### 23. Can lambda expressions throw checked exceptions?
✔ Yes,
but the functional interface method signature must declare it.
```java
@FunctionalInterface
interface CheckedFunction<T, R> {
    R apply(T t) throws Exception;
}
CheckedFunction<String, Integer> parseInt = s -> Integer.parseInt(s);
try {
    System.out.println(parseInt.apply("123")); // 123
} catch (Exception e) {
    e.printStackTrace();
}
```
---
### 24. Can lambda expressions be used with default methods in interfaces?
✔ Yes,
lambdas can be used with interfaces that have default methods.
```java
@FunctionalInterface
interface MyInterface {
    void perform();

    default void defaultMethod() {
        System.out.println("Default method");
    }
}
MyInterface mi = () -> System.out.println("Performing action");
mi.perform(); // "Performing action"
mi.defaultMethod(); // "Default method"
```
---
### 25. Can lambda expressions be used with static methods in interfaces?
✔ Yes,
lambdas can be used with interfaces that have static methods.
```java
@FunctionalInterface
interface MyInterface {
    void perform();

    static void staticMethod() {
        System.out.println("Static method");
    }
}
MyInterface.staticMethod(); // "Static method"
```
---

### 26. Can lambda expressions be used with nested functional interfaces?
✔ Yes,
lambdas can be used with nested functional interfaces.
```java
interface Outer {
    @FunctionalInterface
    interface Inner {
        void execute();
    }
}
Outer.Inner inner = () -> System.out.println("Inner execution");
inner.execute(); // "Inner execution"
```
---
### 27. Can lambda expressions be used with var keyword?
✔ Yes,
lambdas can be assigned to variables declared with var.
```java
var greet = (String name) -> "Hello, " + name;
System.out.println(greet.apply("World")); // "Hello, World"
```
---
### 28. Can lambda expressions be used with switch expressions?
✔ Yes,
lambdas can be used within switch expressions for cleaner code.
```java
String day = "MONDAY";
String activity = switch (day) {
    case "MONDAY" -> (() -> "Go to gym").get();
    case "TUESDAY" -> (() -> "Attend meeting").get();
    default -> (() -> "Relax").get();
};
System.out.println(activity); // "Go to gym"
```
---
### 29. Can lambda expressions be debugged?
✔ Yes,
lambdas can be debugged using standard debugging tools, but stack traces may be less informative due to their anonymous nature.

---

### 30. Can lambda expressions be used with reflection?
✔ Yes,
lambdas can be inspected using reflection, but they do not have a direct class representation.
```java
Runnable r = () -> System.out.println("Hello");
Method m = r.getClass().getDeclaredMethods()[0];
System.out.println(m.getName()); // prints the synthetic method name
```
---

### 31. Can lambda expressions be used with annotations?
✔ Yes,
lambdas can be used in contexts where annotations are applicable, such as method parameters.
```java
void execute(@NotNull Runnable task) {
    task.run();
}
execute(() -> System.out.println("Task executed")); // "Task executed"
```
---
### 32. Can lambda expressions be used with custom functional interfaces?
✔ Yes,
lambdas can be used with any user-defined functional interface.
```java
@FunctionalInterface
interface MyFunction {
    int compute(int a, int b);
}
MyFunction add = (a, b) -> a + b;
System.out.println(add.compute(5, 3)); // 8
```
---
### 33. Can lambda expressions be used with higher-order functions?
✔ Yes,
lambdas can be passed to and returned from higher-order functions.
```java
Function<Integer, Function<Integer, Integer>> adder = a -> b -> a + b;
Function<Integer, Integer> add5 = adder.apply(5);
System.out.println(add5.apply(3)); // 8
```
---
### 34. Can lambda expressions be used with currying?
✔ Yes,
lambdas can be used to implement currying in Java.
```java

Function<Integer, Function<Integer, Integer>> curriedAdd = a -> b -> a + b;
Function<Integer, Integer> add10 = curriedAdd.apply(10);
System.out.println(add10.apply(5)); // 15
```
---
### 35. Can lambda expressions be used with tail recursion?
❌ No,
lambdas cannot be optimized for tail recursion in Java.

---

### 36. Can lambda expressions be used with memoization?
✔ Yes,
lambdas can be used to implement memoization for caching results.
```java
Function<Integer, Integer> fib = new Function<>() {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @Override
    public Integer apply(Integer n) {
        if (n <= 1) return n;
        return cache.computeIfAbsent(n, k -> apply(k - 1) + apply(k - 2));
    }
};
System.out.println(fib.apply(10)); // 55
```
---

### 37. Can lambda expressions be used with asynchronous programming?
✔ Yes,
lambdas can be used with asynchronous programming constructs like `CompletableFuture`.
```java
CompletableFuture.supplyAsync(() -> "Hello")
    .thenApply(greeting -> greeting + ", World!")
    .thenAccept(System.out::println); // "Hello, World!"
```
---
### 38. Can lambda expressions be used with dependency injection?
✔ Yes,
lambdas can be used with dependency injection frameworks that support functional interfaces.
```java
interface Service {
    void execute();
}
class Client {
    private final Service service;

    Client(Service service) {
        this.service = service;
    }

    void run() {
        service.execute();
    }
}
Client client = new Client(() -> System.out.println("Service executed"));
client.run(); // "Service executed"
```
---
