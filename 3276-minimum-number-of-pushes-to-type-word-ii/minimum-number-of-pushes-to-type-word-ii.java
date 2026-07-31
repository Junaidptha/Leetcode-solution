class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int press = 1;
        int count = 0;

        for(int i = freq.length - 1; i >= 0 && freq[i] > 0; i--){
            ans += freq[i] * press;
            count++;
            if(count == 8){
                press++;
                count = 0;
            }
        }
        return ans;

    }
}