package Graphs;
//adjacency list representation for an undirected graph

//space: O(e)...sparse graphs: e<<<v*v
//time to find adjacent nodes: O(v)
//time to find if nodes are connected or not: O(v)
//time to add/delete an edge: O(v)
import java.util.LinkedList;

public class AdjacencyListRepresentation {
   static class Graph {
        int vertices;
        //an array of references to linked lists
        LinkedList<Integer> adjListArray[];

        //constructor
        Graph(int vertices) {
            this.vertices = vertices;

            //defining the size of array as number of vertices
            adjListArray = new LinkedList[vertices];

            //creating a new list for each vertex
            //such that adjacent nodes can be stored
            for (int i = 0; i < vertices; i++) {
                adjListArray[i] = new LinkedList<>();
            }
        }
    }
        static void addEdge(Graph graph, int src, int dest) {
            //adding an edge from src to destination
            graph.adjListArray[src].add(dest);
            //for an undirected graph add edge from dest to src as well
            graph.adjListArray[dest].add(src);
        }

        static void printGraph(Graph graph) {
            System.out.println("Adjacency list representation of the graph: ");
            for (int i = 0; i < graph.vertices; i++) {
                System.out.println("Adjacency list of vertex " + i);
                System.out.print("head");
                for (int element : graph.adjListArray[i]) {
                    System.out.print(" -> " + element);
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            int v = 5;
            Graph graph = new Graph(v);
            addEdge(graph, 0, 1);
            addEdge(graph, 0, 4);
            addEdge(graph, 1, 2);
            addEdge(graph, 1, 3);
            addEdge(graph, 1, 4);
            addEdge(graph, 2, 3);
            addEdge(graph, 3, 4);

            printGraph(graph);
        }
    }
