import java.util.ArrayList;

class Device {
    String name;
    int year;
    double price;
    String color;
    String type;

    public Device(String name, int year, double price, String color, String type) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Device> devices = new ArrayList<>();
        devices.add(new Device("Phone", 2022, 1000.0, "Black", "Smartphone"));
        devices.add(new Device("Laptop", 2021, 1500.0, "Silver", "Computer"));
        devices.add(new Device("Tablet", 2020, 800.0, "White", "Tablet"));

        System.out.println("All devices:");
        for (Device device : devices) {
            System.out.println(device.name + " - Year: " + device.year + ", Price: $" + device.price + ", Color: " + device.color + ", Type: " + device.type);
        }

        System.out.println("\nDevices of color 'Black':");
        for (Device device : devices) {
            if (device.color.equals("Black")) {
                System.out.println(device.name + " - Year: " + device.year + ", Price: $" + device.price + ", Color: " + device.color + ", Type: " + device.type);
            }
        }

        System.out.println("\nDevices of 2021 year:");
        for (Device device : devices) {
            if (device.year.equals(2021)) {
                System.out.println(device.name + " - Year: " + device.year + ", Price: $" + device.price + ", Color: " + device.color + ", Type: " + device.type);
            }
        }

        System.out.println("\nDevices over 1000:");
        double targetPrice = 1000;
        for (Device device : devices) {
            if (device.price > targetPrice) {
                System.out.println(device.name + " - Year: " + device.year + ", Price: $" + device.price + ", Color: " + device.color + ", Type: " + device.type);
            }
        }

        System.out.println("\nLaptops:");
        for (Device device : devices) {
            if (device.type.equals("Laptop")) {
                System.out.println(device.name + " - Year: " + device.year + ", Price: $" + device.price + ", Color: " + device.color + ", Type: " + device.type);
            }
        }
    }
}