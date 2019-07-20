package GFGContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KthMaximumHeapElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            String input[] = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            int arr[] = new int[n];
            String arrele[] = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(arrele[i]);
            }
            if(n==1){
                System.out.println(arr[0]);
            }
            else if(n==2){
                if(k==1){
                    System.out.println(Math.max(arr[0],arr[1]));
                }
                else{
                    System.out.println(Math.min(arr[0],arr[1]));
                }
            }
            else {
                System.out.println(kthLargest(arr, n, k));
            }
        }
    }

    public static int kthLargest(int[] arr, int n, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k+1);
        for(int i=0;i<=k;i++){
            if(i==n){
                return minHeap.poll();
            }
            minHeap.add(arr[i]);
        }
        for(int i = k+1; i<n;i++){
            minHeap.poll();
            minHeap.add(arr[i]);
        }
        minHeap.poll();
        return minHeap.poll();
    }
}
