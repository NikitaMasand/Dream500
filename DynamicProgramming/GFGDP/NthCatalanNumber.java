package DynamicProgramming.GFGDP;
/*
Given a number N. The task is to find the nth catalan number.
The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class NthCatalanNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            nthCatalanNum(n);
        }
    }
    public static void nthCatalanNum(int n){
        BigInteger dp[] = new BigInteger[n+1];
        dp[0]=BigInteger.ONE;
        for(int i=1;i<=n;i++){
            dp[i]=BigInteger.ZERO;
            for(int j=0;j<i;j++){
                int k = i-1;
                dp[i]= dp[i].add(dp[j].multiply(dp[k-j]));
            }
        }
        System.out.println(dp[n]);
        return;
    }
}
