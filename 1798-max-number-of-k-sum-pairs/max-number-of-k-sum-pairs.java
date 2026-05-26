class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int x : nums) {
            int need = k - x;
            if (map.getOrDefault(need, 0) > 0) {
                count++;
                map.put(need, map.get(need) - 1);
            } else {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        return count;
    }
}