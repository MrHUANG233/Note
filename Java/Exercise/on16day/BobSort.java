
public class BobSort {
    public static void main(String[] args) {
        int[] a = { 83, 34, 2, 6, 8, 5, 9, 5, 34, 8, 4, 3, 75, 332, 75, 64, 2 };
        bobSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void bobSort(int[] array) {
        if (array == null || array.length == 1)
            return;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }

    }
}
