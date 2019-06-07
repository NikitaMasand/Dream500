//time complexity: O(logn)
//space complexity : O(logn)...due to stack space from recursive calls

public class OccurencesCountSortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 3, 3, 3};
        int k =  3;
        int n = arr.length;
        int c = countOccurrence(arr, k);
        System.out.println(k+" occurs "+c+" times");
    }
    public static int countOccurrence(int arr[],int k){
        int n = arr.length;
        int i = firstOccurrence(arr, k,0,n-1);
        if(i==-1)
            return i;
        int j = lastOccurrence(arr, k, i,n-1);
        return j-i+1;
    }

    private static int firstOccurrence(int arr[], int k, int low, int high){
        if(high>=low){
            int mid = low + (high-low)/2;
            if(( mid==0 || k>arr[mid-1]) && arr[mid]==k)
                return mid;
            else if(arr[mid]>=k)
                return firstOccurrence(arr, k, low, mid-1);
            else
                return firstOccurrence(arr, k, mid+1, high);
        }
        return -1;
    }
    private static int lastOccurrence(int arr[],int k, int low, int high){
        if(high>=low){
            int mid = low + (high-low)/2;
            if(( mid==arr.length-1 || k<arr[mid+1] ) && arr[mid]==k)
                return mid;
            else if(arr[mid]>k)
                return lastOccurrence(arr, k, low, mid-1);
            else
                return lastOccurrence(arr, k, mid+1, high);

        }
        return -1;
    }

}
