import java.util.Comparator;
import java.util.Arrays;
public class Mycompare<T> implements Comparator<element> {
    public int compare(element a,element b){
        return a.getK()-b.getK();
    }
    public static void main(String[] args){
        element[] ele=new element[10];
        for(int i=0;i<10;i++){
            ele[i]=new element(10+i,"哈哈"+i);
        }

        Arrays.sort(ele,new Mycompare<element>());
        for(int i=0;i<ele.length;i++){
            System.out.println(ele[i].k+ele[i].name);
        }
        
    }
}
class element{
    public int k=0;
    public int getK(){
        return k;
    }
    String name;
    public element(int k,String s){
        this.k=k;
        this.name=s;
    }
}
