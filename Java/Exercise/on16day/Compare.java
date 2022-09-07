
public class Compare {
    public static void main(String[] args){
        int[] a=compareArray(100,100);
        for(int i:a){
            System.out.print(i+" ");
        }
    }
    public static int[] compareArray(int maxLength,int maxValue){
        int length=(int)(Math.random()*(maxLength))+1;
        int[] res=new int[length];
        for(int i=0;i<res.length;i++){
            res[i]=(int)(Math.random()*(maxValue+1));
        }
        return res;
    }
}
