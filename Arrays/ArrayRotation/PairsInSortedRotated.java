
/*have to work on duplicate elements present case*/

public class PairsInSortedRotated
{
	public static void main(String[] args) {
	    int arr[]=new int[]{11,15,6,7,9,10};
		System.out.println(pairsInSortedRotated(arr,16,6));
	}
	public static int pairsInSortedRotated(int arr[],int sumCheck, int n){
	    //finding the largest element 
	    int i;
	    for(i=0;i<n-1;i++){
	        if(arr[i]>arr[i+1])
	        break;
	    }
	   // 11, 15, 6, 8, 9, 10
	   //here l = 2 and r = 1
	    //this is the minimum element index
	    
	    int low = (i+1)%n;
	    int high = i; // the maximum element index
	    
	    int count = 0;
	    while(low!=high)
	    {
	        if(arr[low]+arr[high]==sumCheck)
	            {
	                count++;
	                System.out.println("(" + arr[low] + "," + arr[high] + ")");
	                if(low == (n+high-1)%n)
	                    return count;
	                low = (low+1)%n;
	                high = (n+high-1)%n;
	            }
	       else if(arr[low]+arr[high]<sumCheck)
	       {
	           low = (low+1)%n;
	       }
	       else
	       {
	           high = (n+high-1)%n;
	       }
	    }
	    return count;
	}
}
