//Time complexity O(n+klogn)
//using minHeap
// poll,peek,add methods are implemented in the MinheapImplementation file in the heaps package


public class FindingkthSmallest{
public void buildHeapFromArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            add(arr[i]);
        }
    }
    
    //finds kth smallest element by extracting minimum k-1 times
    public int findKthSmallestElement(int k){
        if(k==0 || k>size)
            throw new IllegalStateException();
        for(int i=0;i<k-1;i++){
            poll();
        }
        return peek();
    }




    public static void main(String[]args){
        Main heap = new Main();
        int arr[] = new int[]{12,3,5,7,19};
        heap.buildHeapFromArray(arr);
        int k = 2;
        System.out.println(k+"th/rd/nd smallest element is: " + heap.findKthSmallestElement(2));
        
    }

}
