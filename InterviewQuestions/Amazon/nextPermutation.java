/*package whatever //do not write package name here */


/*
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.
If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

For example:
1,2,3 → 1,3,2
3,2,1 → 1,2,3
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    int[] arr = new int[n];
		    String[] input = br.readLine().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(input[i]);
		    }
		    findNextPermutation(arr);
		}
	}
	
	static void findNextPermutation(int[] arr){
	    int n = arr.length;
	    int j=-1;
	    for(int i=n-1; i>0; i--){
	        if(arr[i]>arr[i-1]){
	            j = i-1;
	            break;
	        }
	    }
	    
	    if(j!=-1){
	    int minIndex=-1;
	    int minValue = Integer.MAX_VALUE;
	    for(int i=j+1;i<n;i++){
	        if(arr[i]>arr[j] && arr[i]<minValue){
	            minValue = arr[i];
	            minIndex = i;
	        }
	    }
	    
	    int temp = arr[j];
	    arr[j] = arr[minIndex];
	    arr[minIndex] = temp;
	    
	    Arrays.sort(arr,j+1,n);
	    }
	    
	    for(int i=0;i<n;i++){
	        System.out.print(arr[i]+" ");
	    }
	    
	    System.out.println();
	}
}
