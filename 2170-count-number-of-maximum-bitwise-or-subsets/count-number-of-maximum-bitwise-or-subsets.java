class Solution {
    int maxOr = 0;
    int count = 0;
    public void helper(int[] nums, int currOr, int idx){
        if(idx == nums.length){
            if(currOr == maxOr) count++;
            return;
        }
        helper(nums, currOr | nums[idx], idx + 1);

        helper(nums, currOr, idx + 1);
    }
    public int countMaxOrSubsets(int[] nums){
        for(int num: nums){
            maxOr |= num; 
        }
        helper(nums, 0, 0);
        return count;
    }
}