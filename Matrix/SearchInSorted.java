package Matrix;

public class SearchInSortedMatrix {
    static int search(int n, int m, int mat[][], int x)
    {
        int i =0;
        int j = n-1;
        while (i<m && j>=0){
            int k = mat[i][j];
            if(k==x)
                return 1;
            else if(k>x)
                j--;
            else
                i++;
        }
        return 0;
    }
    public static void main(String[] args) {
        int mat[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        System.out.println(search(4,4,mat,10));
    }
}
