import java.util.ArrayList;
import java.util.List;

class Projector {
    private String name;
    private int year;
    private double price;
    private String manufacturer;

    public Projector(String name, int year, double price, String manufacturer) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public static void showAllProjectors(List<Projector> projectors) {
        for (Projector projector : projectors) {
            System.out.println("Name: " + projector.getName() + ", Year: " + projector.getYear() + ", Price: $" + projector.getPrice() + ", Manufacturer: " + projector.getManufacturer());
        }
    }

    public static void showProjectorsByManufacturer(List<Projector> projectors, String manufacturer) {
        for (Projector projector : projectors) {
            if (projector.getManufacturer().equals(manufacturer)) {
                System.out.println("Name: " + projector.getName() + ", Year: " + projector.getYear() + ", Price: $" + projector.getPrice() + ", Manufacturer: " + projector.getManufacturer());
            }
        }
    }

    public static void showProjectorsByYear(List<Projector> projectors, int year) {
        for (Projector projector : projectors) {
            if (projector.getYear() == year) {
                System.out.println("Name: " + projector.getName() + ", Year: " + projector.getYear() + ", Price: $" + projector.getPrice() + ", Manufacturer: " + projector.getManufacturer());
            }
        }
    }

    public static void showProjectorsAbovePrice(List<Projector> projectors, double price) {
        for (Projector projector : projectors) {
            if (projector.getPrice() > price) {
                System.out.println("Name: " + projector.getName() + ", Year: " + projector.getYear() + ", Price: $" + projector.getPrice() + ", Manufacturer: " + projector.getManufacturer());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Projector> projectors = new ArrayList<>();
        projectors.add(new Projector("Projector1", 2021, 500.0, "Manufacturer1"));
        projectors.add(new Projector("Projector2", 2022, 700.0, "Manufacturer2"));
        projectors.add(new Projector("Projector3", 2021, 800.0, "Manufacturer1"));

        Projector.showAllProjectors(projectors);

        Projector.showProjectorsByManufacturer(projectors, "Manufacturer1");

        Projector.showProjectorsByYear(projectors, 2021);

        Projector.showProjectorsAbovePrice(projectors, 600.0);
    }
}
