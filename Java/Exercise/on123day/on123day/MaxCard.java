package on123day;

import java.util.BitSet;

public class MaxCard {
    public static void main(String[] args){
        int[] arr={1,2,100,4};
        int res=maxCard(arr);
        System.out.println(res);
       
    }
    public static int getFirst(int[] arr,int left,int right){
        if(left==right) return arr[left];
        return Math.max(arr[left] + getSecond(arr, left+1, right),arr[right]+getSecond(arr, left, right-1));
        
    }
    public static int getSecond(int[] arr,int left,int right){
        if(left==right) return 0;
        return Math.min(getFirst(arr, left+1, right),getFirst(arr, left, right-1));
    }
    public static int maxCard(int[] arr){
        if(arr==null||arr.length==0)return 0;
        return Math.max(getFirst(arr, 0,arr.length-1),getSecond(arr, 0,arr.length-1));
    }
}
