import java.util.*;
public class StackTest {
    public static void main(String[] args){
        Stack<String> stack=new Stack<>();
        stack.push(new String("hhhh"));
        stack.push("Integer.valueof(10)");
        stack.push("10");
        stack.push("10.0f");
        stack.push("10000");
        stack.push("1000.0101f");
        stack.push(new StackTest().toString());
        while(!stack.empty()){
            System.out.println(stack.pop().toString());
        }
    }

}
