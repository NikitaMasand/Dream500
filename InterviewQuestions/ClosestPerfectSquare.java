/*
find a number who is a perfect square that is closest to the given number
eg: 100 given
81 is closest
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NSquareClosest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            long n = Long.parseLong(br.readLine());
            System.out.println(closestRoot(n));

        }
    }
    public static long closestRoot(long n){
        if(n==1)
            return 0;
        double root = Math.sqrt(n);
        if(root%1==0){
            long a = (long)(n-((root-1)*(root-1)));
            long b = (long)(((root+1)*(root+1))-n);
            return a<b ? (long)Math.pow(root-1,2):(long)Math.pow(root+1,2);
        }
        long low = (long)Math.floor(root);
        long high = (long)Math.ceil(root);
        long a = n-(low*low);
        long b = (high*high)-n;
        return a<b ? (low*low):(high*high);
    }
}
