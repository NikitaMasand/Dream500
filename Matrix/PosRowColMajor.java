package Matrix;
//address for row major & 0 based indexing:
//A[i][j]=B+(i*cols + j)*size
//for col major & 0 based indxing
//A[i][j]=B+(j*rows + i)*size
//if it was 1 based indexing, subtract i,j with 1
//equating both we get j=(N-1)i/(M-1)..N is cols and M is rows
//for every i, the rhs is an integer means that is a valid element
//depending on n,m we can iterate for i as well as j. so time complexit will b O(min(m,n))
public class PosRowColMajor {
    public static int getCount(int rows, int cols){
        int count = 0;

        if(rows==1){
            count = cols;
        }
        if(cols==1)
            count = rows;
        if(rows<=cols){
            for(int i=0;i<rows;i++){
                int numerator = (cols-1)*i;
                int denominator = (rows-1);
                if(numerator%denominator==0){
                    count++;
                }
            }
        }
        else{
            for(int j=0;j<cols;j++){
                int numerator = (rows-1)*j;
                int denominator = (cols-1);
                if(numerator%denominator==0){
                    count++;
                }
            }
        }
        return count;

    }
    public static void main(String[] args) {
        int M = 3, N = 5;
        System.out.println( getCount(M, N));
    }
}
