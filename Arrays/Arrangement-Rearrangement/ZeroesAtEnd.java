//Given an array of random numbers, Push all the zero’s of a given array to the end of the array
/*
if the current element traversed by j is positive, it is swapped with itself. 
else if it is 0, nothing is done and j is incremented, however i now points to that 0.
Then once j finds a positive number, it swaps with i element as i is pointing to 0
swapping takes it behind. 
see the code and take a working example it will make explanation better

One other approach can be by maintaining the count variable which is number of nonzero elements
once whatever is the value of count currently, should be the place of the element at time 
assuming 1 based indexing
for eg: 1,2,0,4,3,0,5,0
1: count = 1 
2: count = 2
0: count = 2
4: count = 3, thus arr[3] = 4, 1,2,4,4,3,0,5,0 
3: count = 4, thus arr[4] = 3  1,2,4,3,3,0,5,0
0: count = 4
5: count = 5, thus arr[5] = 5  1,2,4,3,5,0,5,0
0: count = 5
from i = count, i<n 
replace all elements with 0:
i.e 1,2,4,3,5,0,0,0


*/


import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {
		int arr[] = new int[]{1, 2, 0, 4, 3, 0, 5, 0};
		moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
		int arr1[] = new int[]{1, 2, 0, 0, 0, 3, 6};
		moveZeroes(arr1);
		System.out.println(Arrays.toString(arr1));
	}
	public static void moveZeroes(int arr[]){
	    int n = arr.length;
	    int i = -1;
	    int j = 0;
	    while(j<n){
	        if(arr[j]>0){
	            i++;
	            swap(arr,i,j);
	        }
	        j++;
	    }
	}
	public static void swap(int arr[],int i,int j){
	    int temp = arr[i];
	    arr[i]=arr[j];
	    arr[j]=temp;
	}
}
