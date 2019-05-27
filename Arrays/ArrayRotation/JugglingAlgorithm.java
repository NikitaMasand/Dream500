
import java.util.Arrays;

public class JugglingAlgorithm{
    public static void main(String[] args)
    {
        int[] arr = new int[]{ 1,2,3,4,5,6,7}; 
        Main.rotate(arr,2,7);
        System.out.println(Arrays.toString(arr));
    }
    
    
    
    public static void rotate(int arr[],int k, int n)
    {
        int sets = Main.gcd(n,k);
        for(int i=0;i<sets;i++)
        {
            int j = i;
            int temp = arr[i];
            while(true)
            {
                int d = (j+k)%n;
                if(d==i)
                    break;
                arr[j] = arr[d];
                j=d;
            }
            arr[j] = temp;
        }
    } 
    
    
    public static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
          
        return gcd(b%a, a); 
    } 
}
