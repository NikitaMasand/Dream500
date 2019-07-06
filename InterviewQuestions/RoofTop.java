/*
You are given heights of consecutive buildings. You can move from the roof of a building to the roof of next adjacent building.
You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude.
*/


package Searching;

import java.io.IOException;

public class RoofTop{

    public static void main(String[] args) throws IOException {
        int arr[] = {2412,4504,8590,4013,8148,9957,3022,8548,487,5820,2640,5291,9848,2838,4232,9566,4948,1723,2309,3301,7562,3097,2208,8489,7757,4396,9456,8078,6212,270,2131,6101,1187,7418,6548,2254,6459,9631,3044,4790,3117,3868,7830,9612,2498,3600,8947,2729,9743,1371,9195,7882,7446,8559,6585,1062,6712,6631,3341,8907,8571,870,7757};
            System.out.println(maxStep(arr, arr.length));
        }


    static int maxStep(int arr[], int n) {
        int currentCount=0;
        int maxCount=0;
        for(int i=0;i<n-1;i++) {
            if(arr[i]<arr[i+1]) {
                currentCount++;
            }
            else {
                if(currentCount>=maxCount ){
                    maxCount=currentCount;
                }
                currentCount=0;
            }
        }
        return  Math.max(currentCount,maxCount);


    }
}
