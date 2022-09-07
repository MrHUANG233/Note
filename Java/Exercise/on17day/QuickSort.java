public class QuickSort {
    public static void main(String[] args) {
        int[] a = {  2, 2, 2, 2, 2, 34, 3, 23, 23, 4, 57, 6, 2, 2, 2, 7, 7, 5 };
        quickSort(a, 0, a.length);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2)
            return;
        if (right > left) {
            int[] p = partition2(arr, left, right,arr[right-1]);
            quickSort(arr, left, p[0] + 1);
            quickSort(arr, p[1], right);
            return;
        }

    }

    public static int[] partition(int[] arr, int left, int right) {
        int p0 = left - 1;
        int p1 = right;
        int compare = arr[right - 1];
        int index = left;
        while (index < p1) {
            if (arr[index] < compare) {
                swap(arr, ++p0, index++);
            } else if (arr[index] > compare) {
                swap(arr, index, --p1);
            } else {
                index++;
            }
        }
        int[] res = new int[2];
        res[0] = p0;
        res[1] = p1;
        return res;

    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static int[] partition2(int[] arr,int left,int right ,int s ){
        int p0=left-1;
        int p1=right;
        int mid=left;
        while(mid<p1){
            if(arr[mid]<s){
                swap(arr,++p0,mid);
                mid++;
            }else if(arr[mid]>s){
                swap(arr,mid,--p1);
            }else{
                mid++;
            }
        }
        int[] res=new int[2];
        res[0]=p0;
        res[1]=p1;
        return res;
    }
}
