class Solution {
    public int maximumLengthSubstring(String s) {
        int freq[] = new int[26];
        int l = 0;
        int maxLen = 0;

        for(int r = 0; r < s.length(); r++){
            char curr = s.charAt(r);

            freq[curr - 'a']++;

            while(freq[curr - 'a'] > 2){
                freq[s.charAt(l) - 'a']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}