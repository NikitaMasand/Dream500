/*find the minimum element in the sorted and rotated array*/
public class MinFind{
    public static void main(String [] args){
        int arr[]=new int[]{4};
        System.out.println(findMinIndex(arr));
    }
    public static int findMinIndex(int arr[]){
        if(arr.length==1)
            return 0;
        int start = 0;
        int end = arr.length - 1;
        if(arr[0]<arr[end])
            return 0;
        while(start<=end){
            int mid = (start+end)/2;
            if(start<mid && arr[mid]<=arr[mid-1])
                return mid;
            else if(start==end)
                return start;
            else if(arr[mid]<arr[end])
                end = mid-1;
            else
                start = mid+1;
            
        }
        return -1;
    
}
}
