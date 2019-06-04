
/*
My notes:
The array is divided into two parts, sorted and unsorted
and initially the array is considered to be unsorted.
Selection: the lowest element is selected in the remaining array
Swapping: bring this element to starting position of unsorted array,
i.e ending pos of sorted array,as it will be larger than the previous elements
Counter shift: change the counter for unsorted array by one.

We can also select the largest element and place it at the end and so on.
Here best,avg, worst cases all work the same for selection sort

No. of swaps: n-1
Why? Because swap does not depend on inner loop j,
once you find imin, you swap imin with i.
And you find imin atmost n-1 times because that is the num of elements..
This makes selection sort useful
when memory write operation is more expensive than memory read,
eg. flash memory, where each memory write reduces the lifespan of memory


No. of comparisons: n(n-1)/2
Because of two loops, try it by an example

Time complexity O(n^2)
Space complexity: 0(1)
It is inplace

Swapping makes selection sort unstable. Eg. 4 2 3 4 1.
First 4 will go to the last changing relative ordering of elements.
Selection sort can be made stable by instead of swapping
we insert the least element at the strt and shifting the other elements
i.e pushing them one step forward. Eg. 1 4 2 3 4
Then 4 is stable. ..this uses a technique like insertion sort.

Why? Among simple avg n2, ss outperforms bubble sort
but is worse than the insertion sort.

It can be implemented as recursive algorithm by taking the i for loop out
and sending i in the function call by updating it’s value.

 */
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
       int arr[] = new int[]{64,25,12,22,11};
       selectionSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
        int arr1[] = new int[]{4,5,3,2,4,1};
        selectionSort(arr1,arr1.length);
        System.out.println(Arrays.toString(arr1));
    }


    /*
       elements on left of | denote sorted elements, i.e the smallest
       element from the array is taken there at each pass
      | 64 25 12 22 11
      11 | 25 12 22 64
      11 12 | 25 22 64
      11 12 22 | 25 64
      11 12 22 25 | 64
      sorted
        */

    static void selectionSort(int arr[],int n){
        // n-2 passes, as for the n-1th pass, the array is already sorted
        for(int i=0;i<n-1;i++){
            int iMin = i; //elements from i till n-1 are unsorted
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[iMin])
                    iMin = j;
            }
            // swap(iMin,i,arr); this is for unstable selection sort
            //for stable selection sort, we shift the elements
            int key = arr[iMin];
            while(iMin>i){
                arr[iMin] = arr[iMin-1];
                iMin--;
            }
            arr[iMin] = key;
        }
    }
    static void swap(int indexOne, int indexTwo, int[]arr){
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
}
