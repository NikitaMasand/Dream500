public class InfiniteSearch {
    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int ans  = findPos(arr,10);
        if(ans==-1)
            System.out.println("Element not found");
        else
            System.out.println("element found at index :" + ans);
    }
    public static int binarySearch(int arr[],int l, int r, int x) {
        if (r >= l) {
            int mid = (l + r) / 2;
            if(arr[mid]==x)
                return mid;
            else if(arr[mid]<x)
                return binarySearch(arr,mid+1,r,x);
            else
                return binarySearch(arr,l,mid-1,x);
        }
        return -1;
    }

    public static int findPos(int arr[],int x){
        int l = 0, h =1;
        int val = arr[0];
        while(val<x){
            l = h;
            // checks that h does not exceed range
            //prevents array index out of bound exception
            
            if(2*h <arr.length-1)
                h = 2*h;
            else
                h = arr.length-1;
            val = arr[h];
        }

        return binarySearch(arr,l,h,x);
    }
}

