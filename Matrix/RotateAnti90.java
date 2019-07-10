package Matrix;

public class RotateAnti90 {
    public static void rotate(int[][] mat){
        int n = mat.length;
        //transpose of matrix
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        //reversing columns
        for(int j=0;j<n;j++){
            for(int i=0;i<(n-i-1);i++){
                int temp = mat[i][j];
                mat[i][j]=mat[n-i-1][j];
                mat[n-i-1][j]=temp;

            }
        }
    }

    public static void printMatrix(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        rotate(arr);
        printMatrix(arr);
    }
}
