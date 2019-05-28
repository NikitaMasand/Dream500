/*
https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

I have coded the functions climbLeaderboard and findClosest Number index functions 
Also, I have a doubt that in the implementation when I do low = mid-1 or high = mid+1, it works!
Initially I had done low=mid or high = mid instead but that is making the code to run in an infinite loop, 
I still could not understand this.
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
                      int n = scores.length;
            int ranks[] = new int[n];
            ranks[0]=1;
            for(int i=1;i<n;i++){
                if(scores[i]!=scores[i-1])
                    ranks[i]=ranks[i-1]+1;
                else
                    ranks[i]=ranks[i-1];
            }
            int aliceRank[]=new int[alice.length];
            for(int k=0;k<alice.length;k++)
            {
                
                int index = findClosestNumberIndex(scores,alice[k]);
                if(index!=-1)
                    aliceRank[k]=ranks[index];
                else
                    aliceRank[k]=ranks[n-1]+1;
            }
            return aliceRank;
    }
    static int findClosestNumberIndex(int scores[],int aliceScore){
        if(aliceScore>=scores[0])
            return 0;
        else if(aliceScore<scores[scores.length-1])
            return -1;
        else if(aliceScore==scores[scores.length-1])
            return scores.length-1;
        else{
        int high = 0;
        int low = scores.length-1;
        while(high<low){
        int mid = (low+high)/2;
        if(scores[mid]==aliceScore||scores[low]==aliceScore||scores[high]==aliceScore)
        {
            if(scores[mid]==aliceScore)
            return mid;
            if(scores[high]==aliceScore)
            return high;
            if(scores[low]==aliceScore)
            return low;
        }
        else if(scores[mid]>aliceScore)
            high = mid+1;
        else
            low = mid-1;
        }
        if(scores[high]<aliceScore)
            return high;
        else    
            return high+1;
        }
}
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
