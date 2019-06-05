/*
Given an array arr[] of integers,
find out the maximum difference between any two elements
such that larger element appears after the smaller number.

or

if in optimization problem of share buy/sell we are allowed to do transaction
only once, maxDiff such that larger occurs after smaller
is what we have to find

time-complexity = O(n)
space-complexity = O(1)

instead of nested looping, a better approach will be to keep track of the
minimum element so far, so that at any index i
i)if arr[i]<min, min = arr[i], continue
ii) max_diff = Max(arr[i]-min,max_diff)
2, 3, 10, 6, 4, 8, 1
here min = 2;
i = 1, max_diff = 3-2 = 1,
i = 2, max_diff = 10-2 = 8.....here it does not make a valid point to do 10-3,
because we already have subtracted 10 from the least element
i = 3, max_diff = 6-2,8 = 8...you know why 6-3 does not make sense?
i = 4, max_diff = 4-2,8 = 8
i = 5, max_diff = 8-2,8 = 8
i = 6, min = 1.
end
return 8


 */
public class MaxDiffLargerAfterSmaller {
    public static void main(String[] args) {
        int arr[]= new int[]{2, 3, 10, 6, 4, 8, 1};
        if(findMaxDiff(arr)<0){
            System.out.println("Max diff cannot be found such that larger element is after smaller");
        }
        else
            System.out.println(findMaxDiff(arr));
    }
    public static int findMaxDiff(int arr[]){
        int min_so_far = arr[0];
        int max_diff = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]<min_so_far) {
                min_so_far = arr[i];
            }
            else{
                max_diff = Math.max(arr[i]-min_so_far,max_diff);
            }
        }
        return max_diff;
    }
}
