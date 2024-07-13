import java.util.Random;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class 1th {

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        Thread fillArrayThread = new Thread(() -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(100);
            }
            System.out.println("Массив заполнен");
        });

        Thread sumThread = new Thread(() -> {
            try {
                fillArrayThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int sum = 0;
            for (int num : array) {
                sum += num;
            }
            System.out.println("Сумма элементов массива: " + sum);
        });

        Thread averageThread = new Thread(() -> {
            try {
                fillArrayThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int sum = 0;
            for (int num : array) {
                sum += num;
            }
            double average = (double) sum / array.length;
            System.out.println("Среднее арифметическое значение в массиве: " + average);
        });

        fillArrayThread.start();
        sumThread.start();
        averageThread.start();

        try {
            sumThread.join();
            averageThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}



public class 2th {
    static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите путь к файлу:");
            String filePath = reader.readLine();

            Thread generatorThread = new Thread(new NumberGenerator(filePath));
            generatorThread.start();

            Thread primeFinderThread = new Thread(new PrimeFinder());
            Thread factorialThread = new Thread(new FactorialCalculator());

            generatorThread.join();

            primeFinderThread.start();
            factorialThread.start();

            primeFinderThread.join();
            factorialThread.join();

            // Дополнительные действия для вывода статистики
            System.out.println("Статистика выполненных операций:");
            // Добавьте здесь код для вывода статистики
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    static class NumberGenerator implements Runnable {
        private String filePath;

        public NumberGenerator(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void run() {
            try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
                Random random = new Random();
                for (int i = 0; i < 100; i++) {
                    int num = random.nextInt(100) + 1;
                    writer.println(num);
                    numbers.add(num);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class PrimeFinder implements Runnable {
        @Override
        public void run() {
    
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] numbers = line.split(" ");
                    for (String number : numbers) {
                        if (isPrime(Integer.parseInt(number))) {
                            System.out.println(number + " is a prime number.");
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        public static boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    static class FactorialCalculator implements Runnable {
        @Override
        public void run() {
    
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] numbers = line.split(" ");
                    for (String number : numbers) {
                        int n = Integer.parseInt(number);
                        long factorial = findFactorial(n);
                        System.out.println("Factorial of " + n + " is: " + factorial);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        public static long findFactorial(int n) {
            if (n == 0) {
                return 1;
            }
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }
}

public class 3th {

    static int filesCopied = 0;
    static int directoriesCopied = 0;

    public static void main(String[] args) {
        try {
            String sourceDirectory = "/path/to/source/directory";
            String targetDirectory = "/path/to/target/directory";

            copyDirectory(new File(sourceDirectory), new File(targetDirectory));

            System.out.println("Copying completed.");
            System.out.println("Total files copied: " + filesCopied);
            System.out.println("Total directories copied: " + directoriesCopied);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyDirectory(File source, File target) throws IOException {
        if (source.isDirectory()) {
            if (!target.exists()) {
                target.mkdir();
                directoriesCopied++;
            }

            String[] children = source.list();
            for (String child : children) {
                copyDirectory(new File(source, child), new File(target, child));
            }
        } else {
            Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
            filesCopied++;
        }
    }
}

public class 4th {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к директории:");
        String directoryPath = scanner.nextLine();
        System.out.println("Введите слово для поиска:");
        String searchWord = scanner.nextLine();

        List<String> foundFilesContent = new ArrayList<>();

        Thread searchThread = new Thread(() -> {
            // Поиск файлов с искомым словом
            // и добавление их содержимого в список
        });

        Thread processThread = new Thread(() -> {
            try {
                searchThread.join(); // Ожидание завершения поиска

                // Обработка найденных файлов
                // Вырезание запрещенных слов
                // и запись в один файл
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        searchThread.start();
        processThread.start();

        try {
            searchThread.join();
            processThread.join();

            // Отображение статистики выполненных операций
            System.out.println("Операции выполнены успешно");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}