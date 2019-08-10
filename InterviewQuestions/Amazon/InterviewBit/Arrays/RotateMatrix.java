/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note that if you end up using an additional array, you will only receive partial score.

score: 242/300...
why less? because I didn't know of swapping of two elements in an array list, so got to know about set method
*/

public class Solution {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    int n = a.size();
	    for(int i=0; i<n; i++){
	        for(int j=0; j<i;j++){
	            int temp = a.get(i).get(j);
                a.get(i).set(j,a.get(j).get(i));
                a.get(j).set(i,temp);
	        }
	    }
	    
	    for(int i=0; i<n; i++){
	        for(int j=0; j<n-j-1;j++){
	            int temp = a.get(i).get(j);
	            a.get(i).set(j,a.get(i).get(n-j-1));
	            a.get(i).set(n-j-1,temp);
	        }
	    }
	}
}
