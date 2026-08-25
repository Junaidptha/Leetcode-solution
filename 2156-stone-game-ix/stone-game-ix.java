class Solution {
    public boolean stoneGameIX(int[] stones) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int stone : stones) {
            if (stone % 3 == 0) {
                count0++;
            } else if (stone % 3 == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        // 0 - 0
        // 1 - 2
        // 2 - 0

        // A - 1 
        // B - 1
    
        
        

        if(count1 == 0 && count2 == 0) return false;
        if(count0 % 2 == 0){
            return count1 > 0 && count2 > 0;
        }

        return Math.abs(count1 - count2) > 2;

    }
}