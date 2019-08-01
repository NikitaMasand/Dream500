/*ArrayList<ArrayList<Integer>> list: represent graph containing vertices
                                    and edges between them
*vis[]: boolean array to represent visited vertex
*s: starting vertex 
*/
class Traversal
{
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
