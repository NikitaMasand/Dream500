/*
Given an array arr[].
Find maximum value of prefix sum which is also suffix sum for index i in arr[].


To find sum of an arr in java = 
IntStream.of(arr).sum();

This had to evaluate 2 variables each time the element was encountered. 
Prefix_sum and suffix_sum. Prefix sum is nothing but the previous prefix_sum + the element itself. 
Suffix_sum at strt is the sum of all array elements itself, 
and it goes on decreasing by arr[i] before going to next element so that we don’t have to go back to find arr[i]  of previous again.
Time complexity = O(n)
Auxiliary space = O(1)
*/



import java.lang.Math.*;
import java.util.stream.*;

public class MaxEquilibriumSum {
    public static void main(String[] args) {
        int arr[] = new int[]{-2,5,3,1,2,6,-4,2};
        System.out.println(findMaxEquilibrium(arr));
    }

    public static int findMaxEquilibrium(int arr[]){
        int prefix_sum = 0;
        int suffix_sum = IntStream.of(arr).sum();
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            prefix_sum += arr[i];
            if(prefix_sum==suffix_sum){
                res = Math.max(res,suffix_sum);
            }
            suffix_sum -= arr[i];
        }
        return res;
    }
}
