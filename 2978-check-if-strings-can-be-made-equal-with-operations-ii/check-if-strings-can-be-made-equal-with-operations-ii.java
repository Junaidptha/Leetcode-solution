class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[][] cnt = new int[2][26];
        for (int i = 0; i < s1.length(); i++) {
            int parity = i % 2;
            cnt[parity][s1.charAt(i) - 'a']++;
            cnt[parity][s2.charAt(i) - 'a']--;
        }
        
        for (int p = 0; p < 2; p++) {
            for (int c = 0; c < 26; c++) {
                if (cnt[p][c] != 0) return false;
            }
        }
        return true;

    }
}