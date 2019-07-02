package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import static Graphs.UnionFind.DisjoinUnionEfficient.findParentIndex;
import static Graphs.UnionFind.DisjoinUnionEfficient.union;

public class KruskalsMST {
    static class Edge{
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight){
            this.source=source;
            this.destination=destination;
            this.weight=weight;
        }
    }
    static class Graph{
        int vertices;
        ArrayList<Edge>allEdges = new ArrayList<>();
        public Graph(int vertices){
            this.vertices=vertices;
        }
        public void addEdge(int source, int destination, int weight){
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }
        public void kruskalsMST(){
  //min heap made according to the weight of edges to get the min wt first
            PriorityQueue<Edge> pq = new PriorityQueue<>(
                    allEdges.size(), Comparator.comparingInt(o->o.weight));
            for(int i=0;i<allEdges.size();i++){
                pq.add(allEdges.get(i));
            }
            int parent[] = new int[vertices];
            makeSet(parent);
            ArrayList<Edge> mst = new ArrayList<>();
            int index = 0;
            while (index<vertices-1){
                Edge edge = pq.remove();
                int x_parent = findParentIndex(parent,edge.source);
                int y_parent = findParentIndex(parent,edge.destination);
                if(x_parent==y_parent){

                }
                else {
                    mst.add(edge);
                    union(parent,edge.source,edge.destination);
                    index++;
                }
            }
            //printing mst:
            System.out.println("Minimum Spanning Tree: ");
            printGraph(mst);
        }

        public void printGraph(ArrayList<Edge>mst){
            int weight = 0;
            for(int i=0;i<mst.size();i++){
                Edge edge = mst.get(i);
                weight+=edge.weight;
                System.out.println("Edge: "+i+" Source: "
                        +edge.source+" Destination: "+edge.destination
                +" Weight: "+edge.weight);
            }
            System.out.println("Weight of MST: "+weight);
        }

        public void makeSet(int[] parent){
            //make-set: initialize each vertex as parent of itself
            for(int i=0;i<parent.length;i++){
                parent[i]=-1;
            }
        }
    }
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.kruskalsMST();
    }
}
