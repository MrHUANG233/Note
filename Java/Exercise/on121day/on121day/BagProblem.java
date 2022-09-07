package on121day;

public class BagProblem {
    public static void main(String[] args){
        int[] weights={1,4,1,7,3,7,3,12,5,8,4};
        int[] values= {1,3,5,2,3,5,2,4,8,4,4};
        System.out.println(process1(weights, values,0,0,2));
        

    }
    public static int process1(int[] weights,int[] values,int i,int alreadyweight,int bag){
        if(i==weights.length) return 0;

        int add=values[i]+process1(weights, values, i+1,alreadyweight+weights[i],bag);
        int non=process1(weights,values,i+1,alreadyweight,bag);
        if(alreadyweight+weights[i]>bag||non>add) return non;
        return add;
        
    }
}
