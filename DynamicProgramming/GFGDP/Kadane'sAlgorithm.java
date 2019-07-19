package DynamicProgramming.GFGDP;

public class kadanesAlgorithm {
    public static void main(String[] args) {
        int arr[] = {-9,-8,8,3,-4};
        maxSumSubarray(arr);
    }

    public static long maxSumSubarray(int[] arr){
        long currSum = arr[0];
        long maxSum = arr[0];
        System.out.print(currSum+" ");
        for(int i=1;i<arr.length;i++){
            if(arr[i]>currSum+arr[i]){
                currSum = arr[i];
            }
            else{
                currSum = arr[i]+currSum;
            }
            maxSum = Math.max(currSum,maxSum);
            System.out.print(currSum+" ");
        }
        System.out.println();
        return maxSum;
    }
}
