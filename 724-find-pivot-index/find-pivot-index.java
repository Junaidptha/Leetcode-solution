class Solution {
    public int pivotIndex(int[] nums) {
        int tsum = 0;
        for( int i = 0; i < nums.length; i++){
            tsum += nums[i];
        }
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(prefixSum == tsum - nums[i] - prefixSum){
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }
}