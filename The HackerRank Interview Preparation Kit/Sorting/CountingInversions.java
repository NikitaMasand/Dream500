package HackerRankInterviewPreparation.Sorting;

import java.util.Arrays;

public class CountingInversions {
    public static long countInversions(int arr[],int low, int high){
        if(arr.length<2)
            return 0;
        if(low<high) {
            int mid = (low + high) / 2;
            return countInversions(arr, low, mid) + countInversions(arr, mid + 1, high) +
                    merge(arr, low, mid, high);
        }
        return 0;
    }
    public static long merge(int arr[],int low, int mid, int high){
        long count = 0;
        int n1 = mid-low+1;
        int n2 = high-mid;

        int i=0;
        int j = 0;
        int k = low;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int m =0;m<n1;m++){
            left[m]=arr[m+low];
        }
        for(int m=0;m<n2;m++){
            right[m]=arr[m+mid+1];
        }
        while (i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]= left[i];
                i++;
            }
            else{
                arr[k]=right[j];
                j++;
                count+=n1-i;
            }
            k++;
        }
        while (i<n1){
            arr[k]=left[i];
            k++;
            i++;
        }
        while (j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {2,1,3,1,2};
        System.out.println(Arrays.toString(arr));
        System.out.println(countInversions(arr,0,arr.length-1));
        System.out.println(Arrays.toString(arr));
    }
}
