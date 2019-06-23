package DynamicProgramming;

import java.io.*;
        import java.math.*;

public class FibonacciModified {
    static BigInteger fibonacciModified(int t1, int t2, int n) {
        if(n==1)
            return BigInteger.valueOf(t1);
        if(n==2)
            return BigInteger.valueOf(t2);
        else{
            BigInteger val[] = new BigInteger[n];
            val[0] = BigInteger.valueOf(t1);
            val[1] = BigInteger.valueOf(t2);
            for(int i=2;i<n;i++){
                val[i] = val[i-1].pow(2).add(val[i-2]);
            }
            return val[n-1];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int t1 = Integer.parseInt(input[0]);

        int t2 = Integer.parseInt(input[1]);

        int n = Integer.parseInt(input[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        System.out.println(result);
    }
}
