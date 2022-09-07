
public class HeapSort{
    public static void main(String[] args){
        int[] a={ 326, 12, 34, 6, 36, 22, 3443, 2, 12, 53, 12,24,3,5,12,1,5,4,6,3,54,23,34,3,2,4,23,6,2,32,12,4,3,5,3,5,21, 212 };
        heapSort(a);

        for(int i:a){
            System.out.print(i+" ");
        }

    }
    public static void heapSort(int[] arr){
        if(arr==null||arr.length<2) return;
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }

        int heapsize=arr.length;
        for(int i=0;i<arr.length;i++){
            swap(arr,0,heapsize-i-1);
            heapify(arr,heapsize-i-1,0);
        }
    }
    public static void heapify(int[] arr,int heapsize,int index){
        int left=2*index+1;
        if(left<heapsize){
            int largest=left+1<heapsize&&arr[left+1]>arr[left]?left+1:left;
            if(arr[index]<arr[largest]){
                swap(arr,index,largest);
                heapify(arr,heapsize,largest);
            }
        }
        return;
    }
    public static void heapInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]){
                swap(arr,index,(index-1)/2);
                index=((index-1)/2);       
        }

    }
    public static void swap(int[] arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
    
}