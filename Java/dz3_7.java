import java.util.Arrays;

interface ISort {
    void SortAsc();
    void SortDesc();
}

class Array implements ISort {
    private int[] arr;

    public Array(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void SortAsc() {
        Arrays.sort(arr);
    }

    @Override
    public void SortDesc() {
        Arrays.sort(arr);
        int temp;
        for(int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public void printArray() {
        System.out.println(Arrays.toString(arr));
    }
}

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5};
        Array array = new Array(numbers);

        System.out.println("Original Array:");
        array.printArray();

        array.SortAsc();
        System.out.println("Sorted in ascending order:");
        array.printArray();

        array.SortDesc();
        System.out.println("Sorted in descending order:");
        array.printArray();
    }
}
