package HackerRankInterviewPreparation.StringManipulation;

public class CommonChild {
    static int commonChild(String s1, String s2) {
        //s1 and s2 have equal lengths
        int n = s1.length();
        int T[][] = new int[n+1][n+1];
        for(int i=0;i<T.length;i++){
            T[i][0]=0;
        }
        for(int i=0;i<=n;i++){
            T[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    T[i][j] = 1+T[i-1][j-1];
                }
                else{
                    T[i][j]=Math.max(T[i-1][j],T[i][j-1]);
                }
            }
        }
        return T[n][n];


    }

    public static void main(String[] args) {
        System.out.println(commonChild("HARRY","SALLY"));

    }
}
