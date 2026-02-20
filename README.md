# Modular Monolith Quiz : Refactoring the Bookstore Application

## The Application
1. Created a bookstore application with dependencies : 
- Spring Web
- Spring Modulith 
2. Added the code as per the instructions in the quiz, which includes two modules: `orders` and `inventory`. The `orders` module contains an internal package `orders.internal`, which includes the `OrderValidator` class responsible for validating orders. 
3. Also a modularity test was added.

## Modularity Test Explanation
In the modularity test, we use the verify() method on the ApplicationModules instance to check whether our package structure follows proper module boundaries. When we run the test, it fails.

![Modulaity Tests Failing](FailedModularityTests.png)

## Why does it fail?

There is a dependency from the inventory module to the orders.internal package. This is not allowed.

The orders.internal package is intentionally hidden. It contains internal implementation details that should only be used inside the orders module. Other modules must not access it directly.

Because of this **cross-module access**, the modularity rules are violated.

## How Spring Modulith Enforces This

- Spring Modulith enforces module boundaries based on package structure.
- Each top-level package under the application base package is treated as a module.
- Sub-packages (like orders.internal) are considered internal.
- Other modules can access public types in the main package (orders),but they cannot access sub-packages of that module.


## Solution: `@NamedInterface` on Validator
To resolve the issue, we applied `@NamedInterface` to the `OrderValidator` class in the `orders.internal` package. This allows us to expose it as a public API without making the entire package public, thus maintaining encapsulation while satisfying the dependency requirements.

![Modularity Tests Passing](image.png)

