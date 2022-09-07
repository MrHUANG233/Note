public class EorSelect {
    public static void main(String[] args){
        int[] array1={1,2,4,6,8,9,4,6,3,6,3,23,1,2,6,8,9};
        int[] array2={1,2,4,6,8,9,4,6,3,6,3,23,1,2,6,8,9,34};
        int a=eor(array1);
        int[] b=eor2(array2);
        System.out.println(a);
        System.out.println(b[0]+" "+b[1]);


    }
    public static  int eor(int[] array){
        int res=0;
        for(int i=0;i<array.length;i++){
            res^=array[i];
        }
        return res;
    }

    public static int[] eor2(int[] array){
        int[] res=new int[2];
        int eor=eor(array);
        int eor0=0;
        int select=0;
        select=eor&(~eor+1);
        for(int i=0;i<array.length;i++){
            if((array[i]&select)!=0){
                eor0^=array[i];
            }
        }
        res[0]=eor0;
        res[1]=eor0^eor;
        return res;
        
    }
}
