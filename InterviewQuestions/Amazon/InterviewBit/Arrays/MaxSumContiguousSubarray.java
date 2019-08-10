/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum
218/225
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int currSum = A[0];
        int maxSum = A[0];
        
        for(int i=1; i<A.length; i++){
            if(A[i]>A[i]+currSum){
                currSum = A[i];
            }
            else{
                currSum = currSum + A[i];
            }
            
            if(currSum>maxSum){
                maxSum = currSum;
            }
        }
        
        return maxSum;
    }
}
