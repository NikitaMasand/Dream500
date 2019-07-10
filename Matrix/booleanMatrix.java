package Matrix;

public class booleanMatrix1 {
    static void booleanMatrix(int r, int c, int mat[][]) {
        int rows[] = new int[r];
        int cols[] = new int[c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==1){
                    rows[i]=1;
                    cols[j]=1;
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(rows[i]==1 || cols[j]==1)
                    System.out.print(1+" ");
                else
                    System.out.print(0+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] mat = { { 1,0,0},
                {1,0,0} ,
                {1,0,0},
                {0,0,0}};
        booleanMatrix(4,3,mat);
    }
}
