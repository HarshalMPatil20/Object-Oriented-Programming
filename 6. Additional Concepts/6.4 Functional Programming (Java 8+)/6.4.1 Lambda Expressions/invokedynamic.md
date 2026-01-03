
# invokedynamic in Java (JVM Internals)

## What is `invokedynamic`?

`invokedynamic` is a **JVM bytecode instruction** introduced in **Java 7** that allows **method calls to be resolved at runtime instead of compile time**.

> In simple terms:  
> **invokedynamic lets the JVM decide how a method call should behave when the program runs.**

---

## Why Was `invokedynamic` Introduced?

Before Java 7, the JVM supported only statically-bound call instructions:

| Instruction | Purpose |
|------------|--------|
| `invokestatic` | Static methods |
| `invokevirtual` | Instance methods |
| `invokeinterface` | Interface methods |
| `invokespecial` | Constructors, private methods |

These instructions are rigid and resolved early, making them inefficient for lambdas and dynamic languages.

---

## The Problem Lambdas Needed to Solve

If lambdas were implemented like anonymous classes:

```java
Runnable r = () -> System.out.println("Hello");
```

Java would need to:
- Generate a new class
- Load it
- Create an object

This approach is memory-heavy and slow.

---

## What Does `invokedynamic` Do?

Instead of binding a method at compile time, `invokedynamic` allows the JVM to:
- Decide the method behavior at runtime
- Cache the decision for future calls

---

## How `invokedynamic` Works

1. Compiler emits an `invokedynamic` instruction
2. JVM calls a bootstrap method at runtime
3. The call site is linked and cached

For lambdas, the bootstrap method used is:
```
LambdaMetafactory.metafactory()
```

---

## Why It’s Powerful

- Avoids extra class generation
- Enables JVM optimizations
- Allows lambda reuse
- Improves performance

---

## Anonymous Class vs Lambda

| Feature | Anonymous Class | Lambda |
|-------|----------------|--------|
| Extra class | Yes | No |
| Object creation | Always | Often avoided |
| JVM optimization | Limited | Aggressive |

---

## Interview-Ready Definition

> **`invokedynamic` is a JVM instruction that enables runtime method binding, making Java lambdas lightweight and highly optimized.**
