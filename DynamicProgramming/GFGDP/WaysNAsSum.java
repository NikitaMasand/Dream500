package DynamicProgramming.GFGDP;
/*
Given a positive integer N,
the task is to find the number of different ways in which N can be written as a sum of two or more positive integers.


*/
public class WaysNsum {
    static int countWays(int n){

        int m = 1000000007;
        int[] ways = new int[n+1];
        ways[0]=1;
        for(int c=1;c<n;c++) {
            for (int i = 1; i <= n; i++) {
                if(i>=c)
                    ways[i] = ((ways[i]%m)+(ways[i-c]%m))%m;
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(5));
    }
}
