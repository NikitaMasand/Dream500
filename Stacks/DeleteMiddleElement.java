//Given a stack with push(), pop(), empty() operations, delete middle of it without using any additional data structure.
package Stacks;
import java.util.Stack;
public class DeleteMiddle {
    public static Stack<Integer> deleteMid(Stack<Integer>s,int stackSize, int current){
        if(current==stackSize){
            return s;
        }
        if(current==stackSize/2){
            s.pop();
            return s;
        }
        int x = s.peek();
        s.pop();
        current+=1;
        s = deleteMid(s,stackSize,current);
        s.push(x);

        return s;
    }

    public static void main(String[] args) {
        Stack<Integer> stack= new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
       stack = deleteMid(stack,stack.size(),0);
       while (!stack.isEmpty()){
           System.out.println(stack.pop());
       }
    }
}
/*
output:
4
3
1
*/
