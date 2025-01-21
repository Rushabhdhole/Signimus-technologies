class Car {
    // Attributes
    String brand;
    String color;
    int speed;

    // Constructor to initialize the attributes
    Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.speed = 0; // Initial speed is 0
    }

    // Method to start the car
    void start() {
        System.out.println(brand + " car is starting...");
    }

    // Method to stop the car
    void stop() {
        speed = 0;
        System.out.println(brand + " car is stopping...");
    }

    // Method to accelerate the car
    void accelerate(int increment) {
        speed += increment;
        System.out.println(brand + " car is accelerating. Speed is now " + speed + " km/h.");
    }

    // Main method to test the Car class
    public static void main(String[] args) {
        // Create objects of the Car class
        Car car1 = new Car("Toyota", "Red");
        Car car2 = new Car("Ford", "Blue");

        // Call methods for car1
        car1.start();
        car1.accelerate(50);
        car1.stop();

        // Call methods for car2
        car2.start();
        car2.accelerate(70);
        car2.stop();
    }
}
