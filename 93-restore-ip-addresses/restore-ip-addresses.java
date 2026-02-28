class Solution {
    List<String> ans = new ArrayList<>();
    public void helper(String s, int idx , List<String> temp){
        if(temp.size() == 4){
            if(idx == s.length()){
                ans.add(String.join(".", temp));
            }
            return;   
        }
        for(int len = 1; len <= 3; len++){
            if(idx + len > s.length()) break;

            String part = s.substring(idx, idx + len);

            if(part.length() > 1 && part.charAt(0) == '0') continue;

            if(Integer.parseInt(part) > 255) continue;

            temp.add(part);
            helper(s, idx + len, temp);
            temp.remove(temp.size() - 1);
        }
        
    }
    public List<String> restoreIpAddresses(String s) {
        helper(s, 0, new ArrayList<>());
        return ans;
    }
}