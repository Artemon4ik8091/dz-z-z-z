import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 1th {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к первому файлу:");
        String filePath1 = scanner.nextLine();

        System.out.println("Введите путь ко второму файлу:");
        String filePath2 = scanner.nextLine();

        List<String> lines1 = readFile(filePath1);
        List<String> lines2 = readFile(filePath2);

        if (lines1.size() != lines2.size()) {
            System.out.println("Файлы имеют разную длину");
            return;
        }

        boolean mismatchFound = false;
        for (int i = 0; i < lines1.size(); i++) {
            if (!lines1.get(i).equals(lines2.get(i))) {
                System.out.println("Несовпадающая строка из первого файла: " + lines1.get(i));
                System.out.println("Несовпадающая строка из второго файла: " + lines2.get(i));
                mismatchFound = true;
            }
        }

        if (!mismatchFound) {
            System.out.println("Все строки в файлах совпадают.");
        }
    }

    private static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return lines;
    }
}

public class 2th {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            String longestLine = "";
            int maxLength = 0;

            while ((line = reader.readLine()) != null) {
                if (line.length() > maxLength) {
                    maxLength = line.length();
                    longestLine = line;
                }
            }

            reader.close();

            System.out.println("Самая длинная строка имеет длину: " + maxLength);
            System.out.println("Это строка: " + longestLine);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}

public class 3th {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String filename = scanner.nextLine();
        ArrayList<int[]> arrays = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int[] array = Arrays.stream(line.trim().split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
                arrays.add(array);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        int totalMax = Integer.MIN_VALUE;
        int totalMin = Integer.MAX_VALUE;
        int totalSum = 0;

        for (int[] array : arrays) {
            int max = Arrays.stream(array).max().getAsInt();
            int min = Arrays.stream(array).min().getAsInt();
            int sum = Arrays.stream(array).sum();

            totalMax = Math.max(totalMax, max);
            totalMin = Math.min(totalMin, min);
            totalSum += sum;

            System.out.println("Массив: " + Arrays.toString(array));
            System.out.println("Максимум: " + max);
            System.out.println("Минимум: " + min);
            System.out.println("Сумма элементов: " + sum);
            System.out.println();
        }

        System.out.println("Максимум среди всех массивов: " + totalMax);
        System.out.println("Минимум среди всех массивов: " + totalMin);
        System.out.println("Общая сумма всех массивов: " + totalSum);
    }
}

public class 4th {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        System.out.print("Введите целые числа через пробел: ");
        String[] nums = scanner.nextLine().split(" ");
        int[] array = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            array[i] = Integer.parseInt(nums[i]);
        }

        try {
            FileWriter writer = new FileWriter(filePath);

            for (int num : array) {
                writer.write(num + " ");
            }
            writer.write("\n");

            for (int num : array) {
                if (num % 2 == 0) {
                    writer.write(num + " ");
                }
            }
            writer.write("\n");

            for (int num : array) {
                if (num % 2 != 0) {
                    writer.write(num + " ");
                }
            }
            writer.write("\n");

            for (int i = array.length - 1; i >= 0; i--) {
                writer.write(array[i] + " ");
            }

            writer.close();
            System.out.println("Данные успешно записаны в файл.");

        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл: " + e.getMessage());
        }
    }
}

import java.io.*;
import java.util.*;

class Employee {                //к классу 5th
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class 5th {
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        // Чтение списка сотрудников из файла при старте программы

        // Далее можно начать цикл взаимодействия с пользователем, где реализовать необходимые функции:
        // - Ввод данных о сотруднике
        // - Редактирование данных сотрудника
        // - Удаление сотрудника
        // - Поиск сотрудника по фамилии
        // - Вывод информации о сотрудниках определенного возраста или с фамилией, начинающейся на указанную букву

        // Пример сохранения списка сотрудников в файл при выходе из программы
        saveEmployeesToFile();
    }

    private static void saveEmployeesToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            outputStream.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadEmployeesFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            employees = (List<Employee>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
