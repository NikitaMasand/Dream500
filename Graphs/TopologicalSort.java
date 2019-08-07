
//topological sort: time complexity : O(V+E)
class TopologicalSort
{
    static Stack<Integer> stack = new Stack<>();
    
    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N){
        
        
        
        boolean[] visited = new boolean[N];
        for(int i=0;i<N;i++){
            if(!visited[i]){
                DFSUtil(i, list, visited);
            }
        }
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = stack.pop();
        }
        return arr;
    }
    
    static void DFSUtil(int i, ArrayList<ArrayList<Integer>> list, boolean[] visited){
        
        visited[i]=true;
       
        for(int k: list.get(i)){
            if(!visited[i]){
                DFSUtil(k,list,visited);
            }
        }
        stack.push(i);
    }
   
    
}
