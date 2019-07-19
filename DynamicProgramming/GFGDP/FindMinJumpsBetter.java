/*
Given an array of integers where each element represents the max number of steps that can be made forward from that element.
The task is to find the minimum number of jumps to reach the end of the array (starting from the first element).
If an element is 0, then cannot move through that element.
*/
package DynamicProgramming.GFGDP;
//using analogy of steps and ladder in O(n)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinJumpsReachEndBetter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr= new int[n];
            for(int i =0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            System.out.println(findMinJumps(arr));

        }
    }

    public static int findMinJumps(int[] arr){
        int n = arr.length;
        if(n<=1)
            return 0;
        if(arr[0]==0)
            return -1;
        int maxReach = arr[0];
        int steps = arr[0];
        //min 1 jump is required for more than 1 element
        int jumps = 1;

        for(int i=1;i<n;i++){
            //check if we have reached end of array
            if(i==n-1)
                return jumps;
            //update maxreach if current element can take farther than the current maxreach
            maxReach = Math.max(maxReach,i+arr[i]);
        //we used a step to get to the current index
            steps--;
        //if no steps are left
            if(steps==0){
                //we must have used the jump to the next big ladder
                jumps++;
                //check if we are at the max possible range
                //and no steps are there
                //then we return not possible
                if(i>=maxReach)
                    return -1;

                //reinitialize the steps to the amount of steps to reach maxreach
                //starting from position i;
                steps = maxReach-i;
            }
        }
        return -1;
    }
}
