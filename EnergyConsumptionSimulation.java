package mynewproject;
import java.util.Scanner;

class Device {
    String name;
    double powerRating; // in Watts
    double usageHours;  // in Hours

    Device(String name, double powerRating, double usageHours) {
        this.name = name;
        this.powerRating = powerRating;
        this.usageHours = usageHours;
    }

    double calculateEnergyConsumption() {
        // Convert Watts * hours to kWh
        return (powerRating * usageHours) / 1000;
    }

    void displayConsumption() {
        System.out.println("Device: " + name);
        System.out.println("Power Rating: " + powerRating + " W");
        System.out.println("Usage Time: " + usageHours + " hrs");
        System.out.println("Energy Consumed: " + calculateEnergyConsumption() + " kWh");
        System.out.println("--------------------------------");
    }
}

public class EnergyConsumptionSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Device Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Power Rating (W): ");
        double power = sc.nextDouble();

        System.out.print("Enter Usage Hours: ");
        double hours = sc.nextDouble();

        Device d1 = new Device(name, power, hours);
        d1.displayConsumption();

        sc.close();
    }
}