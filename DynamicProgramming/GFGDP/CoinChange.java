package DynamicProgramming.GFGDP;
//time comp: O(value*coinlength)
//space comp: O(value)
//you have infinite supply of coins, each having some value.
//Can you figure out the minimum number coins required so that coins to sum-up to a certain required value. 
public class MinCoinsForChange {

    public static long minimumNumberOfCoins(int[] coins, int value){
        long[] minCoinsRequired = new long[value+1];
        for(int i=0;i<minCoinsRequired.length;i++){
            minCoinsRequired[i]=Integer.MAX_VALUE;
        }
        minCoinsRequired[0]=0;
        for(int coin: coins){
            for(int i=1;i<=value;i++){
                if(i>=coin){
                    minCoinsRequired[i] = Math.min(minCoinsRequired[i],1+minCoinsRequired[i-coin]);
                }
            }
        }
        return minCoinsRequired[value];
    }
    public static void main(String[] args) {
        int coins[] = {9,6,5,1};
        System.out.println(minimumNumberOfCoins(coins,11));

    }
}
