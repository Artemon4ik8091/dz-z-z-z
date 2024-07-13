class Money {
    private int dollars;
    private int cents;

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public void displayAmount() {
        System.out.println("Amount: $" + dollars + "." + cents);
    }

    public void setAmount(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }
}

class Product extends Money {
    public Product(int dollars, int cents) {
        super(dollars, cents);
    }

    public void reducePrice(int amount) {
        int totalCents = this.dollars * 100 + this.cents;
        totalCents -= amount;
        this.dollars = totalCents / 100;
        this.cents = totalCents % 100;
    }
}

public class Main {
    public static void main(String[] args) {
        Money money = new Money(50, 75);
        money.displayAmount();
        money.setAmount(60, 40);
        money.displayAmount();
        
        Product product = new Product(100, 50);
        product.displayAmount();
        product.reducePrice(30);
        product.displayAmount();
    }
}
