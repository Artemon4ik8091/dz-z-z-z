class Human {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Builder extends Human {
    String specialization;

    public Builder(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    public void build() {
        System.out.println(name + " is building something as a " + specialization);
    }
}

class Sailor extends Human {
    String ship;

    public Sailor(String name, int age, String ship) {
        super(name, age);
        this.ship = ship;
    }

    public void sail() {
        System.out.println(name + " is sailing on the " + ship);
    }
}

class Pilot extends Human {
    String aircraft;

    public Pilot(String name, int age, String aircraft) {
        super(name, age);
        this.aircraft = aircraft;
    }

    public void fly() {
        System.out.println(name + " is flying a " + aircraft);
    }
}

public class Main {
    public static void main(String[] args) {
        Builder builder = new Builder("John", 30, "Carpenter");
        builder.build();

        Sailor sailor = new Sailor("Alice", 25, "Fishing boat");
        sailor.sail();

        Pilot pilot = new Pilot("Michael", 35, "Boeing 747");
        pilot.fly();
    }
}