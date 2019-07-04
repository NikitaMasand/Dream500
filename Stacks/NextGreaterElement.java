package Stacks;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public static void printNextGreaterElement(long[] arr, int n){
        Stack <Long> stack = new Stack<>();
        HashMap<Long,Long> map = new HashMap<>();
        stack.push(arr[0]);
        for(int i=1;i<n;i++){
            while (!stack.isEmpty() && stack.peek()<arr[i]){
                map.put(stack.peek(),arr[i]);
                stack.pop();
            }
            stack.push(arr[i]);
        }
        for(int i=0;i<n-1;i++){
            long x = map.getOrDefault(arr[i],(long)-1);
            System.out.print(x+" ");
        }
        System.out.print("-1");
    }
    public static void main(String[] args) {
        long arr[] = {6,8,0,1,3};
        printNextGreaterElement(arr,arr.length);
    }
}
