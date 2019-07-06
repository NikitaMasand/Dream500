package Searching;
/*
You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
*/
public class SmallestPositiveMissing {
    public static void main(String[] args) {
        int[] arr = {0,-10,1,3,-20};
        System.out.println(missingNumber(arr,arr.length));
    }
    static int missingNumber(int arr[], int size)
    {
        boolean containsOne=false;
        for(int i=0;i<size;i++){
            if(arr[i]==1)
                containsOne=true;
            if(arr[i]>size || arr[i]<=0){
                arr[i]=1;
            }
        }
        if(containsOne==false)
            return 1;
        for(int i=0;i<size;i++){
            if(Math.abs(arr[i])==size){
                arr[0]=-1*Math.abs(arr[0]);
            }
            else{
                arr[Math.abs(arr[i])] = -1 * Math.abs(arr[Math.abs(arr[i])]);
            }
        }
        for(int i=1;i<size;i++){
            if(arr[i]>0){
                return i;
            }
        }
        return arr[0]<0 ? size+1 : size;

    }

}
