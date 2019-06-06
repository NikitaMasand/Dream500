/*
My notes:
Bubble sort:
Initially whole array is unsorted and as we move further array gets sorted
form the right side
compares the adjacent elements and accordingly swaps them
With each pass, largest element in the unsorted half will bubble up
to the highest index in the unsorted half.
2 7 4 1 5 3
first pass: 2 4 1 5 3 | 7
second pass: 2 4 1 3 | 5 7
third pass: 2 1 3 | 4 5 7
fourth pass: 1 2 | 3 4 5 7
fifth pass: 1 | 2 3 4 5 7
sorted..
n-1 passes for n elements
Inplace
Stable sorting algorithm
Best case: when there are no swaps, that means the array is already sorted
thus we have a flag variable and optimized the algorithm, if no swaps, break
the loop and thus best case becomes linear time by breaking of redundant passes

Just like that: Summation from lower bound to upper bound
= upper bound - lower bound + 1

So for other cases we wrote 1 for swap operation time in deriving worst and
best cases
but for avg time, we don't know how many swaps, so instead of 1 we put
expected value. E(x) = sum of possibilities * chance of each.
 = (1+0)*1/2
 1: there is a swap
 0: no swap

 I have also optimized worst case of descending order of array, instead of
 n^2 to n.
 i.e by a check if pass is first and count of swaps == n-1
 then array is descending order, thus reverse the array in linear time
 case                   swaps               comparisons
      best         |                0  | n
   worst           |                n  | n
average            |n(n-1)/4           | n(n-1)/2

 */










import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[]{10,9,8,7,4,1,0};
        bubbleSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));

    }
    public static void bubbleSort(int arr[],int n){
        for(int i = 1; i <= n-1; i++){
            int flag = 0;
            int count = 0;
            for(int j = 0; j <= n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    swap(j,j+1,arr);
                    flag = 1;
                    count ++;
                }
            }
            if(i==1 && count==n-1){
                System.out.println("calling reverse so that bubble works in linear time");
                reverse(arr);
                break;
            }
            if(flag==0)
                break;
        }
    }

    private static void swap(int indexOne, int indexTwo, int arr[]){
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
    private static void reverse(int[]arr){
        int i=0,j=arr.length-2;
        while(i<j){
            swap(i,j,arr);
            i++;
            j--;
        }
    }
}
