class Solution {
    boolean visited[][];

    public int helper(int[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return 0;
        if(grid[row][col] == 0 || visited[row][col]) return 0; 

        visited[row][col]= true;
        

        int down = helper(grid, row + 1, col);
        int up = helper(grid, row - 1, col);
        int right = helper(grid, row, col + 1);
        int left = helper(grid, row, col - 1);
        
        visited[row][col] = false;
        return  grid[row][col] + Math.max(Math.max(down, up), Math.max(right, left));
    }
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxGold = 0;
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    maxGold = Math.max(maxGold, helper(grid, i, j));
                }
            }
        }
        return maxGold;
    }
}