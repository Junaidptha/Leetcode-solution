class Solution {
    // Long ans = 0l;
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        if(i == s.length()) return 0;
        if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if(s.charAt(i)=='+'){
            i++;
        }
        while(i < s.length() && s.charAt(i) =='0') i++;
        // System.out.print(i +" "+ sign);
        return helper(s, 0l, i, sign);
    }
    public int helper(String s, Long ans ,int i, int sign){
        if(i == s.length() || !Character.isDigit( s.charAt(i) ) ) return (int) (sign * ans);
        ans = ans * 10 + (s.charAt(i) - '0');

        if(sign == 1 &&  ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sign == -1 &&  -ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        
        return helper(s, ans, i+1, sign);
    }
}