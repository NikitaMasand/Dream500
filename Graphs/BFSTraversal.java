/*ArrayList<ArrayList<Integer>> list: represent graph containing vertices
                                    and edges between them
*vis[]: boolean array to represent visited vertex
*s: starting vertex 
*/
class Traversal
{
  
  //for disconnected components in the graph, we make the boolean visited arr global and check if that vertex's boolean is false even 
  //after one complete bfs from source, that means that vertex is disconnected and there might be others as well. to handle this
  
  /*
  boolean visited[] = new visited[v];
    public static void mainBFS(){
      
      for(int i=0;i<v;i++){
        if(!visited[i]){
            BFS(i,list,visited);
        }
      }
    }
  
  */
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean visited[])
    {
       Queue<Integer> q = new LinkedList<>();
       q.add(s);
       visited[s] = true;
       
       while(!q.isEmpty()){
           int x = q.peek();
           q.poll();
           System.out.print(x+" ");
           for(int ele : list.get(x)){
               if(visited[ele]==false){
                   q.add(ele);
                   visited[ele]=true;
               }
           }
       }
       
       
       
    }
}
