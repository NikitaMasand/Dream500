/*
Given a string consisting of lowercase English letters and spaces
(may or may not be multiple spaces). Your task is to print first letter of every word in the string.
*/
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0){
		    String input = br.readLine().trim();
		    
		    boolean include = true;
		    
		    for(int i=0; i<input.length(); i++){
		        if(input.charAt(i)!=' ' && include==true){
		            System.out.print(input.charAt(i));
		            include = false;
		        }
		        
		        else if(input.charAt(i)==' '){
		            include = true;
		        }
		    }
		    System.out.println();
		}
	}
}
