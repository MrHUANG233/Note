
public class GuiBing {
    public static  void main(String[] args){
        int[] a={12,34,63,7,4,23,2,7,8,42,3,863,23,87,23,23,47,5};
        mergeSort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void mergeSort(int[] arr){
        if(arr==null||arr.length<2) return;
        process(arr,0,arr.length-1);
        return;
    }
    public static void process(int[] arr,int left,int right){
        if(left==right) return;
        int mid=left+((right-left)>>1);
        process(arr,left,mid);
        process(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    public static void merge(int[] arr,int left,int mid,int right){
        int[] help=new int[right-left+1];
        int p1=left;
        int p2=mid+1;
        int index=0;
        while(p1<=mid&&p2<=right){
            help[index++]=arr[p1]<=arr[p2] ? arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[index++]=arr[p1++];
        }
        while(p2<=right){
            help[index++]=arr[p2++];
        }
        for(int i=0;i<help.length;i++){
            arr[left++]=help[i];
        }

    }
}
