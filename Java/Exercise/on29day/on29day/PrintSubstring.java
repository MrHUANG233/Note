package on29day;
import java.util.*;

public class PrintSubstring {
    public static void main(String[] args){
        printSubstring("abcd");
    }
    public static void printSubstring(String str){
        char[] chs=str.toCharArray();
        process(chs, 0);
    }
    public static void process(char[] chs,int i){
        if(i==chs.length){
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs,i+1);
        char temp=chs[i];
        chs[i]=0;
        process(chs, i+1);
        chs[i]=temp;
    }

}
