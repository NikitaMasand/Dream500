public class Main{
    public static void main(String[] args){
        int arr[] = new int[]{1,3,5,7,9};
        quickPrintLeftRotate(arr,2);
        quickPrintLeftRotate(arr,3);
        quickPrintLeftRotate(arr,4);
    }
    public static void quickPrintLeftRotate(int arr[],int k){
        int n = arr.length;
        for(int i=k;i<k+n;i++){
            System.out.print(arr[i%n]+" ");
        }
        System.out.println();
    }
}
