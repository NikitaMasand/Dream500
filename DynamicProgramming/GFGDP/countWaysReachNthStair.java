/*
There are N stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time.
Count the number of ways, the person can reach the top (order does matter).
*/
package DynamicProgramming.GFGDP;

public class countWaysReachNthStair {
    /*
    this problem is like fibonacci series.
    suppose you are at 3rd stair..you can reach 3rd stair
    by jumping one either from the 2nd stair or jumping 2 from 1st stair
    thus
    no of ways of reaching nth stair =
    no of ways of reaching n-1th stair +
    no of ways of reaching n-2th stair

    eg: At 3:
    1+1+1
    1+2
    2+1

    At 2:
    1+1
    2

    calculating at 4:

    At 3 + At 2
    i.e adding 1 to elements at 3 + adding 2 to elements at 2 = 5 ways
     */
    public static long countWays(int n){
        int m = 1000000007;

        long[] ways = new long[n+1];
        ways[0] = 1;
        ways[1] = 1;
        for(int i=2;i<=n;i++){
            ways[i] = ((ways[i-1]%m) + (ways[i-2]%m))%m;
        }
        return ways[n];

    }
    public static void main(String[] args) {
        System.out.println(countWays(4));
    }
}
