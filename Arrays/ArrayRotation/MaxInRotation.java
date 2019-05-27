
public class MaxInRotation
{
	public static void main(String[] args) {
	int arr[] = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	System.out.println(findMaxInRotation(arr));
	}
	public static int findMaxInRotation(int arr[]){
	    int currVal = 0;
	    int arrSum = 0;
	    int n = arr.length;
	    if (n==1)
	        return 0;
	    for(int i=0;i<n;i++)
	    {
	        currVal+=i*arr[i];
	        arrSum+=arr[i];
	        
	    }
	    int maxVal = currVal;
	    for(int i=1;i<n;i++)
	    {
	        currVal = currVal + arrSum - n*arr[n-i];
	        if(currVal>maxVal)
	            maxVal = currVal;
	    }
	    return maxVal;
	}
}
