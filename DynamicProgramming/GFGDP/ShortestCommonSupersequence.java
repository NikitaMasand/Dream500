package DynamicProgramming.GFGDP;
//Find the length of the smallest string which has both,
//str1 and str2 as its sub-sequences

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//shortest common supersequence = length of s1+
//                                length of s2 -
//                                 length of LCS
public class ShortestCommonSupersequence {
    public static int LCS(String s1, String s2){

       int m = s1.length();
       int n = s2.length();

        int[][] T = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    T[i][j] = 0;
                }
                else if(j==0){
                    T[i][j] = 0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    T[i][j] = 1+T[i-1][j-1];
                }
                else{
                    T[i][j] = Math.max(T[i-1][j],T[i][j-1]);
                }
            }
        }
        return T[m][n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            String[] input = br.readLine().split(" ");
            String s1 = input[0];
            String s2 = input[1];
            System.out.println(s1.length()+s2.length()-LCS(s1,s2));
        }

    }
}
