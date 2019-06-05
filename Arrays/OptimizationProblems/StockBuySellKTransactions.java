/*
https://www.youtube.com/watch?v=oDhu5uGq_ic&t=539s
https://www.youtube.com/watch?v=Pw6lrYANjz4
this is using dp 
there are two possibilities for any element at index i
either it is sold
or not
if it is not, the profit is simply the previous one T[i][j-1]
otherwise it is the current price value(selling price) - buying price..say at index m + price for i-1th transaction at index m 
i.e T[i-1][m]
one of my doubt was why not m-1? by m means it is also included in transaction.
this is because at m, buying and selling both are done simultaneously
i.e bought at 0, sold at m and bought at m, sold at j

thus the recursive formula becomes:
T[i][j] = max{T[i][j-1],
              prices[j]-prices[m]+T[i-1][m]}
              0<m<j
              the traversing of m is redundant and ime complexity can be reduced, by knowing what is max, you can check that 
              out in code.
for k =1, chck out finding diff between largest and smallest element such that largest comes after smallest, code is written
in the array directory.
*/





public class StockBuySellKTransactions {
    public static void main(String[] args) {
        int arr[]=new int[]{2,5,10,7,1,4,3,1,3};
        System.out.println(maxProfitSlowSolution(arr,3));
        System.out.println(maxProfit(arr,3));
    }

    // time complexity:  O(n^2k)
    public static int maxProfitSlowSolution(int[]prices,int k){
        int T[][] = new int[k+1][prices.length];
        for(int i=1;i<T.length;i++){
            for(int j=1; j<T[0].length; j++){
                int maxVal = 0;
                for(int m=0; m<j; m++){
                    maxVal = Math.max(prices[j]-prices[m]+T[i-1][m],maxVal);
                }
                T[i][j] = Math.max(T[i][j-1],maxVal);
            }
        }
        return T[k][prices.length-1];
    }
    //time complexity: O(nk)
   public static int maxProfit(int prices[],int k){
        int T[][] = new int[k+1][prices.length];
        for(int i=1; i<T.length; i++){
            int maxDiff = -prices[0];
            for(int j=1; j<T[0].length; j++){
                T[i][j] = Math.max(T[i][j-1],maxDiff+prices[j]);
                maxDiff = Math.max(T[i-1][j]-prices[j],maxDiff);
            }
        }
       return T[k][prices.length-1];
   }

}
