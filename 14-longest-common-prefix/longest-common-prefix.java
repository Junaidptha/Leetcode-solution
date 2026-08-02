class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);

        int first = 0;
        int last = strs.length - 1;

        
        int i = 0;

        while(i < strs[first].length() && i < strs[last].length() && strs[first].charAt(i) == strs[last].charAt(i)) i++;

        return strs[first].substring(0, i);
    }
}