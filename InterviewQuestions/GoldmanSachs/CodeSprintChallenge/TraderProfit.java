/*
Mike is a stock trader and makes a profit by buying and selling stocks. He buys a stock at a lower price
and sells it at a higher price to book a profit. He has come to know the stock prices
of a particular stock for upcoming days in future and wants to calculate the maximum profit
by doing the right transactions (single transaction = buying + selling). Can you help him maximize his profit?

Note: A transaction starts after the previous transaction has ended. Two transactions can't overlap or run in parallel.

The stock prices are given in the form of an array A for d days.

Given the stock prices and a positive integer k , find and print the maximum profit Mike can make in at most transactions.
*/

/*
Let profit[t][i] represent maximum profit using at most t transactions up to day i (including day i). Then the relation is:
profit[t][i] = max(profit[t][i-1], max(price[i] – price[j] + profit[t-1][j]))   
for all j in range [0, i-1]

profit[t][i] will be maximum of :-
profit[t][i-1] which represents not doing any transaction on the ith day

Maximum profit gained by selling on ith day.
In order to sell shares on ith day, we need to purchase it on any one of [0,i-1] days.
If we buy shares on ith day and sell it on jth day
max profit will be price[i]-price[j]+profit[t-1][j]
where j varies from 0 to i-1. Here profit[t-1][j] is best we could have done with one less transaction till jth day.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int traderProfit(int k, int d, int[] price) {
        int[][] profit = new int[k+1][d+1];
        for(int t = 0; t<=k; t++){
            for(int i = 0; i<d; i++){
                if(t==0){
                    profit[t][i] = 0;
                }
                else if(i==0){
                    profit[t][i] = 0;
                }
                else{
                    int x = 0;
                    for(int j=0;j<i;j++){
                         x = Math.max(x,price[i]-price[j]+profit[t-1][j]);
                    }
                    profit[t][i] = Math.max(x, profit[t][i-1]);
                }
            }
        }
        return profit[k][d-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = traderProfit(k, n, arr);
            System.out.println(result);
        }
        in.close();
    }
}
