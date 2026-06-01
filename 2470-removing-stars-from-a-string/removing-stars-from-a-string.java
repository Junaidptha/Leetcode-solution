class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == '*') start++;
            else if(start > 0) {
                start--;
            }else {
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
}