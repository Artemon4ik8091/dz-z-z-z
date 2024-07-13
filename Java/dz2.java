import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int year;
    private String publisher;
    private String genre;
    private int pages;

    public Book() {}

    public Book(String title, String author, int year, String publisher, String genre, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.pages = pages;
    }

    public void inputBookData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название книги: ");
        this.title = scanner.nextLine();
        System.out.print("Введите автора: ");
        this.author = scanner.nextLine();
        System.out.print("Введите год выпуска: ");
        this.year = scanner.nextInt();
        scanner.nextLine(); // очистка буфера
        System.out.print("Введите название издательства: ");
        this.publisher = scanner.nextLine();
        System.out.print("Введите жанр книги: ");
        this.genre = scanner.nextLine();
        System.out.print("Введите количество страниц: ");
        this.pages = scanner.nextInt();
    }

    public void displayBookData() {
        System.out.println("Название книги: " + this.title);
        System.out.println("Автор: " + this.author);
        System.out.println("Год выпуска: " + this.year);
        System.out.println("Издательство: " + this.publisher);
        System.out.println("Жанр: " + this.genre);
        System.out.println("Количество страниц: " + this.pages);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.inputBookData();
        book1.displayBookData();
    }
}

public class Car {
    private String name;
    private String manufacturer;
    private int year;
    private double engineSize;
    
    public Car() {
    }
    
    public Car(String name, String manufacturer, int year, double engineSize) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.year = year;
        this.engineSize = engineSize;
    }
    
    public void inputCarData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter manufacturer: ");
        manufacturer = scanner.nextLine();
        System.out.print("Enter year: ");
        year = scanner.nextInt();
        System.out.print("Enter engine size: ");
        engineSize = scanner.nextDouble();
    }
    
    public void displayCarData() {
        System.out.println("Name: " + name);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Year: " + year);
        System.out.println("Engine Size: " + engineSize);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public double getEngineSize() {
        return engineSize;
    }
    
    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
}
