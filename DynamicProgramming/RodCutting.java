package DynamicProgramming;
/*
Q: Find max no of pieces obtained after cutting rod of given length,
each piece’s length can be either a, b, c
 */
public class RodCutting {
    public static void main(String[] args) {
        System.out.println(RodCuttingRecursive.getMaxPieces(25,11,12,13));
        System.out.println(RodCuttingDP.getMaxPieces(5,1,2,3));
    }
}
class RodCuttingRecursive{
    public static int getMaxPieces(int n, int a, int b, int c){
        if(n<0){
            return -1;
        }
        if(n==0){
            return 0;
        }
        int na = getMaxPieces(n-a,a,b,c);
        int nb = getMaxPieces(n-b,a,b,c);
        int nc = getMaxPieces(n-c,a,b,c);

        int res = Math.max(na,Math.max(nb,nc));
        if(res==-1)
            return res;
        else{
            return res+1;
        }

    }
}
class RodCuttingDP{
    public static int getMaxPieces(int n, int a, int b, int c){
        int[] arr = new int[n+1];
        arr[0]=0;
        for(int i=1;i<=n;i++){
            arr[i] = -1;
        }
        for(int i=1;i<=n;i++){
            if(i-a>=0){
                if(arr[i-a]!=-1)
                    arr[i]=Math.max(arr[i],1+arr[i-a]);
            }
            if(i-b>=0){
                if(arr[i-a]!=-1)
                    arr[i]=Math.max(arr[i],1+arr[i-b]);
            }
            if(i-c>=0){
                if(arr[i-a]!=-1)
                    arr[i]=Math.max(arr[i],1+arr[i-c]);
            }
        }
        return arr[n];

    }
}
