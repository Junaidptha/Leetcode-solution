class Solution {
    public int lengthOfLongestSubstring(String s) {
        int arr[] = new int[256];

        int l = 0;
        int maxLen = 0;

        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            if(arr[ch] != 0 && arr[ch] >= l){
                l = arr[ch] ;
            }
            arr[ch] = r + 1;
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}