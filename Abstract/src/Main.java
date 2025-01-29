// Abstract Shape Class
abstract class Shape {
    abstract double calculateArea();
}

// Circle Class
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Rectangle Class
class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

// Payment Interface
interface Payment {
    void pay(double amount);
    void refund(double amount);
}

// Credit Card Payment Implementation
class CreditCardPayment implements Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded $" + amount + " to Credit Card.");
    }
}

// PayPal Payment Implementation
class PayPalPayment implements Payment {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal (" + email + ")");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded $" + amount + " to PayPal.");
    }
}

// Employee Management System
abstract class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    abstract void work();

    public void showDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + salary);
    }
}

// Manager Class
class Manager extends Employee {
    private String department;

    public Manager(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
    }

    @Override
    void work() {
        System.out.println(name + " is managing the " + department + " department.");
    }
}

// Intern Class
class Intern extends Employee {
    private int duration; // in months

    public Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    void work() {
        System.out.println(name + " is an intern for " + duration + " months.");
    }
}

// Main Class to Run the Mini-Project
public class Main {
    public static void main(String[] args) {
        // Testing Shapes
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Rectangle Area: " + rectangle.calculateArea());

        // Testing Payment System
        Payment creditCard = new CreditCardPayment("1234567890123456");
        Payment paypal = new PayPalPayment("user@example.com");

        creditCard.pay(100.0);
        paypal.pay(50.0);
        creditCard.refund(20.0);

        // Employee Management System
        Employee manager = new Manager("Alice", 101, 75000, "IT");
        Employee intern = new Intern("Bob", 102, 15000, 6);

        manager.showDetails();
        manager.work();

        intern.showDetails();
        intern.work();
    }
}
