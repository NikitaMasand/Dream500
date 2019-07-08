package Stacks;
/*
Given an integer array A[] of size N. The task is to find the maximum of the minimum of every window size in the array.

For every element we found the previous smaller and the next smaller element.
So the length of window in which that element is smallest is found out by subtracting the indices i.e right[i]-left[i]-1.
The left and right arr are found in 0(1) using stacks.
And then the final ans arr is created where for every window length the element is added.
If two or more elements have the same window length, the max of two is taken into consideration.
There might be a case if from the above approach length of some windows are not found by observation,
the ans elements are in non increasing order. And thus if ans element is 0, it is found as max[arr[i],arr[i+1].
you will understand it if you try on book.


*/
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
