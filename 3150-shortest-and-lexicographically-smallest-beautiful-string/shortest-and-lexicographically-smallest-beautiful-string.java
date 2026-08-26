class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0, right = 0, ones = 0;
        String ans = "";

        while (right < n) {
            while (right < n && ones < k) {
                if (s.charAt(right) == '1') {
                    ones++;
                }
                right++;
            }
            if (ones < k) {
                break;
            }

            while (left < right && s.charAt(left) == '0') {
                left++;
            }

            String curr = s.substring(left, right);
            if (ans.equals("") 
                    || curr.length() < ans.length() 
                    || (curr.length() == ans.length() 
                    && curr.compareTo(ans) < 0)) {

                ans = curr;
            }
            
            if (s.charAt(left) == '1') {
                ones--;
                left++;
            }
        }
        return ans;
    }
}