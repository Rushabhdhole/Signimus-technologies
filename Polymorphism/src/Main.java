// Calculator class demonstrating method overloading
class Calculator {
    // Add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Concatenate two strings
    public String add(String str1, String str2) {
        return str1 + str2;
    }
}

// Parent class demonstrating method overriding
class Animal {
    public void sound() {
        System.out.println("Animals make sounds");
    }
}

// Subclass overriding the sound method
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

// Main class to test the implementations
public class Main {
    public static void main(String[] args) {
        // Testing method overloading in Calculator
        Calculator calc = new Calculator();
        System.out.println("Sum of 2 numbers: " + calc.add(5, 10));          // Output: 15
        System.out.println("Sum of 3 numbers: " + calc.add(3, 6, 9));        // Output: 18
        System.out.println("Concatenated String: " + calc.add("Hello, ", "World!")); // Output: "Hello, World!"

        // Testing method overriding in Animal and Dog classes
        Animal myAnimal = new Animal();
        myAnimal.sound();  // Output: "Animals make sounds"

        Dog myDog = new Dog();
        myDog.sound();  // Output: "Dog barks"

        // Polymorphism demonstration
        Animal polymorphicDog = new Dog();
        polymorphicDog.sound(); // Output: "Dog barks" (Method overriding in action)
    }
}
