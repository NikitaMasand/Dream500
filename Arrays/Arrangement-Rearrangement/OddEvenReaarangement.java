/*
Given an array of n elements. Our task is to write a program to rearrange the array 
such that elements at even positions are greater
than all elements before it and elements at odd positions are less than all elements before it.
*/


/*

I have coded reverse way for odd and even because 
the question assumes first position as odd, and we start with 0 which is even. 
So I have considered even will be lesser from previous and odd will be greater.
Rest for the logic, I sorted the arr in to the new arr called sortedArr. 
Then starting from right in arr, whenever i%2==0 
I copied the element from sortedArr as it is the smallest 
and incremented k by one else -1. 
After this, I again traversed the arr 
and wherever it is -1 simply copied the element from sortedArr.
Because for odd positions(in our case) the element should always be greater than the previous one.

*/







import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {
	   int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
	   rearrangeOddEven(arr);
	   System.out.println(Arrays.toString(arr));
	   int arr1[]=new int[]{1, 2, 1, 4, 5, 6, 8, 8};
	   rearrangeOddEven(arr1);
	   System.out.println(Arrays.toString(arr1));
	    
	}
	public static void rearrangeOddEven(int arr[]){
	    int n = arr.length;
	    int sortedArr[] = new int[n];
	    for(int i=0;i<n;i++){
	        sortedArr[i] = arr[i];
	    }
	    Arrays.sort(sortedArr);
	    int k = 0; // pointer to the sortedArr
	    for(int i=n-1;i>=0;i--){
	        if(i%2==0){
	            arr[i]=sortedArr[k];
	            k++;
	        }
	        else{
	            arr[i]=-1;
	        }
	    }
	    for(int i=0;i<n;i++){
	        if(arr[i]==-1){
	            arr[i]=sortedArr[k];
	            k++;
	        }
	    }
	}
}
