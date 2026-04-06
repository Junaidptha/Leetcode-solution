class Solution {
    public int removeDuplicates(int[] nums) {
        
        int start = 0;
        for(int end = 0; end < nums.length; end++){
            if(nums[start] != nums[end]) {
                start++;
                swap(start, end, nums);
            }
        }
        return start + 1;

    }
    public void swap(int i, int j, int[] nums){
        int temp = 0;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}