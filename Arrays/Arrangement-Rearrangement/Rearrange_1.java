import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        int arr[]=new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
        int arr1[] = new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
              11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        rearrange(arr1);
        System.out.println(Arrays.toString(arr1));
    }
    public static void rearrange(int arr[]){
        for(int i=0;i<arr.length;){
            if(arr[i]>=0 && arr[i]!=i){
                int ele = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = ele;
            }
            else{
                i++;
            }
        }
    }
}
