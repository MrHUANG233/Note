public class TongSort {
    public static void main(String[] args){
        int[] a={12,24,35,4,34,56,3,4,2,4,44,6,6,5,5345,2,4,4};
        tongSort(a);
        for(int i:a){
            System.out.print(i+" ");
        }
    }
    public static void tongSort(int[] arr){
        int[] help=new int[arr.length];
        int[] tong=new int[10];
        int maxBit=0;
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            max=max>i?max:i;
        }
        while(max>0){
            max/=10;
            maxBit++;
        }
        for(int i=0;i<maxBit;i++){
            for(int j=0;j<arr.length;j++){
                tong[getDigit(arr[j],i)]+=1;
            }
            for(int k=1;k<tong.length;k++){
                tong[k]+=tong[k-1];
            }
            for(int l=0;l<arr.length;l++){
                int tem=getDigit(arr[arr.length-1-l],i);
                help[tong[tem]-1]=arr[arr.length-1-l];
                tong[tem]--;
            }
            for(int j=0;j<arr.length;j++){
                arr[j]=help[j];
            }


        }

    }

    public static int getDigit(int ele,int bit){

        return (int)(ele/Math.pow(10,bit))%10 ;
    }
}
