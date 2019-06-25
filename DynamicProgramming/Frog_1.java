package DynamicProgramming.Atcoder_DPPractice;

import java.util.Scanner;

/*
There are
N stones, numbered 1,2,..N. For each i (1<=i<=N) the height of Stone i is hi.
There is a frog who is initially on Stone 1.
He will repeat the following action some number of times to reach Stone N
If the frog is currently on Stone i jump to Stone i+1 or stone i+2
Here, a cost of |hi-hj| is incurred, where jis the stone to land on.
Find the minimum possible total cost incurred before the frog reaches Stone N
 */
public class Frog_1 {
    public static int findMinCost(int[] heights){
        int n = heights.length;
        int min[] = new int[n];
        min[0] = 0;
        min[1] = Math.abs(heights[1]-heights[0]);
        for(int i=2;i<n;i++){
            min[i] = Math.min(Math.abs(heights[i]-heights[i-1])+min[i-1],
                                    Math.abs(heights[i]-heights[i-2])+min[i-2]);
        }
        return min[n-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int heights[] = new int[n];
        for(int i=0;i<n;i++){
            heights[i] = sc.nextInt();
        }
        System.out.println(findMinCost(heights));
    }
}
