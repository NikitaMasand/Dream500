package Stacks;

import java.util.Stack;

public class MaxOfMinInWindows {

    static void printMaxOfMin(int[] arr, int n) {
        int[] left = previousSmallerElementIndex(arr,n);
        int[] right = nextSmallerElementIndex(arr,n);
        int[] ans = new int[n+1];
        for(int i=0;i<n;i++){
            int len = right[i]-left[i]-1;

            ans[len]=Math.max(arr[i],ans[len]);
        }

        for(int i=n-1;i>=0;i--){
            ans[i]=Math.max(ans[i],ans[i+1]);
        }

        for(int i=1;i<=n;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }

    static int[] nextSmallerElementIndex(int[] arr, int n){
        Stack<Integer> stack = new Stack<>();
        int rightMinIndex[] = new int[n];
        stack.push(0);
        for(int i=1;i<n;i++){
            while (!stack.isEmpty()&&arr[i]<arr[stack.peek()]){
                rightMinIndex[stack.peek()]=i;
                stack.pop();

            }
            stack.push(i);

        }
        while (!stack.isEmpty()){
            rightMinIndex[stack.pop()]=n;
        }
        return rightMinIndex;

    }

    static int[] previousSmallerElementIndex(int[] arr, int n){
            Stack<Integer>stack=new Stack<>();
            int leftMinIndex[] = new int[n];
            stack.push(n-1);
            for(int i=n-2;i>=0;i--){
                while (!stack.isEmpty()&&arr[i]<arr[stack.peek()]){
                    leftMinIndex[stack.peek()]=i;
                    stack.pop();

                }
                stack.push(i);
            }
            while (!stack.isEmpty()){
                leftMinIndex[stack.pop()]=-1;
            }
            return leftMinIndex;
    }



    public static void main(String[] args) {
        int[] arr = {10,20,30,50,10,70,30};
        printMaxOfMin(arr,arr.length);
    }

}
