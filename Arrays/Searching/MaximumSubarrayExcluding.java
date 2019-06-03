
/*
Given an array of A of n integers and an array B of m integers 
find the Maximum Contiguous Subarray Sum of array A
such that any element of array B is not present in that subarray


We have modified Kadane's algorithm a bit. While traversing the array A, we check for A[i] in sorted array B, if it's present
we set current_max = 0 as that element won't constitute to the subarray. And if not, we find current max as max of a[i] and currmax+a[i] 
as in kadane's algorithm, global max also in the similar way, max of global and curr.

Time complexity = mlogm(for sorting B) + nlogm(for traversing A, along with the find a[i] in B)
= (n+m)logm
*/
import java.util.Arrays;

public class MaximumSubarrayExcluding{
    public static void main(String[] args) {
        int A[] = {3, 4, 5, -4, 6};
        int B[] = {1, 8, 5};

        int n = A.length;
        int m = B.length;

        findMaxSum(A,B,n,m);
    }
    public static void findMaxSum(int A[], int B[], int m, int n){
        Arrays.sort(B);
        int maxSubarraySum = findMaxSumUtil(A,B,m,n);
        if(maxSubarraySum==Integer.MIN_VALUE){
            System.out.println("Maximum sum subarray not found");
        }
        else
        {
            System.out.println("Maximum subarray sum: " + maxSubarraySum);
        }

    }
    public static int findMaxSumUtil(int A[],int B[], int m, int n){
        int global_max = Integer.MIN_VALUE;
        int curr_max = A[0];
        for(int i=1;i<n;i++){
            if(Arrays.binarySearch(B,A[i])>=0){
                curr_max = 0;
                continue;
            }
                curr_max = Math.max(A[i],curr_max+A[i]);
                global_max = Math.max(curr_max,global_max);
        }
        return global_max;
    }

}
