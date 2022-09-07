import java.util.PriorityQueue;
import java.util.Queue;
public class HeapSortTest {
    public static void main(String[] args){
        int[] heap={12,34,567,23,6,32,73,32,7,78,8,43,34,9,89,8945,3};
        int[] c=new int[heap.length];
        heapSort(heap);
        Queue<Integer> b=new PriorityQueue<>((m,n)->n.intValue()-m.intValue());
        for(int i=0;i<c.length;i++){
            b.add(heap[i]);            
        }
        for(int i=0;i<c.length;i++){
            c[i]=b.poll();           
        }

        for(int i=0;i<heap.length;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.print("\n");
        for(int i:c){
            System.out.print(i+" ");
        }
    }
    public static void heapSort(int[] heap){
        int heapSize=heap.length;
        for(int i=0;i<heap.length;i++){
            heapInsert(heap,i);
        }
        for(int i=0;i<heap.length;i++){
            swap(heap, 0, --heapSize);
            heapify(heap,0,heapSize);
        }
    }
    public static void heapify(int[] heap,int index,int heapSize){
        int left=index*2+1;
        while(left<heapSize){
            int max=left+1<heapSize&&heap[left+1]>heap[left]?left+1:left;
            if(heap[max]>heap[index]){
                swap(heap,max,index);
                index=max;
                left=index*2+1;
            }else{
                return;
            }

        }
    }
    public static void heapInsert(int[] heap,int index){
        if(heap==null) return ;
        while(index>0){
            int parent=(index-1)>>1;
            if(heap[parent]<heap[index]){
                swap(heap,parent,index);
                index=parent;
            }else{
                return;
            }
        }
    }
    public static void swap(int[] arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}

