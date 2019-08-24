//https://www.hackerrank.com/challenges/the-quickest-way-up/problem

public class Solution {
    static class Pair{
        int v;
        int dist;
    }
    // Complete the quickestWayUp function below.
    static int quickestWayUp(int[][] ladders, int[][] snakes) {
            int board[] = new int[101];
            for(int i=0; i<board.length; i++){
                board[i]=-1;
            }
            for(int i=0; i<ladders.length;i++){
                    int src = ladders[i][0];
                    int dest = ladders[i][1];

                    board[src] = dest;
            }

            for(int i=0; i<snakes.length; i++){
                    int src = snakes[i][0];
                    int dest = snakes[i][1];

                    board[src] = dest;
            }

            return quickestWayUpUtil(board,101);

    }

    public static int quickestWayUpUtil(int[] board, int n){
        boolean[] visited = new boolean[n];
        Queue<Pair>q = new LinkedList<>();
        Pair p = new Pair();
        p.v = 1;
        p.dist = 0;
        q.add(p);
        visited[1] = true;

        while(!q.isEmpty()){
            p = q.poll();
            int v = p.v;

            if(v==100){
                break;
            }
            for(int j=v+1; j<=v+6 && j<=100; j++){
                if(!visited[j]){
                    Pair x = new Pair();
                    x.dist = p.dist+1;
                    visited[j]=true;

                    if(board[j]!=-1){
                        x.v = board[j];
                    }
                    else{
                        x.v = j;
                    }

                    q.add(x);
                }
            }
        }

        return p.v==100 ? p.dist : -1;

    }
