class Solution {
    public void sortColors(int[] nums) {
        int t0 = 0;
        int t2 = nums.length - 1;
        int t1 = 0;

        while(t1 <= t2){
            if(nums[t1] == 0){
                swap(t0, t1, nums);
                t0++;
                t1++;
            } 
            else if(nums[t1] == 2){
                swap(t1, t2, nums);
                t2 --;

            }else{
                t1++;
            }
        }
    }
    public void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}