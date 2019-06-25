package DynamicProgramming.Atcoder_DPPractice;
/*
There are N stones, numbered 1,2..N. For each i btwn 1 to N the height of Stone i is hi.
There is a frog who is initially on Stone 1. He will repeat the following action some number of times to reach Stone N
If the frog is currently on Stone i, jump to one of the following: Stone i+1,i+2...i+k
Here, a cost of |hi-hj| is incurred, where j is the stone to land on.
Find the minimum possible total cost incurred before the frog reaches Stone N
 */
import java.util.Scanner;

public class Frog_2 {
    public static int findMinCost(int heights[],int k){
        int n = heights.length;
        int[] min = new int[n];
        min[0] = 0;
        min[1] = Math.abs(heights[1]-heights[0]);
        for(int i=2;i<n;i++){
            int temp;
            min[i] = Integer.MAX_VALUE;
            int count = k;
            for(int j=i-1;count-->0 && j>=0;j--){
                temp = Math.abs(heights[i]-heights[j])+min[j];
                min[i] = Math.min(temp,min[i]);
            }
        }
        return min[n-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int heights[] = new int[n];
        for(int i=0;i<n;i++){
            heights[i] = sc.nextInt();
        }
        System.out.println(findMinCost(heights,k));
    }
}
