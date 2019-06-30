public class SearchTwoElements {
    public static void searchTwoRepeatedElements(int arr[], int n){
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[Math.abs(arr[i])-1]>0){
                arr[Math.abs(arr[i])-1]*=-1;
            }
            else{
                if(count==0)
                    System.out.print(Math.abs(arr[i])+" ");
                else
                    System.out.print(Math.abs(arr[i]));
                count++;
            }
            if(count==2){
                return;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {12, 5, 15, 17, 4, 1, 2, 9, 13, 16, 3, 7, 6, 10, 14, 11, 4, 19, 8, 18, 2};
        searchTwoRepeatedElements(arr,arr.length);
    }
}
