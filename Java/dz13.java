import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FractionService {

    public static void main(String[] args) {
        SpringApplication.run(FractionService.class, args);
    }

    @GetMapping("/checkFraction")
    public String checkFraction(@RequestParam int numerator, @RequestParam int denominator) {
        if (denominator == 0) {
            return "Знаменатель не может быть равен 0";
        }

        if (numerator < 0 && denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;

        if (denominator == 1) {
            return "Дробь является целым числом";
        } else if (Math.abs(numerator) < Math.abs(denominator)) {
            return "Дробь является правильной";
        } else {
            return "Дробь является неправильной";
        }
    }

    @GetMapping("/reduceFraction")
    public String reduceFraction(@RequestParam int numerator, @RequestParam int denominator) {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        if (denominator < 0) {
            gcd *= -1;
        }
        return (numerator / gcd) + "/" + (denominator / gcd);
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction otherFraction) {
        int newNumerator = this.numerator * otherFraction.denominator + otherFraction.numerator * this.denominator;
        int newDenominator = this.denominator * otherFraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);

        Fraction sum = fraction1.add(fraction2);

        System.out.println("Сумма дробей " + fraction1 + " и " + fraction2 + " равна " + sum);
    }
}

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction subtract(Fraction otherFraction) {
        int newNumerator = this.numerator * otherFraction.denominator - otherFraction.numerator * this.denominator;
        int newDenominator = this.denominator * otherFraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(1, 2);

        Fraction difference = fraction1.subtract(fraction2);

        System.out.println("Разность дробей " + fraction1 + " и " + fraction2 + " равна " + difference);
    }
}

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction multiply(Fraction otherFraction) {
        int newNumerator = this.numerator * otherFraction.numerator;
        int newDenominator = this.denominator * otherFraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(1, 2);

        Fraction product = fraction1.multiply(fraction2);

        System.out.println("Произведение дробей " + fraction1 + " и " + fraction2 + " равно " + product);
    }
}

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction divide(Fraction otherFraction) {
        int newNumerator = this.numerator * otherFraction.denominator;
        int newDenominator = this.denominator * otherFraction.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(1, 2);

        Fraction division = fraction1.divide(fraction2);

        System.out.println("Результат деления дроби " + fraction1 + " на дробь " + fraction2 + " равен " + division);
    }
}