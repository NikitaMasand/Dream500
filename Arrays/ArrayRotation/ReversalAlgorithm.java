
import java.util.Arrays;

public class ReversalAlgorithm{
    public static void main(String[] args)
    {
        int[] arr = new int[]{ 1,2,3,4,5,6,7}; 
        Main.leftrotate(arr,9,7);
        System.out.println(Arrays.toString(arr));
    }
    
    
    
    public static void leftrotate(int arr[],int k, int n)
    {
       if(k>n)
        k=k%n;
       reverseArray(arr,0,k-1);
       reverseArray(arr,k,n-1);
       reverseArray(arr,0,n-1);
    } 
    public static void reverseArray(int arr[],int start, int end)
    {
        int temp;
        while(start<end)
        {
            temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

}
