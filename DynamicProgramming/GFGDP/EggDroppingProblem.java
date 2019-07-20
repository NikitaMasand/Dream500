package DynamicProgramming.GFGDP;
/*
Suppose you have N eggs and you want to determine
from which floor in a K-floor building you can drop an egg such that it doesn't break.
You have to determine the minimum number of attempts you need
in order find the critical floor in the worst case while using the best strategy
There are few rules given below.

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
 */
public class EggDroppingProblem {

    public static int eggDrop(int e, int f){
        int[][] eggFloor = new int[e+1][f+1];
        int res;
        int i,j,k;

        for(i = 1; i<=e; i++){
            eggFloor[i][0] = 0;
            eggFloor[i][1] = 1;
        }
        for(j = 1; j<=f; j++){
            eggFloor[1][j] = j;
        }

        for(i = 2; i<=e; i++){
            for(j = 2; j<=f; j++){
                eggFloor[i][j] = Integer.MAX_VALUE;
                for(int x = 1; x<=j ;x++){
                    res = 1 + Math.max(eggFloor[i-1][x-1],eggFloor[i][j-x]);
                    eggFloor[i][j] = Math.min(res,eggFloor[i][j]);
                }
            }
        }
        return eggFloor[e][f];
    }
    public static void main(String[] args) {
        System.out.println(eggDrop(2,10));
    }
}
