class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = getmax(piles);
        int low = 1;
        int count = 0;
        while(low < high){
            int mid = low + (high - low)/2;
            if(canDo(piles, h, mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public int getmax(int[] piles){
        int max = 0;
        for(int num: piles){
            max = Math.max(max, num);
          
        }
        return max;
    }
    public boolean canDo(int[] piles, int h, int k){
        int hours = 0;
        for(int num: piles){
            hours += (num + (k - 1))/k;
        }
        return hours <= h;
    }
}