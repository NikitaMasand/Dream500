package DynamicProgramming.GFGDP;

public class PascalsCombinatorics {
    public static void main(String[] args) {
        System.out.println(binomialRecursive.binomialCoeff(4,2));
        System.out.println(binomialDP.binomialCoeff(4,2));
    }
}
class binomialRecursive{
    public static int binomialCoeff(int n, int k){
        if(k==0 || k==n)
            return 1;
        return binomialCoeff(n-1,k-1) + binomialCoeff(n-1,k);
    }
}

class binomialDP{
    public static int binomialCoeff(int n, int k){
        int[][] coeff = new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=Math.min(i,k);j++){
                if(j==0 || j==i)
                    coeff[i][j] = 1;
                else
                    coeff[i][j] = coeff[i-1][j-1] + coeff[i-1][j];
            }
        }
        return coeff[n][k];
    }
}
