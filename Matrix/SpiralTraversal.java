package Matrix;

public class SpiralTraversal {
    static void spirallyTraverse(int rows, int cols, int mat[][])
    {
        /*
        dir 0: left to right, T++
        dir 1: top to bottom, R--
        dir 2: right to left, B--
        dir 3: bottom to top, L++

         */
        int T = 0;
        int B = rows-1;
        int L = 0;
        int R = cols-1;
        int dir = 0;
        while (L<=R && T<=B){
            if(dir==0){
               for(int i=L;i<=R;i++){
                    System.out.print(mat[T][i]+" ");
                }
                T++;
            }
            else if(dir==1){
                for(int i=T;i<=B;i++){
                    System.out.print(mat[i][R]+" ");
                }
                R--;
            }
            else if(dir==2){
                for(int i=R;i>=L;i--){
                    System.out.print(mat[B][i]+" ");
                }
                B--;
            }
            else if(dir==3){
                for(int i=B;i>=T;i--){
                    System.out.print(mat[i][L]+" ");
                }
                L++;
            }
            dir = (dir+1)%4;
        }
    }
    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spirallyTraverse(4,4,mat);
    }
}
