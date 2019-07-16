package DynamicProgramming;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(EditDistanceRecursive.minEditDistance("abcdef","azced",6,5));
        System.out.println(EditDistanceDP.minEditDistance("saturday","sunday",8,6));
    }
}

class EditDistanceRecursive{
    public static int minEditDistance(String s1, String s2, int m, int n){
        if(m==0)
            return n;
        if(n==0)
            return m;
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return minEditDistance(s1,s2,m-1,n-1);
        else
            return 1+Math.min(
                    minEditDistance(s1,s2,m-1,n-1),   //replace
                    Math.min(minEditDistance(s1,s2,m,n-1), //insert into s1
                            minEditDistance(s1,s2,m-1,n))  //delete from s1
            );
    }
}
class EditDistanceDP{
    public static int minEditDistance(String s1, String s2, int m, int n){
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                else if(j==0){
                    dp[i][j]=i;
                }
                else{
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(
                                dp[i-1][j],dp[i][j-1]));
                        //min of replace,delete, insert..operations on s1.
                    }
                }
            }
        }
        return dp[m][n];
    }
}
