package DynamicProgramming.GFGDP;

public class BottomUpDP {
    public static void main(String[] args) {
        System.out.println(Geeks.findNthFibonacci(5));
        System.out.println(Geeks.findNthFibonacci(5));

    }

}
class Geeks
{
    static long dp[] = new long[100];


    public static long findNthFibonacci(int number)
    {
        if(dp[number]>0)
            return dp[number];

        dp[2]=1;
        for(int i=3;i<=number;i++){

            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[number];
    }
}
