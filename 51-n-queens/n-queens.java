class Solution {
    List<List<String>> ans ;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                board[i][j] = '.';
            }
        }
        helper(board, 0);
        return ans;
    }

    void helper(char[][] board, int row){
        int n = board.length;
        if(row == n){
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int col = 0; col < n; col++){
            if(isValid(board, n, row, col)){
                board[row][col] = 'Q';
                helper(board, row +1);
                board[row][col] = '.';
            }
        }
    }

    boolean isValid (char[][] board, int n, int row, int col){
        for(int j = row; j >= 0; j--){
            if(board[j][col] != '.') return false;
        }

        for(int i = row, j = col; i >= 0 && j>=0 ; i--,j--){
            if(board[i][j] != '.') return false;
        }
        for(int i = row, j = col ; i >= 0 && j <= n - 1; i--, j++){
            if(board[i][j] != '.') return false;
        }

        return true;
    }
}