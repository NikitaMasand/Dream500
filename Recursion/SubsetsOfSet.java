/*
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>(), output);
        return output;
    }
    
    public void helper(int[] nums, int currPos, List<Integer> currList, List<List<Integer>> output){
        if(currPos==nums.length){
            output.add(new ArrayList<>(currList));
            return;
        }
        
        //not taking current number in the subset
        helper(nums,currPos+1,currList,output);
        
        //taking current number in the subset
        List<Integer> newList = new ArrayList<>();
        newList.addAll(currList);
        newList.add(nums[currPos]);
        helper(nums,currPos+1,newList,output);
    }
}
