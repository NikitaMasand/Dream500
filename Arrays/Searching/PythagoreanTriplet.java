/*
Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
*/
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class PythagoreanTriplet {
	public static void main (String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine());
	        int arr[] = new int[n];
	        String s[] = br.readLine().split(" ");
	        for(int i=0;i<n;i++){
	            arr[i] = Integer.parseInt(s[i]);
	            arr[i] = arr[i]*arr[i];
	        }
	        Arrays.sort(arr);
	        boolean flag = false;
	        for(int i = n-1;i>=1;i--){
	            int c = arr[i];
	            if(isPair(c,0,i-1,arr)){
	                flag = true;
	                System.out.println("Yes");
	                break;
	            }
	        }
	        if(flag==false)
	            System.out.println("No");
	    }
	}
	
	public static boolean isPair(int c, int left, int right, int[] arr){
	    while(left<right){
	        if(arr[left]+arr[right]==c)
	            return true;
	       if(arr[left]+arr[right]<c)
	            left++;
	       else
	            right--;
	    }
	    return false;
	}
}
