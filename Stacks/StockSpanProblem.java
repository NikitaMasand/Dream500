/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock
and we need to calculate the span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.



Similar to max of min for every window.
So basically starting from last element, we find the first element that is greater than the current element.
That much span will be the span that the element is always greater in that span.
For easier calculation, the stack stores the indices of the array.
If the for loop is done and still there are elements in the stack
that means that the element is always greater in it’s range from 0 to i.

*/
package Stacks;

import java.util.Stack;

public class StockSpanProblem {
    public static void calculateSpan(int price[], int n, int S[])
    {
        Stack<Integer>stack=new Stack<>();

        stack.push(n-1);
        for(int i=n-2;i>=0;i--){
            while (!stack.isEmpty()&&price[i]>price[stack.peek()]){
                S[stack.peek()]=stack.peek()-i;
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            S[stack.peek()]=stack.peek()+1;
            stack.pop();
        }

        for(int i=0;i<S.length;i++){
            System.out.print(S[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] ={10, 4, 5, 90, 120, 80};
        int S[] = new int[arr.length];
        calculateSpan(arr,arr.length,S);

    }
}
