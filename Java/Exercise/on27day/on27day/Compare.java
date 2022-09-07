package on27day;
import java.util.*;
public class Compare {
   public static void main(String[] args){
    String[] a={"sad","asa","dfsd","dsfs","asafsdf","7"};
    Arrays.sort(a,(c,d)->d.length()-c.length());
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

   }
}
