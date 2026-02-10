class Solution {
    int maxSize = 0;
    int dp[][];
    public int helper(char[][] matrix, int i, int j){
        if(i >= matrix.length || j >= matrix[0].length) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        if(matrix[i][j] == '0'){
            dp[i][j] = 0;
            return 0;
        }
        int right = helper(matrix, i+1, j);
        int dig = helper(matrix, i+1, j+1);
        int down = helper(matrix , i, j+1);
        return dp[i][j] = 1 + Math.min(down, Math.min(right, dig));
    }
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] != '0'){
                    maxSize = Math.max(maxSize, helper(matrix, i, j));
                }
            }
        }
        return maxSize * maxSize;
    }
}