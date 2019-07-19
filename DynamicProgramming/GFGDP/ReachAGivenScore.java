/*
Consider a game where a player can score 3 or 5 or 10 points in a move.
Given a total score n, find number of distinct combinations to reach the given score.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
		    int score = Integer.parseInt(br.readLine());
		    System.out.println(getWays(score));
		}
	}
	
	public static int getWays(int score){
	    int[] ways = new int[score+1];
	    ways[0]=1;
	    int[] arr = {3,5,10};
	    for(int x: arr){
	        for(int i=1;i<=score;i++){
	            if(i>=x){
	                ways[i] += ways[i-x];
	            }
	        }
	    }
	    return ways[score];
	}
}
