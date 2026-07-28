class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        n = n / 2;
        
        
        String firstHalf = s.substring(0, n);

        char[] arr = firstHalf.toCharArray();

        Arrays.sort(arr);

        firstHalf = new String(arr);

        String mid = "";

        if(s.length() % 2 != 0){
            mid = s.substring(n, n+1);
        }
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();

        if (mid.equals(""))
            return firstHalf.toString() + secondHalf;


        return firstHalf.toString()+ mid + secondHalf;

    }
}