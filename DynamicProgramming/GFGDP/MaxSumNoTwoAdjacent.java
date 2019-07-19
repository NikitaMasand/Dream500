package DynamicProgramming.GFGDP;
/*
You are given an array arr of size sizeOfArr.
You need to find the maximum-sum of the array provided that you cannot sum neighboring elements.
*/
public class MaxSumNoTwoAdjacent {
    public static void main(String[] args) {
        int arr[] = {-2, -3, -4};
        System.out.println(findMaxSum(arr));
    }
    public static long findMaxSum(int[] arr){
        int n =arr.length;
        long[] store = new long[n];
        store[0] = arr[0];
        store[1] = Math.max(arr[1],store[0]);
        long max = Integer.MIN_VALUE;
        for(int i=2;i<n;i++){
            store[i] = Math.max(store[i-1], Math.max(arr[i]+store[i-2],arr[i]));
            max = Math.max(max,store[i]);
        }
        return max;
    }
}



/*
    dp[0]=max(dp[0],arr[0])
    dp[1]=max(dp[0],arr[1])
    for i in range(2,sizeOfArray):
        dp[i]=max(dp[i-2]+arr[i],dp[i-1])
       
*/
class MaxSumNoTwoAdjacentPositive {
    public static long findMaxSum(int[] arr){
        int n = arr.length;
        boolean checkIfNeg = true;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                checkIfNeg=false;
                break;
            }
        }
        if(checkIfNeg==true){
            return (long) Arrays.stream(arr).max().getAsInt();
        }
        //incl: max sum including the previous element
        //excl: max sum excluding the previous element
        //exclNew: curr max excluding i
        int incl = arr[0];
        int excl = 0;
        int exclNew;
        for(int i=1;i<n;i++){
            exclNew = Math.max(incl,excl);
            incl = arr[i]+excl;

            excl = exclNew;

        }
        return Math.max(incl,excl);
    }
}
