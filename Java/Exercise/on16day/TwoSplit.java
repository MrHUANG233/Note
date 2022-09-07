import java.util.Arrays;
public class TwoSplit {
    public static void main(String[] args){
        int[] a={1,2,2,4,5,8,11,12,17,21,23,34};
        Arrays.sort(a);
        System.out.println(twoSplit(a,23));
        System.out.println(rightSplit(a,0,a.length-1,3));
    }
    public static int twoSplit(int[] array,int a){
        int index=0;
        index=split(array,0,array.length,a);

        return index;
    }
    public static int split(int[] array,int left,int right,int a){
        int mid=left+((right-left)>>1);
        if(a==array[mid]){
            return mid;
        }else if(a>array[mid]){
            return split(array,mid,right,a); 
        }else{
            return split(array,left,mid,a);
        }
            
        
        
    }
    public static int rightSplit(int[] array,int left,int right,int a){
        if(left>=right) return right;
        int mid=left+((right-left)>>1);
        if(array[mid]>=a){
            return rightSplit(array,left+1,mid,a);
        }else{
            return rightSplit(array,mid+1,right,a);
        }
    }
}
