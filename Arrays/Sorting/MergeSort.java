
import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int arr[],int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public static void merge(int arr[],int low, int mid, int high){
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
    }
    public static void main(String[] args) {
        int arr[] = {15,5,24,8,1,3,16,10,3,1,20};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
