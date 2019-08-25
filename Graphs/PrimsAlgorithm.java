package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimsAlgorithmBasic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter vertices: ");
        int v = Integer.parseInt(br.readLine());
        System.out.println("Enter edges: ");
        int e = Integer.parseInt(br.readLine());

        int[][] adjMatrix = new int[v][v];
        for(int i=0;i<e;i++){
            int s,d,wt;
            System.out.println("Enter source: ");
            s = Integer.parseInt(br.readLine());
            System.out.println("Enter destination: ");
            d = Integer.parseInt(br.readLine());
            System.out.println("Enter weight: ");
            wt = Integer.parseInt(br.readLine());

            adjMatrix[s][d] = wt;
            adjMatrix[d][s] = wt;
        }

        prims(adjMatrix,v);
    }

    static void prims(int[][] adjMatrix, int v){
        int[] parent = new int[v];
        int[] weight = new int[v];
        boolean[] visited = new boolean[v];

        for(int i=0;i<v;i++){
            weight[i] = Integer.MAX_VALUE;
        }
        parent[0] = -1;
        weight[0] = 0;

        for(int i=0; i<v; i++){
            //find min vertex
            int minVertex = findMinVertex(weight, visited, v);
            visited[minVertex] = true;
            //explore unvisited vertices
            for(int j=0; j<v; j++){
                if(adjMatrix[minVertex][j]!=0 && !visited[j]){
                    if(adjMatrix[minVertex][j]<weight[j]){
                        weight[j] = adjMatrix[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }

        }

        for(int i=1; i<v; i++){
            if(parent[i]<i){
                System.out.println(parent[i]+" "+i+" "+weight[i]);
            }
            else{
                System.out.println(i+" "+parent[i]+" "+weight[i]);
            }
        }
    }


    static int findMinVertex(int[] weight, boolean[] visited, int v){
        int minVertex = -1;
        for(int i=0; i<v; i++){
            if(!visited[i] && (minVertex==-1 || weight[i]<weight[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }

}
