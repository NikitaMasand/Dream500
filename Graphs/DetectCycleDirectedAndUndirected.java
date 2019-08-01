package Graphs;

import java.util.ArrayList;

public class DetectCycleDirectedAndUndirected {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("contains cycle");
        else
            System.out.println("does not contain cycle");
    }
}
class Graph{
    private int v;
    private ArrayList<ArrayList<Integer>> list;
    public Graph(int v){
        this.v = v;

        list = new ArrayList<>();
        for(int i=0;i<v;i++){
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int dest){
        list.get(source).add(dest);
    }

    public boolean isCyclic(){
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];


        for(int i=0;i<v;i++){
            if(isCyclicUtil(i,visited,recStack))
                return true;
        }
        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack){
        if(recStack[i])
            return true;
        if(visited[i])
            return false;

        visited[i] = true;
        recStack[i] = true;

        ArrayList<Integer> children = list.get(i);
        for(Integer c: children){
            if(isCyclicUtil(c,visited,recStack))
                return true;
        }
        recStack[i]=false;
        return false;
    }

}
