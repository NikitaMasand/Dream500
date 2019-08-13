/*package whatever //do not write package name here */
/*
Given a string, find the longest substring which is palindrome.
For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String s = br.readLine();
	        System.out.println(findLPS(s));
	    }
	}
	
	public static String findLPS(String s){
	    int n = s.length();
	    boolean[][] lps = new boolean[n][n];
	    int max_length = 1;
	    int palindromeBeginsAt = 0;
	    //length 1 are all palindromes
	    for(int i=0; i<n; i++){
	        lps[i][i] = true;
	    }
	    
	    //checking for length 2 palindromes
	    for(int i=0; i<n-1; i++){
	        if(s.charAt(i)==s.charAt(i+1)){
	            lps[i][i+1]=true;
	            if(max_length!=2){
    	            max_length = 2;
    	            palindromeBeginsAt = i;
	            }
	        }
	    }
	    
	    //for lengths 3 to n
	    for(int curr_length = 3; curr_length<=n; curr_length++){
	        for(int i=0; i<n-curr_length+1;i++){
	            int j = i+curr_length-1; 
	            if(s.charAt(i)==s.charAt(j) && lps[i+1][j-1]==true){
	                lps[i][j]=true;
	                if(curr_length>max_length){
    	                palindromeBeginsAt = i;
    	                max_length = curr_length;
	                }
	            }
	        }
	    }
	    
	   return s.substring(palindromeBeginsAt,palindromeBeginsAt+max_length); 
	}
}
