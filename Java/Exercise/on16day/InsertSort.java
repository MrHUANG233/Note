public class InsertSort {
    public static void main(String[] args){
        int[] a={12,4,53,5,23,66,355,76,32,3,1,54,7,53,23,5};
        insertSort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }        
    }
    public static void insertSort(int[] array){
        if(array==null||array.length==1)return ;
        for(int i=0;i<array.length;i++){
            int j=i;
            for(j=i;j-1>=0&&array[j]<array[j-1];j--){
                swap(array,j,j-1);
                
            }
        }
    }
    public static void swap(int[] array,int a,int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
