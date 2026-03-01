class Solution {
    boolean visited[][];
    int maxGold;
    public void helper(int[][] grid, int row, int col, int currGold){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if(grid[row][col] == 0 || visited[row][col]) return ; 
        visited[row][col]= true;
        currGold += grid[row][col];

        maxGold = Math.max(maxGold, currGold);

        helper(grid, row + 1, col, currGold );
        helper(grid, row - 1, col, currGold );
        helper(grid, row, col + 1, currGold );
        helper(grid, row, col - 1, currGold );
        
        visited[row][col] = false;
    }
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    helper(grid, i, j, 0);
                }
            }
        }
        return maxGold;
    }
}