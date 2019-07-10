package Matrix;

import java.util.Scanner;

public class ExchangeColumns {
    static void exchangeColumns(int rows, int cols, int mat[][])
    {
        for(int i=0;i<rows;i++){
            int temp = mat[i][0];
            mat[i][0]=mat[i][cols-1];
            mat[i][cols-1]=temp;
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int mat[][] = new int[rows][cols];

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
                mat[i][j] = sc.nextInt();
        }
        exchangeColumns(rows,cols,mat);
    }
}
