<img src="../../src/wall1.jpg" alt="Image Alt Text"  >
&nbsp;

# 6.3 &nbsp; Generics

Generics in Java are a powerful feature that allows you to write reusable code. They enable you to create classes, interfaces, and methods that operate on objects of any type. Generics provide type safety and help you avoid runtime errors by catching type mismatches at compile time.

## 1. Introduction to Generics

- Generics were introduced in Java 5.0 to provide compile-time type safety.
- They allow you to write classes, interfaces, and methods that operate on objects of any type.
- Generics enable you to create reusable code that can work with different types without the need for casting.

&nbsp;

## 2. Generic Classes

- A generic class is a class that can operate on objects of any type.
- You can create a generic class by using angle brackets (`<>`) to specify a type parameter.

Example :

```java
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```
In this example, `Box` is a generic class that can operate on objects of any type.

### Generic Class with Multiple Type Parameters :

```java
class Pair<K, V> {
    private K key;
    private V value;
    }
}
```
In this example, `Pair` is a generic class with two type parameters, `K` and `V`. 

### Generic Constructors :

```java
class Box <T> {
    private T value;

    public Box (T value) {
        this.value = value;
    }
}
```

### Generic Constructors without Generic Class :

```java
class Box {
    private Object value;

    public <T> Box (T value) {
        this.value = value;
    }
}
```
In this example, the `Box` class has a generic constructor that can accept objects of any type.



&nbsp;


## 3. Generic Methods

- A generic method is a method that can operate on objects of any type.
- You can create a generic method by using angle brackets (`<>`) to specify a type parameter before the return type.

Example :

```java
class Utils {
    public static <T> T getFirstElement(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
```

&nbsp;

## 4. Bounded Type Parameters

- You can `restrict the types that can be used as type arguments in a generic class or method`.
- Bounded type parameters allow you to specify upper bounds, lower bounds, or multiple bounds for a type parameter.
- Upper bounds are specified using the `extends` keyword, while lower bounds are specified using the `super` keyword.
- Multiple bounds are specified using the `&` operator.

- `First Extend class then implement 'n' number of interfaces.`
- `First super class then implement 'n' number of interfaces.`

Example :

```java
class Box <T extends Number & Comparable<T>> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```
In this example, the `Box` class has a type parameter `T` that is bounded by `Number` and `Comparable<T>`.

- This means that `T` must be a subclass of `Number` and implement the `Comparable` interface. The `&` operator is used to specify multiple bounds. 

&nbsp;

## 5. Type Inference

- Type inference is a feature in Java that allows the compiler to automatically determine the type of a variable or expression based on the context.

Example :

```java
List<String> names = new ArrayList<>();
names.add("John");
names.add("Doe");
```
In this example, the type of the `names` variable is inferred to be `List<String>` based on the type of the `ArrayList` object that is assigned to it.

&nbsp;

## 6. Wildcards

- Wildcards are used to represent unknown or unspecified types in a generic class or method.
- There are three types of wildcards in Java: `?`, `? extends T`, and `? super T`.
- The `?` wildcard is a type that can be any type, but it cannot be used to add elements to a collection.
- The `? extends T` wildcard is a type that is a subclass of `T`.
- The `? super T` wildcard is a type that is a superclass of `T`.

Example :

```java
List<?> list = new ArrayList<>();
List<? extends Number> numbers = new ArrayList<>();
List<? super Integer> integers = new ArrayList<>();
```
In this example, the `list` variable is a `List` of unknown type, the `numbers` variable is a `List` of numbers or subclasses of `Number`, and the `integers` variable is a `List` of integers or superclasses of `Integer`.

&nbsp;

## 7. Erasure

- Erasure is a process in Java where the generic type information is removed at compile-time, leaving only the raw type.
- This is done to maintain backward compatibility with older versions of Java that do not support generics.
- The type information is erased by replacing the type parameters with their upper bounds or the `Object` class.
- The erased type is then used to create the class file, which is then loaded and executed by the Java Virtual Machine (JVM).

Example :

```java
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```
After erasure, the `Box` class becomes :

```java
public class Box {
    private Object value;

    public Box(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
```
In this example, the `T` type parameter is replaced with `Object`, which is the upper bound of `T`.

&nbsp;

## 8. Summary
In this tutorial, we have covered the basics of Java generics, including type parameters, bounded type parameters, generic classes, generic methods, type inference, wildcards, and erasure. Generics are a powerful feature that allows you to write reusable code that can work with different types without the need for casting. They provide type safety and help you avoid runtime errors by catching type mismatches at compile time.

&nbsp;

## Conclusion
Java generics are a powerful feature that allows you to write reusable code that can work with different types without the need for casting. They provide type safety and help you avoid runtime errors by catching type mismatches at compile time. Generics are widely used in Java libraries and frameworks to create flexible and reusable code. By mastering generics, you can write more efficient and reliable code that is easier to maintain and extend.

