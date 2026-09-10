class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);
        int first = 0;
        int last = strs.length - 1;

        int idx = 0;

        while(idx < strs[first].length() && idx < strs[last].length() && strs[first].charAt(idx) == strs[last].charAt(idx)){
            idx++;
        }
        return strs[first].substring(0, idx);
    }
}