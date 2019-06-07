/*
given an integer x, search in a row wise and column wise sorted matrix
it's easy to think of O(n^2)
however, make use of the property that matrix is row and column wise sorted.
consider starting from the topmost right element at i=0,j=n-1.
compare that element say p, with given k.
1. if p==k, return i,j..current positions
2. if p<k, then eliminate that row i++ because all elements at same j and lesser i will
also be smaller than k as they are smaller than p
3. p>k, then eliminate that col j--,because all elements at same i and greater j will also
be greater than k as they are greater than p

if at the end, i, j exceed the limit i.e j goes to -1 and i goes to n,
then that means element is not found at that position

 */


public class SearchSortedMatrix {
    public static void main(String[] args) {
        int mat[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50} };

        searchInSortedMatrix(mat, 4, 50);
    }
    public static void searchInSortedMatrix(int matrix[][], int n, int k){
        int i = 0, j = n-1;
        int p = matrix[i][j];
        while(i<n && j>=0){
            if(matrix[i][j]==k) {
                System.out.println("element found at row: " + i + " col: " + j);
                return;
            }
            else if(matrix[i][j]>k) {
                j--;
            }
            else{
                i++;
            }
        }
        System.out.println("Element not found");
    }
}
