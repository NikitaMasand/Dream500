/*
You are working at the cash counter at a fun-fair, and you have different types of coins available to you in infinite quantities.
The value of each coin is already given. Can you determine the number of ways of making change for a particular number of units
using the given types of coins?

For example,
if you have 4 types of coins, and the value of each type is given as  8,3,1,2 respectively,
you can make change for 3 units in three ways: 1,1,1; 1,2; 3
It was an observation based approach on the basis of table.
Basically if you want to make 6 from 1,2,3, you will add the number of ways to make 6 using 1,2
plus the number of ways to make 6-3 from 1,2,3 which might already be calculated.
The 0th row elements are always 0 because you will have to add previous row elements for every coin,
so for first row previous will be 0. And the 0th column elements will be 1
because when you want to find ways to make 3, of 1,2,3..you will also have to consider one way when 3-3=0
i.e 3 can be made from 3 itself obviously, so that is one way.
*/

package DynamicProgramming;

import java.io.*;
import java.util.*;

public class coinChangeProblem {

    // Complete the getWays function below.
    static long getWays(int n, int[] c) {
        Arrays.sort(c);
        long T[][] = new long[c.length+1][n+1];
        for(int j=0; j<T[0].length;j++){
            T[0][j] = 0;
        }
        for(int i=0;i<T.length; i++){
            T[i][0] = 1;
        }
        for(int i=1;i<T.length;i++){
            for(int j=1;j<T[0].length;j++){
                if(c[i-1]>j){
                    T[i][j] = T[i-1][j];
                }
                else{
                    T[i][j] = T[i-1][j] + T[i][j-c[i-1]];
                }
            }
        }
        return T[T.length-1][n];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
