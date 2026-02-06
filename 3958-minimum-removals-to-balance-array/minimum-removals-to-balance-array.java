class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int maxw = 1;
        int l = 0;

        for(int r = 0; r < n; r++){
            while((long)nums[r] > (long) nums[l] * k){
                l++;
            }
            maxw = Math.max(maxw, r - l + 1);
        }
        return n - maxw;
    }
}