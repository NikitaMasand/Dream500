package Matrix;

public class BoundaryTraversal {
    static void boundaryTraversal(int rows, int cols, int mat[][])
    {
        for(int j=0;j<cols;j++){
            System.out.print(mat[0][j]+" ");
        }
        if(cols-1!=0) {
            for (int i = 1; i < rows; i++) {
                System.out.print(mat[i][cols - 1] + " ");
            }
        }
        if(rows-1!=0) {
            for (int j = cols - 2; j >= 0; j--) {
                System.out.print(mat[rows - 1][j] + " ");
            }
        }
        for(int i=rows-2;i>=1;i--){
            System.out.print(mat[i][0]+" ");
        }

    }
    public static void main(String[] args) {
        int mat[][] = {{5,99,82,46,51,75,40,77,86,86,19,33,2,61,52,22,17,19,26,45,93,90,19,15,0,15} };
        boundaryTraversal(1,26,mat);
    }
}
