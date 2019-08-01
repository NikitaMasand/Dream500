class Traversal
{
    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {
        
       vis[src] = true;
       System.out.print(src+" ");
       int x = list.get(src).size();
       for(int i=0; i<x;i++){
           int ele = list.get(src).get(i);
           if(!vis[ele]){
               vis[ele]=true;
               dfs(ele,list,vis);
           }
       }
       
       
    }
}
