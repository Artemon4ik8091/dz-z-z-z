class MusicalInstrument {
    protected String name;

    public MusicalInstrument(String name) {
        this.name = name;
    }

    public void sound() {
        System.out.println("Этот инструмент издает звук.");
    }

    public void show() {
        System.out.println("Название инструмента: " + this.name);
    }

    public void desc() {
        System.out.println("Описание инструмента: ");
    }

    public void history() {
        System.out.println("История создания инструмента.");
    }
}

class Violin extends MusicalInstrument {
    public Violin(String name) {
        super(name);
    }

    @Override
    public void desc() {
        super.desc();
        System.out.println("Это скрипка.");
    }
}

class Trombone extends MusicalInstrument {
    public Trombone(String name) {
        super(name);
    }

    @Override
    public void desc() {
        super.desc();
        System.out.println("Это тромбон.");
    }
}

class Ukulele extends MusicalInstrument {
    public Ukulele(String name) {
        super(name);
    }

    @Override
    public void desc() {
        super.desc();
        System.out.println("Это укулеле.");
    }
}

class Cello extends MusicalInstrument {
    public Cello(String name) {
        super(name);
    }

    @Override
    public void desc() {
        super.desc();
        System.out.println("Это виолончель.");
    }
}

public class Main {
    public static void main(String[] args) {
        Violin violin = new Violin("Скрипка Страдивари");
        violin.show();
        violin.desc();
        violin.sound();
        violin.history();

        Trombone trombone = new Trombone("Тромбон Yamaha");
        trombone.show();
        trombone.desc();
        trombone.sound();
        trombone.history();

        Ukulele ukulele = new Ukulele("Укулеле Kala");
        ukulele.show();
        ukulele.desc();
        ukulele.sound();
        ukulele.history();

        Cello cello = new Cello("Виолончель Stradivarius");
        cello.show();
        cello.desc();
        cello.sound();
        cello.history();
    }
}