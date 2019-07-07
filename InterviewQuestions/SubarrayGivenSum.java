package Searching;

import java.util.Arrays;

public class subarrayWithGivenSum {
    static void subarraySum(int n, int s, int[] arr) {


        if(arr[0]==s){
            System.out.println(1+" "+1);
            return;
        }
        int currSum = arr[0]+arr[1];
        if(currSum==s){
            System.out.println(1+" "+2);
            return;
        }
        int strtptr = 0;
        int endptr = 1;
        while (strtptr<n && endptr+1<n && strtptr<=endptr ){
            if(currSum+arr[endptr+1]<=s){

                currSum+=arr[endptr+1];
                endptr++;

            }
            else{

               currSum-=arr[strtptr];
                strtptr++;
                if(strtptr>endptr) {
                    endptr=strtptr;
                    currSum=arr[strtptr];
                }

            }
            if(currSum==s){
                System.out.println(strtptr+1+" "+(endptr+1));
                return;
            }


        }

        System.out.print(-1);
    }
    public static void main(String[] args) {
        int arr[] = {1,6,6};
        subarraySum(arr.length,13, arr);

    }
}
