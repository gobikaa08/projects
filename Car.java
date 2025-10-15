package mynewproject;
public class Car {
    // Attributes
    private String model;
    private String color;

    // Constructor
    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // Method to start the car
    public void start() {
        if (model == null || model.isEmpty()) {
            System.out.println("Car started");
        } else {
            System.out.println(model + " started");
        }
    }

    // Method to stop the car
    public void stop() {
        if (model == null || model.isEmpty()) {
            System.out.println("Car stopped");
        } else {
            System.out.println(model + " stopped");
        }
    }

    // Main method to run all test cases
    public static void main(String[] args) {
        
        Car car1 = new Car("Tesla", "Red");
        car1.start(); // Expected: Tesla started
        System.out.println();

        System.out.println(" Car(\"BMW\", \"Black\")");
        Car car2 = new Car("BMW", "Black");
        car2.start(); // Expected: BMW started
        System.out.println();

        System.out.println("🔹 TC3: Car(\"\", \"Blue\")");
        Car car3 = new Car("", "Blue");
        car3.start(); // Expected: Car started
        System.out.println();

        System.out.println("🔹 TC4: Car(\"Audi\", \"Silver\")");
        Car car4 = new Car("Audi", "Silver");
        // No method called → Expected: No output
        System.out.println("(No method called)");
        System.out.println();

        System.out.println("🔹 TC5: Car(\"Ford\", \"Green\")");
        Car car5 = new Car("Ford", "Green");
        car5.stop(); // Expected: Ford stopped
        System.out.println();
    }
}