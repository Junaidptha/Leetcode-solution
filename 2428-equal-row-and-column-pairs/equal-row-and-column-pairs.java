class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                boolean same = true;

                for (int k = 0; k < grid.length; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        same = false;
                        break;
                    }
                }
                if(same) count++;
            }
        }
        return count;
    }
}