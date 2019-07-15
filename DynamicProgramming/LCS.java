package DynamicProgramming;

public class LCS {
    public static void main(String[] args) {
        String s1 = "AABCDY";
        String s2 = "AYCYDY";
        System.out.println(LCSRecursive.findLCS(s1,s2));
        System.out.println(LCSTabulation.findLCS(s1,s2));
    }
}
class LCSRecursive{
    public static int findLCS(String s1, String s2){
        return findLCSUtil(s1, s2, s1.length(),s2.length());
    }
    private static int findLCSUtil(String s1, String s2, int m, int n){
        if(m==0 || n==0)
            return 0;
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return 1+findLCSUtil(s1,s2,m-1,n-1);
        }

        return Math.max(
                findLCSUtil(s1,s2,m-1,n),
                findLCSUtil(s1,s2,m,n-1)
        );
    }
}

class LCSTabulation{
    public static int findLCS(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }

        }
        return dp[m][n];
    }
}
