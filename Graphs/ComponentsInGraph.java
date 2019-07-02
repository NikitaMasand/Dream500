// the number of vertices in the smallest and the largest components.

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the componentsInGraph function below.
     */
    static int[] componentsInGraph(int[][] gb) {
        int n = gb.length;
        int arr[] = new int[2*n+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
        for(int i=0;i<n;i++){
            int temp[] = gb[i];
            union(arr,temp[0],temp[1]);
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<-1){
                min=Math.min(min,arr[i]);
                max=Math.max(max,arr[i]);
            }
        }
        int minmax[] = {Math.abs(max),Math.abs(min)};

        return minmax;


    }
     public static int findParentIndex(int[] arr, int x){
        if(arr[x]<0){
            return x;
        }
        return findParentIndex(arr,arr[x]);
    }


    public static void union(int arr[], int x, int y){
        if(findIfCycle(arr,x,y)){
            return;
        }
        int px = findParentIndex(arr,x);
        int py = findParentIndex(arr,y);
        if(Math.abs(arr[px])>=Math.abs(arr[py])){
            arr[px]+=arr[py];
            for(int i=1;i<arr.length;i++){
                if(arr[i]==py){
                    arr[i]=px;
                }
            }
            arr[py] = px;

        }
        else{
            arr[py]+=arr[px];
            for(int i=1;i<arr.length;i++){
                if(arr[i]==px){
                    arr[i]=py;
                }
            }
            arr[px] = py;
        }
    }


     public static boolean findIfCycle(int[] arr, int x, int y){
        if(findParentIndex(arr,x)==findParentIndex(arr,y)){
            return true;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] SPACE = componentsInGraph(gb);

        for (int SPACEItr = 0; SPACEItr < SPACE.length; SPACEItr++) {
            bufferedWriter.write(String.valueOf(SPACE[SPACEItr]));

            if (SPACEItr != SPACE.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
