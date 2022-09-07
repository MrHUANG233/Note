public class FastSort {
    public static void main(String[] args) {
        int[] a = { 1, 2, 34, 3, 23, 4,57, 6, 7, 5 };
        fastSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void fastSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        sort(arr, 0, arr.length - 1);
        return;
    }

    
    public static void sort(int[] arr, int left, int right) {
        if (right <= left){
            return;
        }
            
        int compare=(int)(Math.random()*(right-left+1)+left);
        int p0 = left - 1;
        for (int i = left; i <= right; i++) {
            if (arr[i] <= arr[compare]) {
                swap(arr, ++p0, i);
            }
        }
        
            sort(arr, left, p0);//迭代中p0可能不会变
            sort(arr, p0 + 1, right);       
        return;
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
