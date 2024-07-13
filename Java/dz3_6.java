interface IMath {
    int Max();
    int Min();
    float Avg();
}

class Array implements IMath {
    private int[] arr;

    public Array(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int Max() {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    @Override
    public int Min() {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    @Override
    public float Avg() {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (float) sum / arr.length;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 9};
        Array array = new Array(numbers);

        System.out.println("Max: " + array.Max());
        System.out.println("Min: " + array.Min());
        System.out.println("Average: " + array.Avg());
    }
}
