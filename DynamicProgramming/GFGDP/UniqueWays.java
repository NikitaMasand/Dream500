package DynamicProgramming.GFGDP;
/*
Given a M X N matrix with your initial position at top-left cell,
find the number of possible unique paths to reach the bottom right cell of the matrix from the initial position.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueWays {
    public static int uniqueWays(int m, int n){
        if(m==1 || n==1){
            return 1;
        }
        int[][] T = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    T[i][j] = 1;
                }
                else{
                    T[i][j] = T[i-1][j] + T[i][j-1];
                }
            }
        }
        return T[m-1][n-1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            System.out.println(uniqueWays(m,n));
        }
    }
}
