package Stacks;
/*

Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.
For simplicity, assume that all bars have same width and the width is 1 unit.

For every element previous smaller and next smaller is found,
that gives the width of rect, that multiplied by height and finding max among all gives the max area.
*/
import java.util.Stack;

public class LargestRectangleHistogram{
    static long largestRectangle(int[] arr) {
        long[] leftSmaller = previousSmallerElementIndex(arr,arr.length);
        long[] rightSmaller = nextSmallerElementIndex(arr,arr.length);

        long maxArea = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maxArea = Math.max(maxArea,((rightSmaller[i]-leftSmaller[i]-1)*arr[i]));
        }
        return maxArea;
    }

    static long[] nextSmallerElementIndex(int[] arr, int n){
        Stack<Integer> stack = new java.util.Stack<>();
        long rightMinIndex[] = new long[n];
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

    static long[] previousSmallerElementIndex(int[] arr, int n){
        Stack<Integer> stack=new Stack<>();
        long leftMinIndex[] = new long[n];
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
        int arr[] = {7,2,8,9,1,3,6,5};
        System.out.println(largestRectangle(arr));
    }
}
