
public class Main
{
	public static void main(String[] args) {
		int arr[] = new int[]{2, 1, 5, 6, 3};
		System.out.println(minSwap(arr,3));
		int arr1[] = new int[]{2, 7, 9, 5, 8, 7, 4};
		System.out.println(minSwap(arr1,5));
	}
	public static int minSwap(int arr[],int k){
	    int n = arr.length;
	    int count=0;
	    for(int i=0;i<n;i++){
	        if(arr[i]<=k)
	            count++;
	    }
	   int bad = 0;
	   for(int i=0;i<count;i++)
	   {
	       if(arr[i]>k)
	        bad++;
	   }
	   int ans =bad;
	   for(int i=1,j=count; j<n; i++,j++){
	       if(arr[i-1]>k)
	            bad--;
	       if(arr[j]>k)
	            bad++;
	       ans = Math.min(ans,bad);
	   }
	   return ans;
	}
}
