/*
Given a square grid of size N,
each cell of which contains integer cost which represents a cost to traverse through that cell,
we need to find a path from top left cell to bottom right cell by which total cost incurred is minimum.

Note : It is assumed that negative cost cycles do not exist in input matrix.
*/
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
class Cell{
    int x;
    int y;
    int dist;

    Cell(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[][] mat = new int[n][n];
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j] = Integer.parseInt(input[c]);
                    c++;
                }
            }
            System.out.println(findShortestPath(mat,n));
        }
    }

    public static boolean isInsideGrid(int x, int y, int n){
        return x>=0 && x<n && y>=0 && y<n;
    }
    public static int findShortestPath(int[][]grid, int n){
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0]=grid[0][0];
        int[] xd = {-1,0,1,0};
        int[] yd = {0,1,0,-1};

        List<Cell> q = new LinkedList<>();
        q.add(new Cell(0,0,dist[0][0]));

        while(!q.isEmpty()){
            Cell temp = q.remove(0);

            for(int i=0;i<4;i++){
                for(int j=0; j<4; j++){
                    int x = temp.x + xd[i];
                    int y = temp.y + yd[i];

                    if(!isInsideGrid(x,y,n)){
                        continue;
                    }
                    int dis = dist[temp.x][temp.y] + grid[x][y];
                    if(dist[x][y] > dis){
                        if(dist[x][y]!=Integer.MAX_VALUE){
                            for(int z=0; z<q.size(); z++){
                                if(q.get(z).dist==dist[x][y]){
                                    q.remove(z);
                                }
                            }
                        }
                        dist[x][y] = dis;
                        q.add(new Cell(x,y,dis));
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }
}
