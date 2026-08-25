class Solution {
    public int missingMultiple(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num % k == 0) set.add(num);
        }
        
        for(int i = 1; i <= set.size() + 1; i++){
            if(!set.contains(k * i)) return k * i;
        }

        return -1;
    }
}