import java.util.Scanner;
import java.util.Arrays;

public class 1th {
    System.out.println("\"Your time is limited,\n so don\'t waste it\n living someone else\'s life\"\n Steve Jobs");
}

public class 2th {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double number = input.nextDouble();

        System.out.print("Введите второе число (процент): ");
        double percent = input.nextDouble();

        double result = (percent / 100) * number;

        System.out.println("Результат: " + result);

        input.close();
    }
}


public class 3th {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод трех цифр с клавиатуры
        System.out.println("Введите первую цифру:");
        int digit1 = scanner.nextInt();

        System.out.println("Введите вторую цифру:");
        int digit2 = scanner.nextInt();

        System.out.println("Введите третью цифру:");
        int digit3 = scanner.nextInt();

        // Создание числа из введенных цифр
        int number = digit1 * 100 + digit2 * 10 + digit3;

        System.out.println("Число, сформированное из ваших цифр: " + number);
    }
}

public class 4th {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите шестизначное число: ");
        int number = input.nextInt();

        if (String.valueOf(number).length() != 6) {
            System.out.println("Ошибка: Введите шестизначное число.");
        } else {
            int digit1 = (number / 100000) % 10;
            int digit2 = (number / 10000) % 10;
            int digit3 = (number / 1000) % 10;
            int digit4 = (number / 100) % 10;
            int digit5 = (number / 10) % 10;
            int digit6 = number % 10;

            int rearrangedNumber = digit6 * 100000 + digit5 * 10000 + digit4 * 1000 + digit3 * 100 + digit2 * 10 + digit1;

            System.out.println("Исходное число: " + number);
            System.out.println("Результат: " + rearrangedNumber);
        }

        input.close();
    }
}

public class 5th {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер месяца (от 1 до 12): ");
        int month = scanner.nextInt();

        if (month >= 1 && month <= 12) {
            switch (month) {
                case 1:
                case 2:
                case 12:
                    System.out.println("Winter");
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.println("Spring");
                    break;
                case 6:
                case 7:
                case 8:
                    System.out.println("Summer");
                    break;
                case 9:
                case 10:
                case 11:
                    System.out.println("Autumn");
                    break;
                default:
                    System.out.println("Ошибка: введен некорректный номер месяца.");
            }
        } else {
            System.out.println("Ошибка: введен некорректный номер месяца.");
        }
    }
}

public class 6th {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите количество метров: ");
        double meters = scanner.nextDouble();
        
        System.out.println("Выберите единицу измерения для перевода:");
        System.out.println("1. Мили");
        System.out.println("2. Дюймы");
        System.out.println("3. Ярды");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                double miles = meters * 0.000621371;
                System.out.println(meters + " метров = " + miles + " миль");
                break;
            case 2:
                double inches = meters * 39.3701;
                System.out.println(meters + " метров = " + inches + " дюймов");
                break;
            case 3:
                double yards = meters * 1.09361;
                System.out.println(meters + " метров = " + yards + " ярдов");
                break;
            default:
                System.out.println("Ошибка: некорректный выбор единицы измерения.");
        }
    }
}

public class 7th {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите два числа:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        // Нормализация границ диапазона
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
            System.out.println("Границы диапазона были нормализованы.");
        }

        System.out.println("Нечетные числа в диапазоне от " + num1 + " до " + num2 + ":");

        for (int i = num1; i <= num2; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}

public class 8th {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начальное значение диапазона: ");
        int start = scanner.nextInt();

        System.out.print("Введите конечное значение диапазона: ");
        int end = scanner.nextInt();

        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
            System.out.println();
        }

        scanner.close();
    }
}

public class 9th {
    public static void main(String[] args) {
        int[] array = new int[20]; // Массив из 20 элементов
        Random random = new Random();

        // Заполнение массива случайными числами
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(201) - 100; // Генерация чисел от -100 до 100
        }

        int min = array[0];
        int max = array[0];
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        // Поиск минимального и максимального элементов, подсчёт отрицательных, положительных и нулей
        for (int num : array) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            } else {
                zeroCount++;
            }
        }

        // Вывод результатов на экран
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Количество отрицательных элементов: " + negativeCount);
        System.out.println("Количество положительных элементов: " + positiveCount);
        System.out.println("Количество нулей: " + zeroCount);
    }
}

public class 12th {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов в массиве: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Введите элементы массива:");

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Выберите направление сортировки (1 - по возрастанию, 2 - по убыванию): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            Arrays.sort(array);
        } else if (choice == 2) {
            Arrays.sort(array);
            for (int i = 0; i < n / 2; i++) {
                int temp = array[i];
                array[i] = array[n - i - 1];
                array[n - i - 1] = temp;
            }
        } else {
            System.out.println("Некорректный выбор направления сортировки.");
        }

        System.out.println("Отсортированный массив: " + Arrays.toString(array));

        scanner.close();
    }
}
