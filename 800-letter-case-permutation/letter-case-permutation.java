class Solution {
    List<String> result = new ArrayList<>();
    public void helper(String s, int index,  String current){
        if(index == s.length()){
            result.add(current);
            return;
        }
        char ch = s.charAt(index);
        if (Character.isDigit(ch)) {
            helper(s, index + 1, current + ch);
        } 
        
        else {
            helper(s, index + 1, current + Character.toUpperCase(ch));
            helper(s, index + 1, current + Character.toLowerCase(ch));

        }
    }
    public List<String> letterCasePermutation(String s) {
        helper(s, 0, "");
        return result;
    }
}