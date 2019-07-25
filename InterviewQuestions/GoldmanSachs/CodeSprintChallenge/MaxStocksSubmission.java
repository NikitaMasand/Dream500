import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*
In a stock market, there is a product with its infinite stocks.
The stock prices are given for i days, where arr[i] denotes the price of the stock on the  day.
There is a rule that a customer can buy at most i stock on the ith day.
If the customer has an amount of k dollars initially, find out the maximum number of stocks they can buy?
*/


public class Solution {

    static long buyMaximumProducts(long n, long k, long[] arr) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        long num = 0;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.replace(arr[i],map.get(arr[i])+(i+1));
            }
            else
                map.put(arr[i],i+1);
        }

        for(Long i: map.keySet()){
            if(k<=0){
                return num;
            }
            if(i*map.get(i)<=k){
                k = k-(i*map.get(i));
                num+=map.get(i);
            }
            else{
                num+=k/i;
                return num;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }
}
