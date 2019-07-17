/*
You have infinite supply of coins, each having some value.
Can you figure out the number of ways to use the coins to sum-up to a certain required value. 
*/
package DynamicProgramming.GFGDP;

public class MinWaysCoinChange {
    public static long numberOfWays(int[] coins, int value){
        long[] ways = new long[value+1];
        ways[0]=1;
        for(int coin: coins) {
            for (int i = 1; i <= value; i++) {
                if(i>=coin)
                    ways[i] = ways[i]+ways[i-coin];
            }
        }
        return ways[value];
    }
    public static void main(String[] args) {
        int[] coins = {2,5,3,6};
        System.out.println(numberOfWays(coins,11));
    }
}
