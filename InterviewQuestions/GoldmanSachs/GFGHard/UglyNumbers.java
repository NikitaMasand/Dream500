/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
		    int n = Integer.parseInt(br.readLine().trim());
		    System.out.println(printNthUglyNumber(n));
		}
	}
	

    public static long printNthUglyNumber(int n){
        long[] ugly = new long[n];
        int i2 = 0, i3 = 0, i5 = 0;
        ugly[0] = 1;
        long next_multiple_of_2 = ugly[i2]*2;
        long next_multiple_of_3 = ugly[i3]*3;
        long next_multiple_of_5 = ugly[i5]*5;

        for(int i=1; i<n; i++){
         ugly[i] = Math.min(next_multiple_of_2,Math.min(next_multiple_of_3,next_multiple_of_5));
         if(ugly[i]==ugly[i2]*2){
             i2++;
             next_multiple_of_2=ugly[i2]*2;
         }  
         if(ugly[i]==ugly[i3]*3){
             i3++;
             next_multiple_of_3=ugly[i3]*3;
         }
         if(ugly[i]==ugly[i5]*5){
             i5++;
             next_multiple_of_5=ugly[i5]*5;
         }
        }
        return ugly[n-1];
    }
    
      public static long printNthUglyNumberOtherMethod(int n){
        long arr[] = new long[n+1];
        arr[0] = 1;
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        for(int i=1; i<=n;i++){
            arr[i] = Collections.min(set);
            set.remove(arr[i]);
            set.add(arr[i]*2);
            set.add(arr[i]*3);
            set.add(arr[i]*5);
        }
        return arr[n];
    }

}
