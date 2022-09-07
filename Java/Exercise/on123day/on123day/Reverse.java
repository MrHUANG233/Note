package on123day;

import java.util.Stack;

public class Reverse {
    public static void main(String[] args){
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        //reverse(stack);
        System.out.println(stack);
    }
    public static int getEnd(Stack<Integer> stack){
        int res=stack.pop();
        if(stack.empty()){
            return res;
        }else{
            int last=getEnd(stack);
            stack.push(res);
            return last;
        }
    }
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int res=getEnd(stack);
        reverse(stack);
        stack.push(res);
    }
}
