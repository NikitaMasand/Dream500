package Matrix;

public class booleanMatrix {
    static void booleanMatrix(int r, int c, int mat[][]) {
        boolean firstRowOne = false;
        boolean firstColOne = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && mat[i][j] == 1) {
                    firstRowOne = true;
                }
                if (j == 0 && mat[i][j] == 1) {
                    firstColOne = true;
                } else if (mat[0][j] == 1 && mat[i][0] == 1) {
                    continue;
                } else if (mat[i][j] == 1) {
                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0) {
                    if (firstRowOne) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(mat[i][j]);
                    }
                } else if (j == 0) {
                    if (firstColOne) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(mat[i][j]);
                    }
                } else if (mat[0][j] == 1 || mat[i][0] == 1)
                    System.out.print(1 + " ");
                else {
                    System.out.print(0 + " ");
                }
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
