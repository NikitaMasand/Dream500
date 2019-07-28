/*
Given a number N, find the number of ways to represent this number as a sum of 2 or more consecutive natural numbers.
*/

import java.lang.*;
import java.io.*;
//time complexity O(n)
public class consecutiveSumWays {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(findWays(n));
            System.out.println(findWaysFaster(n));
        }
    }


    /*
The idea is to represent N as a sequence of length L+1 as:
N = a + (a+1) + (a+2) + .. + (a+L)
=> N = (L+1)*a + (L*(L+1))/2
=> a = (N- L*(L+1)/2)/(L+1)
We substitute the values of L starting from 1 till L*(L+1)/2 < N
If we get 'a' as a natural number then the solution should be counted.
     */
    public static int findWaysFaster(int n){
        int ways = 0;
        for(int L=1; L*(L+1) < 2*n; L++){
            double a = ((double)(n-(L*(L+1)/2))/(L+1));
            if(a==Math.floor(a)){
                ways++;
            }
        }
        return ways;
    }
    public static int findWays(int n){
        int ways = 1;
        int low = n/2;
        int high = n/2 +1 ;
        int x = low+high;
        while(low<high && low>=1){

            if(x==n){
                ways++;
                x=x-high;
                high--;
                low--;
                x=x+low;
            }
            else if(x>n){
                x=x-high;
                high--;
                low--;
                x=x+low;
            }
            else{
                low--;
                x=x+low;
            }
        }
        return ways;
    }
}
