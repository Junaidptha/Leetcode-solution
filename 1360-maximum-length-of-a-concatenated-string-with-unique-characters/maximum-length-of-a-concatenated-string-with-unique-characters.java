class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        helper(arr, "", 0);
        return max;
    }
    private void helper(List<String> arr, String current, int index) {
        if (!isUnique(current)) return;

        max = Math.max(max, current.length());

        for (int i = index; i < arr.size(); i++) {
            helper(arr, current + arr.get(i), i + 1);
        }
    }
    private boolean isUnique(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] > 0) return false;
            freq[c - 'a']++;
        }
        return true;
    }
}