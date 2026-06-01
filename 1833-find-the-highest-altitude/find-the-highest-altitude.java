class Solution {
    public int largestAltitude(int[] gain) {
        int high = 0;
        int tsum = 0;
        for(int i = 0; i < gain.length; i++){
            tsum += gain[i];
            high = Math.max(high, tsum);
        }
        return high;
    }
}