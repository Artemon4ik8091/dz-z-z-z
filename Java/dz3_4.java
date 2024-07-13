class Device {
    String name;
    
    public Device(String name) {
        this.name = name;
    }
    
    public void sound() {
        System.out.println("Device sound: Beep Beep");
    }
    
    public void show() {
        System.out.println("Device name: " + name);
    }
    
    public void desc() {
        System.out.println("Device description: This is a generic device");
    }
}

class Kettle extends Device {
    public Kettle(String name) {
        super(name);
    }
    
    @Override
    public void sound() {
        System.out.println("Kettle sound: Boiling water");
    }
    
    @Override
    public void desc() {
        System.out.println("Device description: This is a kettle used for boiling water");
    }
}

class Microwave extends Device {
    public Microwave(String name) {
        super(name);
    }
    
    @Override
    public void sound() {
        System.out.println("Microwave sound: Humming");
    }
    
    @Override
    public void desc() {
        System.out.println("Device description: This is a microwave used for heating food");
    }
}

class Car extends Device {
    public Car(String name) {
        super(name);
    }
    
    @Override
    public void sound() {
        System.out.println("Car sound: Engine revving");
    }
    
    @Override
    public void desc() {
        System.out.println("Device description: This is a car used for transportation");
    }
}

class Ship extends Device {
    public Ship(String name) {
        super(name);
    }
    
    @Override
    public void sound() {
        System.out.println("Ship sound: Horn blowing");
    }
    
    @Override
    public void desc() {
        System.out.println("Device description: This is a ship used for sailing");
    }
}

public class Main {
    public static void main(String[] args) {
        Kettle kettle = new Kettle("Electric Kettle");
        kettle.show();
        kettle.sound();
        kettle.desc();
        
        Microwave microwave = new Microwave("Countertop Microwave");
        microwave.show();
        microwave.sound();
        microwave.desc();
        
        Car car = new Car("Sedan Car");
        car.show();
        car.sound();
        car.desc();
        
        Ship ship = new Ship("Cruise Ship");
        ship.show();
        ship.sound();
        ship.desc();
    }
}