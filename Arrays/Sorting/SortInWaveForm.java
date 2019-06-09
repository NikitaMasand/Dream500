/*
arr = [10,90,49,2,1,5,23]
Given an unsorted array of integers, sort the array into a wave like array. An array
‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >=.
We can simply sort the array and swap adj. elements
Like for given eg:
sort: 1,2,5,10,49,53,90
swap: 2,1,10,5,53,49,90

The idea is as we can see the element at even position is always greater than the
elements adjacent to it, as can be seen. i.e from the odd positioned elements

so instead of sorted in nlogn, we can simply traverse the even positions and compare
that with the elements adj to it, if it's smaller we simply bring the greater element
to the even position, that will serve the purpose in O(n) time.

 */


import java.util.Arrays;

public class SortInWaveForm {
    public static void main(String[] args) {
            int arr[] = new int[]{10,90,49,2,1,5,23};
            sortInWave(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortInWave(int arr[]){
        int n = arr.length;
        for(int i=0;i<n;i+=2){
            if(i>0 && arr[i-1]>arr[i]){
                swap(arr,i-1,i);
            }
            if(i<n-1 && arr[i+1]>arr[i]){
                swap(arr,i,i+1);
            }
        }
    }

    private static void swap(int arr[], int indexOne, int indexTwo){
        int temp = arr[indexOne];
        arr[indexOne]=arr[indexTwo];
        arr[indexTwo]=temp;
    }
}
