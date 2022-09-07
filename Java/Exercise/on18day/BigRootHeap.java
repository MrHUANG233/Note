import java.util.PriorityQueue;
public class BigRootHeap {
    public static void main(String[] args) {
        int[] a = { 326, 12, 34, 6, 36, 22, 3443, 2, 12, 53, 1, 212 };
        
        PriorityQueue<Goods> heap=new PriorityQueue<>((c,b)->b.price-c.price);
        for(int i=0;i<a.length;i++){
            heap.add(new Goods(a[i],"货物"+i));
        }
        for(int i=0;i<a.length;i++){
            Goods temp=heap.poll();
            System.out.print(temp.price+temp.name+" ");
        }
        //heapSort(a);
        
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int heapsize = arr.length;
        swap(arr, 0, --heapsize);
        while (heapsize > 0) {
            heapify(arr, 0, heapsize);
            swap(arr, 0, --heapsize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void heapify(int[] arr, int index, int heapsize) {
        int left = index * 2 + 1;
        while (left < heapsize) {
            int largest = left + 1 < heapsize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = left * 2 + 1;
        }
    }
}
class Goods{
    public int price=0;
    public String name=null;
    public Goods(int price,String name){
        this.price=price;
        this.name=name;
    }
}

