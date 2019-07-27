/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n==1 || n==0){
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int lm = height[0];
        leftMax[0] = 0;
        for(int i=1;i<n;i++){
            leftMax[i] = lm;
            lm = Math.max(lm,height[i]);
        }
        int rm = height[n-1];
        rightMax[n-1]=0;
        for(int i=n-2;i>=0;i--){
            rightMax[i]=rm;
            rm = Math.max(rm,height[i]);
        }
        int amount = 0;
        for(int i=0;i<n;i++){
                amount += Math.min(leftMax[i],rightMax[i])-height[i] > 0 ? 
                        Math.min(leftMax[i],rightMax[i])-height[i] : 0;
        }
        return amount;
    }
}
