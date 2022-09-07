public class SelectSort {
    public static void swap(int[] array,int a,int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }
    public static void selectSort(int[] array){
        if(array==null||array.length==1)return;
        for(int i=0;i<array.length;i++){
            int min=i;
            
            for(int j=i;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            swap(array,i,min);
        }
    }
    public static void main(String[] args){
        int[] a={1,2,4,8,3,34,8,4,8,1,0,3,24,63};
        selectSort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" "); 
        }
        

    }
}
