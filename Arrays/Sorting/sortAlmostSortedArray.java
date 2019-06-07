/*
This was one of my best questions.
Thanks back to back swe!
Okay the question is:
Given an array of size n,
we need to sort it. Just that, we are given k, i.e the possible position
of each element can be at a distance of atmost k from it's current position, consider
from left and right both.
Yay, simple sorting does work, in O(nlogn)
can we do better using k?
Yes we can.
First of all, let's try to write all the possible positions of the element acc to k and
let's try to observe something, what all possible elements can be at index 0? all the elements
from i/p at index 0 to index k CAN be at 0, but the minimum of them WILL be at 0. Then what
about 1 index? All the elements previously participated and the element at position k+1 CAN be,
but the min amongst them WILL be.
Eg:

i/p: 6  5   3   2   8   10  9
k = 3
possibilities of each element
index:   0  1   2   3   4   5   6
         6  6   6   6
         5  5   5   5   5
         3  3   3   3   3   3
         2  2   2   2   2   2   2
            8   8   8   8   8   8
                10  10  10  10  10
                    9   9   9   9
At 0th index: elements from index 0 to (3+1) are present
min among them is taken
and as we move on one element each time is entered in the set, until they are available
The data str to extract min and enter elements and find min again..yaya heap!
Algorithm:
Add k+1 elements to heap
extract minimum to index 0
add next element to heap and extract min until end of array is reached
after end of array, simply extract min.

Time complexity: O(k*logn)
Space complexity: O(k)


 */


import java.util.Arrays;
import java.util.PriorityQueue;

public class sortAlmostSortedArray {
    public static void main(String[] args) {
        int arr[] = new int[]{6,5,3,2,8,10,9};
        sortHeap(arr,3);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortHeap(int arr[], int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int n = arr.length;
        int i;
        for(i=0;i<=k; i++){
            heap.add(arr[i]);
        }
        int index = 0;
        while(i<n){
            arr[index]=heap.poll();
            index++;
            heap.add(arr[i]);
            i++;
        }
        while (index<n){
            arr[index]=heap.poll();
            index++;
        }
    }
}
