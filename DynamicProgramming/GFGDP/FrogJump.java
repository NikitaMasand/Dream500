package DynamicProgramming.GFGDP;
//A frog jumps either 1, 2 or 3 steps to go to top. In how many ways can it reach the top
public class FrogJump {
    public static void main(String[] args) {
        System.out.println(countWays(5));
    }
    static long countWays(int n){
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;
        long[] ways = new long[n+1];
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;
        for(int i=4;i<=n;i++){
            ways[i] = ways[i-1]+ways[i-2]+ways[i-3];
        }
        return ways[n];
    }
}
