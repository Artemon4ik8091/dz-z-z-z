class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Животное издает звук");
    }
}

class Tiger extends Animal {
    private int stripesCount;

    public Tiger(String name, int stripesCount) {
        super(name);
        this.stripesCount = stripesCount;
    }

    public int getStripesCount() {
        return stripesCount;
    }

    public void setStripesCount(int stripesCount) {
        this.stripesCount = stripesCount;
    }

    @Override
    public void makeSound() {
        System.out.println("Тигр рычит");
    }
}

class Crocodile extends Animal {
    private boolean isDangerous;

    public Crocodile(String name, boolean isDangerous) {
        super(name);
        this.isDangerous = isDangerous;
    }

    public boolean isDangerous() {
        return isDangerous;
    }

    public void setDangerous(boolean dangerous) {
        isDangerous = dangerous;
    }

    @Override
    public void makeSound() {
        System.out.println("Крокодил шипит");
    }
}

class Kangaroo extends Animal {
    private double jumpHeight;

    public Kangaroo(String name, double jumpHeight) {
        super(name);
        this.jumpHeight = jumpHeight;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(double jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void makeSound() {
        System.out.println("Кенгуру шумит");
    }
}

public class Main {
    public static void main(String[] args) {
        Tiger tiger = new Tiger("Шерхан", 4);
        Crocodile crocodile = new Crocodile("Крокодил Гена", true);
        Kangaroo kangaroo = new Kangaroo("Кенгуру", 2.5);

        tiger.makeSound();
        crocodile.makeSound();
        kangaroo.makeSound();
    }
}
