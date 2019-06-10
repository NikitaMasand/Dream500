/*
given a rope of length n and three values a,b,c. We need to make max no. of pieces such that
every piece had length in set a,b,c
 */

public class getMaxPieces {
    public static void main(String[] args) {
        System.out.println(getMax(5,1,2,3));
        System.out.println(getMax(23,9,11,12));
        System.out.println(getMax(5,2,4,6));
    }
    public static int getMax(int n, int a, int b, int c){
        if(n<0)
            return -1;
        if(n==0)
            return 0;
        int CA = getMax(n-a,a,b,c);
        int CB = getMax(n-b,a,b,c);
        int CC = getMax(n-c,a,b,c);
        int res = Math.max(Math.max(CA,CB),CC);
        if(res==-1)
            return -1;
        return res+1;
    }
}
/*
Time complexity
T(n) = T(n-a) + T(n-b) + T(n-c) + c1
O(3^n)

 */
