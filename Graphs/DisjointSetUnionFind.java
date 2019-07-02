package Graphs.UnionFind;

public class DisjoinUnionEfficient {
    public static int findParentIndex(int[] arr, int x){
        if(arr[x]<0){
            return x;
        }
        return findParentIndex(arr,arr[x]);
    }
    public static void union(int arr[], int x, int y){
        if(findIfCycle(arr,x,y)){
            System.out.println("cycle is formed i.e. "+x+" & "+y+" belong to same set");
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


    public static void main(String[] args) {
        int n = 8;
        int arr[] = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=-1;
        }
        union(arr,1,2);
        union(arr,3,4);
        union(arr,5,6);
        union(arr,7,8);
        union(arr,2,4);
        union(arr,2,5);
        union(arr,1,3);
        union(arr,6,8);
        union(arr,5,7);
        for(int i=1;i<=n;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
