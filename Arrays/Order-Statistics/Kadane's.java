//printing max subarray sum and their indices
//kadane's algorithm


public class kadanes {
    public static void main(String[] args) {
        int arr[] = new int[]{1,-3,2,-5,7,6,-1,-4,11,-23};
        System.out.println(maxSumSubarray(arr));
    }
    public static int maxSumSubarray(int arr[]){
        int start = 0;
        int end = 0;
        int curr = arr[0];
        int global = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>curr+arr[i]){
                curr = arr[i];
                start = i;
            }
            else{
                curr = curr+arr[i];
            }
            if(global<curr){
                global = curr;
                end = i;
            }
        }
        System.out.println("Starting from: "+ start+" Ending at: "+end);
        return global;
    }
}
