public class kadanes {
    public static void main(String[] args) {
        int arr[] = new int[]{1,-3,2,-5,7,6,-1,-4,11,-23};
        System.out.println(maxSumSubarray(arr));
    }
    public static int maxSumSubarray(int arr[]){
        int curr = arr[0];
        int global = arr[0];
        for(int i=1;i<arr.length;i++){
            curr = Math.max(arr[i],curr+arr[i]);
            global = Math.max(global,curr);
        }
        return global;
    }
}
