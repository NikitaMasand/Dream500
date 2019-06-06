/*
My notes:
For insertion, consider first element initially as sorted array, and rest as
unsorted. Then insert second element in to val and consider that pos as hole
shift all elements in sorted arr greater than val to the right using hole and
decreasing it's value by 1.
finally place the val where hole is.
It will clear through an example:

for loop for traversing all the elements
while loop for traversing the sorted array to see which elements are greater
than val in order to shift them
7, 8, 2, 5
7 | 8 2 5
val = 8, hole = 1 index
since 7<val, do nothing
7 8 | 2 5
val = 2, hole = 2 index
since hole>0 && arr[1]>val
arr[hole] = arr[1], hole = 1
7 8 8 | 5
val = 2, hole=1, 7>2
since hole>0 && arr[hole-1]>val
arr[hole] = arr[hole-1]
7 7 8 | 5
arr[hole] = val (2)
 2 7 8 | 5
 similarly for 5 also
 2 5 7 8

 Time complexity : O(n^2)
 Best case: moves O(n) and comparisons O(n)
 Worst case: moves O(n^2) and comparisons O(n^2)
 
 I could not understand why
 For smaller values of N, 
 insertion sort performs efficiently like other quadratic sorting algorithms.
 */

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = new int[]{2,4,7,1,5,3};
        insertionSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));

    }
    public static void insertionSort(int arr[],int n){
        for(int i=1; i<n; i++){
            int val = arr[i]; // move
            int hole = i; //move
            while(hole>0 && arr[hole-1]>val){//comparison
                arr[hole] = arr[hole-1];//move
                hole--;
            }
            arr[hole] = val;//move
        }
    }
}
