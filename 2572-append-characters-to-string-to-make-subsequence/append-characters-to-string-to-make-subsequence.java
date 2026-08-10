class Solution {
    public int appendCharacters(String s, String t) {
        int c = 0;
        for(int i = 0; i < s.length() && c < t.length(); i++){
            char curr = t.charAt(c);
            if(curr == s.charAt(i)) c++;
        }
        
        return t.length() - c;
    }
}