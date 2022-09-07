package on121day;
import java.util.Stack;
public class Reverse {
    public static void main(String[] args){
        
    }
    public static int f(Stack<Integer> stack){
        int result=stack.pop();
        if(stack.empty()){
            return result;
        }else{
            int last=f(stack);
            stack.push(result);
            return last;
        }
    }
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return ;
        }
        int i=f(stack);
        reverse(stack);
        stack.push(i);
    }

}
