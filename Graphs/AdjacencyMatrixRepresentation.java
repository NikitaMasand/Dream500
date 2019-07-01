package Graphs;
/*
O(v*v)space
time to find adjacent nodes: O(v)
time to find if nodes are connected or not: O(1)
time to add/delete an edge: O(1)
 */
import java.util.Scanner;

public class AdjacencyMatrixRepresentation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices in graph: ");
        int vertices = sc.nextInt();
        System.out.println("Enter number of edges in graph: ");
        int edges = sc.nextInt();
        boolean directed = false;

        System.out.println("Is the graph directed? Enter Y or N");
        String isDirected = sc.next().trim();
        if(isDirected.equals("Y"))
            directed=true;
        int matrix[][] = createAdjacencyMatrix(vertices,edges,directed);
        System.out.println("Graph is represented as: ");
        printMatrix(matrix);

    }

    public static int[][] createAdjacencyMatrix(int vertices, int edges, boolean isDirected){
        int matrix[][] = new int[vertices][vertices];
        int u,v;
        Scanner sc = new Scanner(System.in);
        for(int i=1;i<=edges;i++){
            System.out.println("Enter edge no: ");
            int edge = sc.nextInt();
            System.out.println("From: ");
            u = sc.nextInt();
            System.out.println("To: ");
            v = sc.nextInt();
            matrix[u][v]=1;
            if(isDirected==false){
                matrix[v][u]=1;
                System.out.println("hi");
            }

        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            System.out.print("vertex "+ i+" ");
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
