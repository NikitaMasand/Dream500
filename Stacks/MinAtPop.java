/*
You are given an array A of size N.
You need to push the elements of the array into a stack and then print minimum in the stack at each pop.
*/

package Stacks;

import java.util.Stack;

public class MinAtPop {
    public static Stack<Integer> _push(int[] arr, int n){
        Stack<Integer>stack=new Stack<>();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min,arr[i]);
            stack.push(min);
        }
        return stack;
    }
    public static void _getMinAtPop(Stack<Integer>s){
       while (!s.isEmpty())
           System.out.print(s.pop()+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1,6,43,1,2,0,5};
        Stack<Integer> stack =_push(arr,arr.length);
        _getMinAtPop(stack);
    }
}

//output: 0 0 1 1 1 1 1 
