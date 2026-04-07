class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int idx = 0;
        int msum = 0;
        int csum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                csum++;
            }else{
                idx = i + 1;
                csum = 0;
            }
            msum = Math.max(csum, msum);
        }
        return msum;
    }
}