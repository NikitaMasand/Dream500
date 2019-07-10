package Matrix;

public class MatrixMultiplication {
    public static void main(String[] args) {

    }
    public static int[][] multiplyMatrix(int[][]a, int[][]b){
        int arows = a.length;
        int bcols = b[0].length;
        int brows = b.length;
        int acols = a[0].length;
        if(brows!=acols) {
            System.out.println("-1");
            return null;
        }
        int[][] product = new int[arows][bcols];
        int sum = 0;
        for(int i=0;i<arows;i++){
            for(int j=0;j<bcols;j++){
                for(int k=0;k<brows;k++){
                    sum+=a[i][k]*b[k][j];
                }
                product[i][j]=sum;
                sum=0;
            }
        }
        return product;
    }

    public static void printMatrix(int[][]mat){
        for (int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
