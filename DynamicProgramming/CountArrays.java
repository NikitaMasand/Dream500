/*
Your goal is to find the number of ways to construct an array such that consecutive positions contain different values.
Specifically, we want to construct an array with n elements such that each element between 1 and k inclusive.
We also want the first and last elements of the array to be 1 and x.
n=4,k=3,x=2
ans: 3
1 2 1 2
1 3 1 2
1 2 3 2
*/
package DynamicProgramming;

public class CountArrays {
    public static long countArrays(int n, int k, int x){
        int MOD = 1000000007;
        long[] endingWithX = new long[n];
        long[] notEndingWithX = new long[n];
        endingWithX[0] = x==1 ? 1:0;
        notEndingWithX[0] = x==1 ? 0:1;
        for(int i=1;i<n;i++){
            endingWithX[i]=(notEndingWithX[i-1])% MOD;
            notEndingWithX[i] = ((endingWithX[i-1]*(k-1)) + (notEndingWithX[i-1]*(k-2)))%MOD;
        }
        return endingWithX[n-1];

    }
    public static void main(String[] args) {
        System.out.println(countArrays(942,77,13));
    }
}
