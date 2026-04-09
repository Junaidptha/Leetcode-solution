class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majo = 0;
        for(int num : nums){
            if(count == 0) majo = num;
            if(num != majo ){
               count --;
            }else{
                count++;
            }
            
        }
        return majo;
    }
}